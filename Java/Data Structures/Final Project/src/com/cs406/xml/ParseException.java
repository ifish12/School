package com.cs406.xml;

/**
 * Created by ian on 15-04-09.
 */
public class ParseException extends Exception {
    private int line;
    private int position;

    public ParseException(String message, int line, int position) {
        super(message);
        this.line = line;
        this.position = position;
    }

    public int getLine() {
        return line;
    }

    public int getPosition() {
        return position;
    }
}
