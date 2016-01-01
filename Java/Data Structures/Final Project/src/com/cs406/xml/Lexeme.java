package com.cs406.xml;

/**
 * Represents a "lexeme" in the processing of XML.
 *
 * @author Ian Clement
 */
public class Lexeme {

        private Symbol type;
        private String value;
        private int line;
        private int pos;

        public Lexeme(Symbol type, String value) {
                this(type, value, -1, -1);
        }

        public Lexeme(Symbol type, String value, int line, int pos) {
                this.type = type;
                this.value = value;
                this.line = line;
                this.pos = pos;
        }

        public Symbol getType() {
                return type;
        }

        public String getValue() {
                return value;
        }

        public int getLine() {
                return line;
        }

        public int getPos() {
                return pos;
        }

        @Override
        public String toString() {
                return "Lexeme{" +
                        "type=" + type +
                        ", value='" + value + '\'' +
                        ", line=" + line +
                        ", pos=" + pos +
                        '}';
        }

        @Override
        public boolean equals(Object rhs) {
                Lexeme rhsL = (Lexeme)rhs;
                return type == rhsL.type && value.equals(rhsL.value);
        }
}
