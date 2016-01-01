package com.cs406.test;

import com.cs406.xml.ParseEventListener;
import com.cs406.xml.ParseException;
import com.cs406.xml.Parser;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ian on 15-04-27.
 */
public class ParserTest {

    private enum RecordEvent {
        ALL, ELEMENT, ATTRIBUTES, CONTENT
    }

    private class TestEventsHandler implements ParseEventListener {

        private List<String> list;
        private RecordEvent record;
        private boolean error;

        public TestEventsHandler(RecordEvent record) {
            list = new ArrayList<String>();
            this.record = record;
        }

        public List<String> getList() {
            return list;
        }

        public boolean isError() {
            return error;
        }

        @Override
        public void onOpenElementBegin(String name) {
            if(record == RecordEvent.ALL || record == RecordEvent.ELEMENT)
                list.add("onOpenElementBegin(" + name + ")");
        }

        @Override
        public void onOpenElementEnd() {
            if(record == RecordEvent.ALL || record == RecordEvent.ELEMENT)
                list.add("onOpenElementEnd()");
        }

        @Override
        public void onCloseElement(String name, int line, int pos) {
            if(record == RecordEvent.ALL || record == RecordEvent.ELEMENT)
                list.add("onCloseElement(" + name + ")");
        }

        @Override
        public void onAttribute(String key, String value) {
            if(record == RecordEvent.ALL || record == RecordEvent.ATTRIBUTES)
                list.add("onAttribute(" + key + ", " + value + ")");
        }

        @Override
        public void onText(String text) {
            if(record == RecordEvent.ALL || record == RecordEvent.CONTENT)
                list.add("onText(" + text + ")");
        }

        @Override
        public void onParseError(ParseException error) {
            this.error = true;
        }

        @Override
        public void onIOError(IOException error) {
            this.error = true;
        }
    }

    private Parser parser;

    private InputStream stringToStream(String s) {
        return new ByteArrayInputStream(s.getBytes(StandardCharsets.US_ASCII));
    }

    @Test
    public void testOpenTag() {
        TestEventsHandler handler = new TestEventsHandler(RecordEvent.ALL);
        parser = new Parser(stringToStream("<a foo='bar'>hello, world</a>"), handler);
        parser.parse();
        ArrayList<String> order = new ArrayList<String>();
        order.add("onOpenElementBegin(a)");
        order.add("onAttribute(foo, bar)");
        order.add("onOpenElementEnd()");
        order.add("onText(hello, world)");
        order.add("onCloseElement(a)");
        assertEquals(order, handler.getList());
    }

    @Test
    public void testElements() {
        TestEventsHandler handler = new TestEventsHandler(RecordEvent.ELEMENT);
        parser = new Parser(stringToStream("<a><b></b><c></c></a>"), handler);
        parser.parse();
        ArrayList<String> order = new ArrayList<String>();
        order.add("onOpenElementBegin(a)");
        order.add("onOpenElementEnd()");
        order.add("onOpenElementBegin(b)");
        order.add("onOpenElementEnd()");
        order.add("onCloseElement(b)");
        order.add("onOpenElementBegin(c)");
        order.add("onOpenElementEnd()");
        order.add("onCloseElement(c)");
        order.add("onCloseElement(a)");
        assertEquals(order, handler.getList());
    }

    @Test
    public void testAttributes() {
        TestEventsHandler handler = new TestEventsHandler(RecordEvent.ATTRIBUTES);
        parser = new Parser(stringToStream("<a foo='bar'><b bar='foo'></b></a>"), handler);
        parser.parse();
        ArrayList<String> order = new ArrayList<String>();
        order.add("onAttribute(foo, bar)");
        order.add("onAttribute(bar, foo)");
        assertEquals(order, handler.getList());
    }

    @Test
    public void testContent() {
        TestEventsHandler handler = new TestEventsHandler(RecordEvent.CONTENT);
        parser = new Parser(stringToStream("<a><item>one</item><item>two</item><item>three</item></a>"), handler);
        parser.parse();
        ArrayList<String> order = new ArrayList<String>();
        order.add("onText(one)");
        order.add("onText(two)");
        order.add("onText(three)");
        assertEquals(order, handler.getList());
    }

    @Test
    public void testTagInTagError() {
        TestEventsHandler handler = new TestEventsHandler(RecordEvent.ALL);
        parser = new Parser(stringToStream("<a <b> />"), handler);
        parser.parse();
        assertTrue(handler.isError());
    }

    @Test
    public void testTextInTagsError() {
        TestEventsHandler handler = new TestEventsHandler(RecordEvent.ALL);
        parser = new Parser(stringToStream("<a hello, world>"), handler);
        parser.parse();
        assertTrue(handler.isError());
    }

    @Test
    public void testTextCanContainEqualsAndQuotes() {
        TestEventsHandler handler = new TestEventsHandler(RecordEvent.ALL);
        parser = new Parser(stringToStream("<a>foo = 'bar'</a>"), handler);
        parser.parse();
        assertFalse(handler.isError());
    }

    @Test
    public void testValueContainsDoubleQuotes() {
        TestEventsHandler handler = new TestEventsHandler(RecordEvent.ALL);
        parser = new Parser(stringToStream("<a foo=\"bar\"\"></a>"), handler);
        parser.parse();
        assertTrue(handler.isError());
    }

    @Test
    public void testValueContainsSingleQuotes() {
        TestEventsHandler handler = new TestEventsHandler(RecordEvent.ALL);
        parser = new Parser(stringToStream("<a foo='bar''></a>"), handler);
        parser.parse();
        assertTrue(handler.isError());
    }

    @Test
    public void testParseMoreThanOneRoot() {
        TestEventsHandler handler = new TestEventsHandler(RecordEvent.ALL);
        parser = new Parser(stringToStream("<a></a><b></b>"), handler);
        parser.parse();

        ArrayList<String> order = new ArrayList<String>();
        order.add("onOpenElementBegin(a)");
        order.add("onOpenElementEnd()");
        order.add("onCloseElement(a)");
        assertEquals(order, handler.getList());

        assertTrue(parser.hasNext());

        handler.getList().clear();
        parser.parse();

        order = new ArrayList<String>();
        order.add("onOpenElementBegin(b)");
        order.add("onOpenElementEnd()");
        order.add("onCloseElement(b)");
        assertEquals(order, handler.getList());
    }

    @Test
    public void testParseMultipleRootsInLoop() {
        TestEventsHandler handler = new TestEventsHandler(RecordEvent.ALL);
        ArrayList<String> order = new ArrayList<String>();
        order.add("onOpenElementBegin(a)");
        order.add("onOpenElementEnd()");
        order.add("onCloseElement(a)");

        parser = new Parser(stringToStream("<a></a><a></a><a></a><a></a><a></a><a></a><a></a><a></a><a></a>"), handler);
        while(parser.hasNext()) {
            parser.parse();
            assertEquals(order, handler.getList());
            handler.getList().clear();
        }
    }

}
