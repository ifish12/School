package com.cs406.xml;

/**
 * Types used by the Lexer to categorize the markup of the XML.
 *
 * @author Ian Clement
 */
public enum Symbol {
        TAG_BEGIN,              // <NAME
        TAG_END,                // >
        TAG_CLOSE,              // </NAME
        TAG_END_AND_CLOSE,      // />
        ATTRIBUTE_NAME,         // NAME
        EQUALS_SIGN,            // =
        ATTRIBUTE_VALUE,        // "TEXT"
        CONTENT,                // TEXT
        WHITESPACE
}
