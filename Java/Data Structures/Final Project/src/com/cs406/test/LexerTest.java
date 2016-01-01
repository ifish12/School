package com.cs406.test;

import com.cs406.xml.Lexeme;
import com.cs406.xml.Lexer;
import com.cs406.xml.ParseException;
import com.cs406.xml.Symbol;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

/**
 * Created by ian on 15-04-26.
 */
public class LexerTest {

    private Lexer lexer;

    @Before
    public void setUp() throws Exception {

    }

    private void readAllLexemes() throws IOException, ParseException {
        while(lexer.hasNext())
            lexer.accept();
    }

    private InputStream stringToStream(String s) {
        return new ByteArrayInputStream(s.getBytes(StandardCharsets.US_ASCII));
    }


    @Test
    public void testSimpleTags() throws IOException, ParseException {
        lexer = new Lexer(stringToStream("<a><b></b></a>"));
        assertEquals(new Lexeme(Symbol.TAG_BEGIN, "a"), lexer.accept());
        assertEquals(new Lexeme(Symbol.TAG_END, ""), lexer.accept());
        assertEquals(new Lexeme(Symbol.TAG_BEGIN, "b"), lexer.accept());
        assertEquals(new Lexeme(Symbol.TAG_END, ""), lexer.accept());
        assertEquals(new Lexeme(Symbol.TAG_CLOSE, "b"), lexer.accept());
        assertEquals(new Lexeme(Symbol.TAG_END, ""), lexer.accept());
        assertEquals(new Lexeme(Symbol.TAG_CLOSE, "a"), lexer.accept());
        assertEquals(new Lexeme(Symbol.TAG_END, ""), lexer.accept());
    }

    @Test
    public void testAtomicTags() throws IOException, ParseException {
        lexer = new Lexer(stringToStream("<a /><b />"));
        assertEquals(new Lexeme(Symbol.TAG_BEGIN, "a"), lexer.accept());
        assertEquals(new Lexeme(Symbol.TAG_END_AND_CLOSE, ""), lexer.accept());
        assertEquals(new Lexeme(Symbol.TAG_BEGIN, "b"), lexer.accept());
        assertEquals(new Lexeme(Symbol.TAG_END_AND_CLOSE, ""), lexer.accept());

    }

    @Test
    public void testAttributes() throws IOException, ParseException {
        lexer = new Lexer(stringToStream("<a id=\"foo\" name='hello, world' />"));
        assertEquals(new Lexeme(Symbol.TAG_BEGIN, "a"), lexer.accept());
        assertEquals(new Lexeme(Symbol.ATTRIBUTE_NAME, "id"), lexer.accept());
        assertEquals(new Lexeme(Symbol.EQUALS_SIGN, ""), lexer.accept());
        assertEquals(new Lexeme(Symbol.ATTRIBUTE_VALUE, "foo"), lexer.accept());
        assertEquals(new Lexeme(Symbol.ATTRIBUTE_NAME, "name"), lexer.accept());
        assertEquals(new Lexeme(Symbol.EQUALS_SIGN, ""), lexer.accept());
        assertEquals(new Lexeme(Symbol.ATTRIBUTE_VALUE, "hello, world"), lexer.accept());
        assertEquals(new Lexeme(Symbol.TAG_END_AND_CLOSE, ""), lexer.accept());
    }

    @Test
    public void testContent() throws IOException, ParseException {
        lexer = new Lexer(stringToStream("<a>hello, world</a>"));
        assertEquals(new Lexeme(Symbol.TAG_BEGIN, "a"), lexer.accept());
        assertEquals(new Lexeme(Symbol.TAG_END, ""), lexer.accept());
        assertEquals(new Lexeme(Symbol.CONTENT, "hello, world"), lexer.accept());
        assertEquals(new Lexeme(Symbol.TAG_CLOSE, "a"), lexer.accept());
        assertEquals(new Lexeme(Symbol.TAG_END, ""), lexer.accept());
    }

    @Test (expected = ParseException.class)
    public void testInvalidNameNumbers() throws IOException, ParseException {
        lexer = new Lexer(stringToStream("<80s />"));
        readAllLexemes();
    }

    @Test (expected = ParseException.class)
    public void testInvalidNameNonAlpha() throws IOException, ParseException {
        lexer = new Lexer(stringToStream("<hello! />"));
        readAllLexemes();
    }

    /* These errors are only caught at the parser level. See the tests there...
    @Test (expected = ParseException.class)
    public void testInvalidValueDoubleQuotes() throws IOException, ParseException {
        lexer = new Lexer(stringToStream("<a foo=\"bar\"\"/><b></b>"));
        readAllLexemes();
    }

    @Test (expected = ParseException.class)
    public void testInvalidValueSingleQuotes() throws IOException, ParseException {
        lexer = new Lexer(stringToStream("<a foo='bar''/>"));
        readAllLexemes();
    }
    */

    @Test (expected = ParseException.class)
    public void testInvalidContentLT() throws IOException, ParseException {
        lexer = new Lexer(stringToStream("<a> 2 < 3 </a>"));
        readAllLexemes();
    }

    @Test
    public void testTailingWhitespace() throws IOException, ParseException {
        lexer = new Lexer(stringToStream("<a "));
        assertEquals(new Lexeme(Symbol.TAG_BEGIN, "a"), lexer.accept());
    }

}
