package com.cs406.project;

import com.cs406.xml.ParseEventListener;
import com.cs406.xml.ParseException;

import java.io.IOException;
import java.util.*;

/***************************************************XMLECHO*************************************************************

 Class contains the methods used in the creation of the DOM tree.

 onElementBegin: when a tag is opened, the function will create a node for it and add it to the tree
 onCloseElement: when a tag is closed, function makes sure the closing tag matches the opening tag and sets the current
                 node to it's parent node
 onText: when text outside of a tag is encountered, function creates a node for it and adds it the children of the
         current node
 onAttribute: when an attribute of a tag is encountered: function adds it to the current node

 names: Stack of names encountered
 curr: the current node being interrogated
 tmp: the node that is to be added to the children of curr
 nodes: stack of created nodes

***********************************************************************************************************************/

public class XMLEcho implements ParseEventListener {
    private Stack<String> names = new Stack<String>();
    private Stack<DOMNode> nodes = new Stack<DOMNode>();
    DOMNode curr;       //Current node
    DOMNode tmp;        //Temporary variable. Used to create new nodes

    public XMLEcho(DOMNode r){
        this.curr = r;      //Set curr to root node
    }

/****************************************************onElementBegin*****************************************************

 Function creates each new node for the tree. Called when parser encounters a new tag. If curr is not equal to the root,
 tmp is used as a temporary node and is added to children of curr. Stacks names and nodes are used for tracking purposes.
 Names tracks the names of each element in the order they were found. Used when closing a tag, if the names do
 match the xml document has an error. Nodes tracks the order of nodes created. Used when closing a tag to go back to the
 parent of the current node.

 If a <br> tag is encountered, the text is added to the last node that was created. This node is found by taking the
 last child of the current node.

***********************************************************************************************************************/
    @Override
    public void onOpenElementBegin(String name) {
        if (name.equals("br")) {                    //Element parsed a <br> tag?
            DOMNode tmp = curr.getLastChild();      //Get last node created
            tmp.setValue("<br />");                 //Add text to node
        }
        else {
            if (curr.getName().equals("")) {        //Curr equal to the root?
                curr.setName(name);                 //Set tag name of curr
            }
            else {
                tmp = new DOMNode(name);            //Create new node with a the tag name
                curr.addChild(tmp);                 //Add node to curr's children
                curr = tmp;                         //Make current node the newest node
            }

            nodes.add(curr);                        //Add curr to list of nodes
            curr.setType("Element");                //Set the type of curr
            names.add(name);                        //Add tag name to list of names
        }
    }

    @Override
    public void onOpenElementEnd() {

    }

/****************************************************onCloseElement*****************************************************

 Function compares the current name in the xml document to the next name in names stack. If they do not match, an error
 occurred in the xml document. If they match, the next node in nodes is removed and curr becomes the top of the stack.
 If name is br, there is no matching node and this step is skipped. When the nodes stack is empty, curr was the root and
 the DOM tree is done.

***********************************************************************************************************************/

    @Override
    public void onCloseElement(String name, int line, int pos) throws ParseException {
        // TODO: verify that this element being closed matches the order they we're opened in. Hint: use a Stack.
        if (!name.equals("br")) {                                                   //Parsing a <br> tag?
            String expected = names.pop();
            if (!name.equals(expected))                                          //Name equal to next val from names?
                throw new ParseException("Unmatched closing tag. Expected: " + expected + " Given: " + name, line, pos);
            nodes.pop();                                                            //Remove curr from nodes stack
            if (!nodes.empty())                                                     //Stack empty?
                curr = nodes.peek();                                                //Set curr to it's parent noe
        }
    }

    @Override
    public void onAttribute(String key, String value) {
        String attr = " " + key + "=\"" + value + "\"";                             //Set the attribute text of curr
        curr.setAttr(attr);
    }

/*******************************************************onText**********************************************************

 Function is called when plain text is encountered in the xml document. Will create a node of type text, set it's value
 to the string found in the xml document and adds it to the list of children nodes. No tag name associated to this and
 plain text can have no children.

***********************************************************************************************************************/

    @Override
    public void onText(String text) {
        tmp = new DOMNode();            //Create a new node
        tmp.setValue(text);             //Set value to text
        tmp.setType("Text");            //Set the type
        curr.addChild(tmp);             //Add to list of children
    }

    @Override
    public void onParseError(ParseException error) {
        System.err.println("Parse Error at (" + error.getLine() + ", " + error.getPosition() + ")");
        error.printStackTrace(System.err);
    }

    @Override
    public void onIOError(IOException error) {
        error.printStackTrace(System.err);
    }

}
