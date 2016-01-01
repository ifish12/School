package com.cs406.project;

import com.cs406.util.*;
import com.cs406.xml.Parser;

import java.io.ByteArrayInputStream;

/******************************************************DOMNODE**********************************************************

 Node class used for the tree.

 type: the type of what was encountered in the xml document (element, text)
 name: the name of the tag that was opened in the xml document
 attribute: attributes associated with the tag
 value: text that is not a tag or an attribute
 children: LinkedList of children nodes

***********************************************************************************************************************/

public class DOMNode {
    private String type;                                        //The type of the node
    private String name;                                        //Tag name of the node
    private String attribute;                                   //Attributes of the node
    private String value;                                       //Extra text for the node

    private LinkedList<DOMNode> children;                       //List of children nodes

    public DOMNode(){
        this.name = "";
        this.type = "";
        this.attribute = "";
        this.value = "";
        this.children = new LinkedList<DOMNode>();
    }

    public DOMNode(String s){
        this.children = new LinkedList<DOMNode>();
        this.name = s;
        this.type = "";
        this.attribute = "";
        this.value = "";
    }

    public void addChild(DOMNode e){
        children.add(e);
    }

    public String getValue(){
        return this.value;
    }

    public String getName(){
        return this.name;
    }

    public String getAttribute(){
        return this.attribute;
    }

    public String getType(){
        return this.type;
    }


    public void setValue(String val){
        this.value = val;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAttr(String attr){
        this.attribute += attr;
    }

    public void setType(String elem){
        this.type = elem;
    }


    public boolean hasNext(){   return children.hasNext();  }

    public void reset(){    children.reset();    }

    public DOMNode next(){return children.next();}

/*******************************************************getChild********************************************************

 Function returns the node at a given position. Uses curr to work through the children of the node. When curr is equal
 to the desired position, return that node. If this doesn't happen, there is no such child.

 cuurr: int value. Tracks the current node position
 position: int value. The position of the node that is wanted

***********************************************************************************************************************/

    public DOMNode getChild(int pos){
        int curr;                                                   //Position of current node
        children.reset();                                           //Reset traversal
        for(curr = 0; curr != pos && children.hasNext(); curr++){   //Work through children until node is found or no more children
            children.next();                                        //Go to next child
        }
        if(curr == pos)                                             //Position found?
            return children.next();                                 //Return the node
        else throw new ListTraversalException("No child at position: " + pos);
    }

    public void print(String lead){
        if(this.getType().equals("Element")) {                      //Current node an element?
            System.out.print(lead + "<" + this.getName());          //Print tag name

            if (!this.getAttribute().equals(""))                    //Node contains attributes?
                System.out.print(" " + this.getAttribute());        //Print attributes
            System.out.println(">");
            if(!this.getValue().equals(""))                             //Node has a value?
                System.out.println(lead + this.getValue());             //Print value
        }
        else
            System.out.println(lead + this.getValue());             //Print text of node
        this.reset();                                               //Reset traversal

        while(this.hasNext())                                       //Node has more children?
            this.next().print(lead + "    ");                       //Go to next level and print child node
        if(this.getType().equals("Element"))                        //Current node an element?
            System.out.println(lead + "</" + this.getName() + ">"); //Print closing tag
    }

    public int getSize(){
        return this.children.size();
    }

    public DOMNode getLastChild(){
        return this.getChild(this.children.size() - 1);
    }

/*****************************************************getElementById****************************************************

 Function returns a node containing the specified id. If none were found the function will return null.

 tmp: reference to the node to be returned. Null until node is found.

***********************************************************************************************************************/

    public DOMNode getElementById(String id) {
        this.reset();                                                     //Reset traversal
        DOMNode tmp = null;
        if (this.getAttribute().matches(".* id=\"" + id + "\" .*")) {     //id found in current node?
            tmp = this;                                                   //Set tmp to current node
            return tmp;                                                   //Return the node
        }
        while(this.hasNext() && tmp == null) {                            //Node has children and id not found?
            tmp = this.next().getElementById(id);                         //Search for id in next node
        }
        return tmp;                                                       //Return tmp
    }


/************************************************getElementsById********************************************************

 Function returns a list of nodes with a given tag name. If none are found the returned list is empty.

***********************************************************************************************************************/
    public LinkedList<DOMNode> getElementsByTag(String tagname, LinkedList<DOMNode> list){
        this.reset();                                                   //Reset traversal
        String name = this.getName();                                   //Get name of current node
        if(name.equals(tagname))                                        //Names match?
            list.add(this);                                             //Add current node to list
        while(this.hasNext())                                           //Current node has more children?
            list = this.next().getElementsByTag(tagname, list);         //Search children for tag name
        return list;                                                    //Return the list
    }

    public void setInnerHTML(String xml){
        this.children.clear();              //Delete children of current node
        DOMNode curr = this;                //Set current node
        XMLEcho e = new XMLEcho(curr);
        Parser parse = new Parser(new ByteArrayInputStream(xml.getBytes()), e);
        parse.parse();                      //Parse xml given by user
    }
}