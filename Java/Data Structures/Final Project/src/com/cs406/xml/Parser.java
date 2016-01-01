package com.cs406.xml;

import java.io.IOException;
import java.io.InputStream;

/**
 * A simple parser that uses callbacks for processing the XML elements found in the input stream.
 *
 * @author Ian Clement
 */
public class Parser {

    private ParseEventListener event;
    private Lexer lexer;

    public Parser(InputStream is, ParseEventListener event) {
        this.event = event;
        try {
            lexer = new Lexer(is);
        }
        catch (ParseException e) {
            event.onParseError(e);
        }
        catch (IOException e) {
            event.onIOError(e);
        }
    }

    /**
     * Perform the parse of the input stream with the event listener, both specified in the construction of the parser.
     * Parses one root only, i.e.: stops at the end of the root.
     */
    public void parse() {
        try {
            parseElement();
        }
        catch (ParseException e) {
            event.onParseError(e);
        }
        catch (IOException e) {
            event.onIOError(e);
        }
    }

    /**
     * Check to see if there is anything left to parse (in the case when parsing a sequence of roots).
     * @return true if there is anything left to parse, false otherwise.
     */
    public boolean hasNext() {
        return lexer.hasNext();
    }

    private void parseElement() throws ParseException, IOException  {
        Lexeme l = lexer.peek();

        if(l.getType() == Symbol.TAG_BEGIN) {
            String currentName = l.getValue();
            event.onOpenElementBegin(currentName);
            lexer.accept();
            //dom::node* current = new dom::node(d, ELEMENT, l.value);

            parseAttributes();

            l = lexer.peek();
            if(l.getType() != Symbol.TAG_END && l.getType() != Symbol.TAG_END_AND_CLOSE)
                throw new ParseException("Unexpected symbol: " + l + ")... Expected (TAG_END) or (TAG_END_AND_CLOSE)", lexer.getLine(), lexer.getPos());
            lexer.accept();
            event.onOpenElementEnd();

            if(l.getType() == Symbol.TAG_END_AND_CLOSE) {
                event.onCloseElement(currentName, lexer.getLine(), lexer.getPos());
                return;
            }

            parseElements();

            l = lexer.expect(Symbol.TAG_CLOSE);
            event.onCloseElement(l.getValue(), l.getLine(), l.getPos());
//            if(!l.getValue().equals(currentName))
//                throw new ParseException("Parse Error: mismatched tag (" + l + ")", lexer.getLine(), lexer.getPos());
            lexer.expect(Symbol.TAG_END);

        }

    }

    private void parseAttributes() throws ParseException, IOException {

        // from grammar rules: when we no longer see an NAME, we're done with the list.
        while(lexer.peek().getType() == Symbol.ATTRIBUTE_NAME) {
            // grammar rule states that attributes are NAME, then =, then VALUE.
            String name = lexer.accept().getValue();
            lexer.expect(Symbol.EQUALS_SIGN);
            Lexeme l = lexer.expect(Symbol.ATTRIBUTE_VALUE);
            event.onAttribute(name, l.getValue());
        }
    }

    private void parseElements() throws IOException, ParseException {

        // from grammar rules: when we see a '<', were done with plain text.
        // also --> when lexer is exhausted.
        while(lexer.hasNext() && lexer.peek().getType() != Symbol.TAG_CLOSE) {
            Lexeme l = lexer.peek();

            if(l.getType() == Symbol.CONTENT) {
                event.onText(l.getValue());
                lexer.accept();
            }
            else if(l.getType() == Symbol.TAG_BEGIN) {
                // parse the element
                parseElement();
            }
            else
                throw new ParseException("Error: unexpected symbol " + l + ")... Expected (TAG_CLOSE)", lexer.getLine(), lexer.getPos());
        }
    }

}
