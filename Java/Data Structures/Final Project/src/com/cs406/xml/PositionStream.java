package com.cs406.xml;

import java.io.IOException;
import java.io.InputStream;

/**
 * Used to read an input stream character by character while recording current line and column positions.
 *
 * @author Ian Clement
 */
public class PositionStream {
    private InputStream is;
    private char current;
    private int line;
    private int pos;
    private boolean endOfStream;

    public PositionStream(InputStream is) throws IOException {
        this.is = is;
        endOfStream = false;
        line = 1;
        get();
    }

    /**
     * Determine if the stream is done.
     * @return if the stream is done.
     */
    public boolean hasNext() {
        return !endOfStream;
    }

    /**
     * Get the next character in the stream (non-newline).
     * @return the next character in the stream.
     * @throws IOException
     */
    public char get() throws IOException {
        char tmp = current;
        boolean isNewLineChar;
        do {
            isNewLineChar = false;
            int character = is.read();
            if(character < 0) {
                endOfStream = true;
                break;
            }
            current = (char) character;
            if(current == '\n') {
                line++;
                pos = 0;
                isNewLineChar = true;
            }
            else if(current == '\r')
                isNewLineChar = true;
            else
                pos++;
        } while (isNewLineChar);
        return tmp;
    }

    /**
     * Peek at the stream to get the next character without advancing.
     * @return the next character in the stream.
     */
    public char peek() {
        return current;
    }

    /**
     * Ignore the next character in the stream.
     * @throws IOException
     */
    public void ignore() throws IOException {
        get();
    }

    /**
     * Get the line number of the next character in the stream.
     * @return the line number.
     */
    public int getLine() {
        return line;
    }

    /**
     * Get the position of the next character in the stream.
     * @return the position.
     */
    public int getPos() {
        return pos;
    }
}
