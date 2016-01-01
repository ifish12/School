package com.cs406.xml;

import java.io.IOException;
import java.io.InputStream;

/**
 * The Lexer reads the XML from the input stream and converts the raw text into a sequence of tokens, called "lexemes",
 * used to simplify the algorithms in the parser.
 *
 * @author Ian Clement
 */
public class Lexer {

    // the source is set to use the position stream, which gives line numbers and positions.
    private PositionStream ips;

    // used to differentiate between plain text outside of a tag and attributes inside a tag.
    private boolean in_tag;

    // stores current lexeme
    private boolean hasCurrentLexeme;
    private Lexeme currentLexeme;

    public Lexer(InputStream is) throws IOException, ParseException {
        ips = new PositionStream(is);
        currentLexeme = null;//new Lexeme();
        in_tag = false;
        next();
    }


    // test character classes
    private boolean isWhitespace(char c) {
        return Character.isWhitespace(c); //TODO remove
    }

    private boolean isNameStartChar(char c) {
        return Character.isAlphabetic(c) || c == ':' || c == '_';
    }

    private boolean isNameChar(char c) {
        return isNameStartChar(c) || Character.isDigit(c) || c == '-' || c == '.';
      }


    // read symbols
    private String readName(char delim) throws IOException {

        StringBuilder sb = new StringBuilder();

        // verify that the first character is a proper starting NAME character
        char c = ips.peek();
        if(ips.hasNext() && isNameStartChar(c))
            sb.append(c);
        else
            return null;
        ips.ignore();

        c = ips.peek();
        while(ips.hasNext() && isNameChar(c)) { // util end-of-stream or a non-name character
            ips.ignore();
            sb.append(c);
            c = ips.peek();
        }

        // if we are at the end of a name we should only have whitespace or delimeter,
        //   anything else indicates an error
        if(ips.hasNext() && !isWhitespace(c) && c != delim)
            return null;
        else
            return sb.toString();
    }

    private String readText(char delim) throws IOException {
        StringBuilder sb = new StringBuilder();

        char c = ips.peek();
        // read until end-of-stream or delimeter
        while(ips.hasNext() && c != delim) {
            ips.ignore();
            sb.append(c);
            c = ips.peek();
        }
        return sb.toString();
    }

    // advance to next lexeme, detecting end of stream and throwing execeptions
    private void next() throws IOException, ParseException {
        // detect end-of-stream
        if(!ips.hasNext()) {
            hasCurrentLexeme = false;
            return;
        }

        int line = ips.getLine();
        int pos = ips.getPos();
        String value = "";
        Symbol type;

        switch(ips.peek()) {
            case '<':  // start a tag
                in_tag = true;
                ips.ignore();

                if(ips.peek() == '/') {  // "</"
                    type = Symbol.TAG_CLOSE;
                    ips.ignore();
                }
                else
                    type = Symbol.TAG_BEGIN;

                // read the tag's name
                value = readName('>');
                if(value == null)
                    throw new ParseException("Error: expected NAME at " + currentLexeme, ips.getLine(), ips.getPos());

                break;

            case '>': // end a tag
                type = Symbol.TAG_END;
                ips.ignore();
                in_tag = false;
                break;

            case '/': // start of close atomic tag
                ips.ignore();
                if(ips.peek() == '>') { // "/>"
                    ips.ignore();
                    type = Symbol.TAG_END_AND_CLOSE;
                    in_tag = false;
                }
                else
                    throw new ParseException("Error: expected '>' at " + currentLexeme, ips.getLine(), ips.getPos());

                break;

            case '=':
                type = Symbol.EQUALS_SIGN;
                ips.ignore();
                break;

            case '"': // start of VALUE (single quoted)
                ips.ignore();
                type = Symbol.ATTRIBUTE_VALUE;
                value = readText('"');
                if(value != null)
                    ips.ignore(); // consume a "
                break;

            case '\'': // start of VALUE (double quoted)
                ips.ignore();
                type = Symbol.ATTRIBUTE_VALUE;
                value = readText('\'');
                if(value != null)
                    ips.ignore(); // comsume a '
                break;

            default: // whitespace, attribute names or plain text

                char c = ips.peek();

                if(isWhitespace(c)) {
                    // eagerly consume whitespace
                    type = Symbol.WHITESPACE;
                    ips.ignore();
                    c = ips.peek();
                    while(ips.hasNext() && isWhitespace(c)){
                        ips.ignore();
                        c = ips.peek();
                    }
                }
                else {
                    // if we're in a tag: plain text should be an attribute name
                    // otherwise, it is "content"
                    if(in_tag) {
                        type = Symbol.ATTRIBUTE_NAME;
                        value = readName('=');
                        if(value == null)
                            throw new ParseException("Error: expected NAME at " + currentLexeme, ips.getLine(), ips.getPos());
                    }
                    else {
                        type = Symbol.CONTENT;
                        value = readText('<');
                    }
                }
        }

        // lexeme position in the position of the first character
        currentLexeme = new Lexeme(type, value, line, pos);

        // whenever we hit a whitespace lexeme, advance to the next lexeme
        if(currentLexeme.getType() == Symbol.WHITESPACE)
            next();
        else
            hasCurrentLexeme = true;
    }

    // public methods

    /**
     * Determine if end of the lexeme sequence has been reached.
     * @return true if the end of the lexeme sequence has been reached, false otherwise.
     */
    public boolean hasNext() { return hasCurrentLexeme; }

    /**
     * Peek at the stream to get the next lexeme without advancing.
     * @return the current lexeme.
     */
    public Lexeme peek() { return currentLexeme; }

    /**
     * Retrieve the current lexeme and advance to the next.
     * @return the current lexeme.
     * @throws ParseException
     * @throws IOException
     */
    public Lexeme accept() throws ParseException, IOException {
        if(!hasNext())
            throw new ParseException("Error: premature end of stream.", ips.getLine(), ips.getPos());
        Lexeme tmp = currentLexeme;
        next();
        return tmp;
    }

    /**
     * Retrieve the current lexeme, but throw an error if it is not of the expected type.
     * @param type
     * @return the current lexeme.
     * @throws ParseException
     * @throws IOException
     */
    public Lexeme expect(Symbol type) throws ParseException, IOException {
        if(!hasNext())
            throw new ParseException("Error: premature end of stream.", ips.getLine(), ips.getPos());
        if(currentLexeme.getType() != type)
            throw new ParseException("Error: expected " + type + " but saw " + currentLexeme, ips.getLine(), ips.getPos());
        return accept();
    }

    /**
     * Get the line number of the next lexeme in the stream.
     * @return the line number.
     */
    public int getLine() {
        return ips.getLine();
    }

    /**
     * Get the position of the next lexeme in the stream.
     * @return the position.
     */
    public int getPos() {
        return ips.getPos();
    }

}
