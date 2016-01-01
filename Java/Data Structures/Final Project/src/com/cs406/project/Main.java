package com.cs406.project;

import com.cs406.xml.Parser;

import java.io.FileInputStream;
import java.io.IOException;

/*****************************************************ID BLOCK**********************************************************

 Due Date:      May 19, 2015
 Deliverable:   DOMTree
 Programmers:   Ryan Carrier, Geoff Shapiro

 Description:   Program uses a parser to read an xml file. The parser calls methods onOpenElementBegin, onOpenElementEnd,
                onAttribute, onText, and onCloseElement as it encounters these occurrences. These methods are used to
                to build a DOM tree representation of the xml document.

                The DOMNode class contains operations getElementById, getElementsByTag, setInnerHTML, and print.
                - getElementById: returns the node that contains a specified id. If none occurred, will return null.
                - getElementsByTag: returns a list of nodes with a specified tag name. Empty list if none found.
                - setInnerHTML: deletes all children of the current node. Parser reads desired xml input and creates
                  a new tree with the current node as root (i.e. sets the children of a node to specified text).
                - print: prints the DOM tree with current node as root in a proper xml style.

***********************************************************************************************************************/

public class Main {

    public static void main(String[] args) throws IOException {
        DOMNode root = new DOMNode();                                                       //The root of the DOM tree
        XMLEcho echo = new XMLEcho(root);                                                   //Give echo a reference to root
        Parser parser = new Parser(new FileInputStream("test/starwars.xml"), echo);
        parser.parse();                                                                     //Begin parsing
        root.print("");                                                                     //Print the tree
    }
}