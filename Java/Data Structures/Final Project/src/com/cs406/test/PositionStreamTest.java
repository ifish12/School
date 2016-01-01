package com.cs406.test;

import com.cs406.xml.PositionStream;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by ian on 15-04-26.
 */
public class PositionStreamTest {

    private PositionStream stream;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testBasic() throws IOException {
        stream = new PositionStream(new FileInputStream("test/position/hello.txt"));
        char[] expected = "hello, world".toCharArray();
        for(int i=0; i < expected.length; i++)
            assertEquals(expected[i], stream.get());
        assertFalse(stream.hasNext());
    }

    @Test
    public void testPos() throws IOException {
        stream = new PositionStream(new FileInputStream("test/position/hello.txt"));
        for(int pos=1; pos <= "hello, world".length(); pos++, stream.get())
            assertEquals(pos, stream.getPos());
    }

    @Test
    public void testLine() throws IOException {
        stream = new PositionStream(new FileInputStream("test/position/hello_vert.txt"));
        for(int line=1; line <= "hello, world".length(); line++, stream.get())
            assertEquals(line, stream.getLine());
    }

    @Test
    public void testNewLine() throws IOException {
        stream = new PositionStream(new FileInputStream("test/position/abc.txt"));
        assertEquals(1, stream.getLine());
        assertEquals(1, stream.getPos());
        assertEquals('a', stream.get());
        assertEquals(3, stream.getLine());
        assertEquals(1, stream.getPos());
        assertEquals('b', stream.get());
        assertEquals(22, stream.getLine());
        assertEquals(1, stream.getPos());
        assertEquals('c', stream.get());
        assertFalse(stream.hasNext());
    }

    @Test
    public void testWindowsNewline() throws IOException {
        stream = new PositionStream(new FileInputStream("test/position/hello_vert_win.txt"));
        for(int line=1; line <= "hello, world".length(); line++, stream.get())
           assertEquals(line, stream.getLine());

    }

}
