package com.cs406.xml;

import java.io.IOException;

/**
 * Interface definition for callbacks to be invoked during XML parsing.
 *
 * @author Ian Clement
 */
public interface ParseEventListener {

    /**
     * Called at the opening of an XML element (open tag "<").
     * @param name the name of the element.
     */
    void onOpenElementBegin(String name);

    /**
     * Called at the opening of an XML element (close tag ">).
     */
    void onOpenElementEnd();

    /**
     * Called at the closing of an XML element.
     * @param name the name of the element.
     */
    void onCloseElement(String name,int line, int pos) throws ParseException;

    /**
     * Called at the attribute of an XML element.
     * @param key the attribute key.
     * @param value the attribute value.
     */
    void onAttribute(String key, String value);

    /**
     * Called at an XML text element.
     * @param text the text of the element.
     */
    void onText(String text);

    /**
     * Called when a parse error occurs. After this, parsing stops.
     * @param error the parse error encountered.
     */
    void onParseError(ParseException error);

    /**
     * Called when an IO error occurs. After this, parsing stops.
     * @param error the IO error encountered.
     */
    void onIOError(IOException error);
}
