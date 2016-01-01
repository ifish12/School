package com.cs406.test;

import com.cs406.util.LinkedList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.cs406.project.*;
import com.cs406.xml.Parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class DOMOperationsTest {
    private DOMNode root;
    private Parser parser;
    private XMLEcho echo;
    private LinkedList<DOMNode> list;

    @Before
    public void setUp() throws FileNotFoundException{
        root = new DOMNode();
        echo = new XMLEcho(root);
        list = new LinkedList<DOMNode>();
        parser = new Parser(new FileInputStream("test/starwars.xml"), echo);
        parser.parse();
    }

    @Test
    public void testGetChild(){
        assertEquals(root.getChild(0).getName(), "movie");
        assertEquals(root.getChild(0).getChild(4).getName(), "plot");
        assertEquals(root.getChild(0).getChild(5).getChild(0).getName(), "actor");
    }

    @Test
    public void testGetElementById(){
        assertEquals(root.getElementById("starwars").getName(), "movie");
        assertEquals(root.getElementById("hamill").getName(), "actor");
        assertEquals(root.getElementById("lucas").getName(), "director");
        assertEquals(root.getElementById("star"), null);
        assertEquals(root.getElementById("luca"), null);
    }

    @Test
    public void testGetElementsByTag(){
        assertEquals(root.getElementsByTag("actor", list).size(), 3);
        list.clear();
        assertEquals(root.getElementsByTag("genre", list).size(), 3);
        list.clear();
        assertEquals(root.getElementsByTag("cast", list).size(), 1);
        list.clear();
        assertEquals(root.getElementsByTag("ack", list).size(), 0);
    }

    @Test
    public void testSetInnerHTML(){
        DOMNode t = root.getChild(0).getChild(4);
        t.setInnerHTML("<p>Test</p>");
        assertEquals(t.getChild(0).getName(), "p");
        assertEquals(t.getChild(0).getChild(0).getValue(), "Test");

        t = root.getChild(0).getChild(2);
        t.setInnerHTML("<p><a>Test</a></p>");
        assertEquals(t.getChild(0).getName(), "p");
        assertEquals(t.getChild(0).getChild(0).getName(), "a");
        assertEquals(t.getChild(0).getChild(0).getChild(0).getValue(), "Test");

        t = root.getChild(0);
        t.setInnerHTML("<p></p>");
        assertEquals(t.getSize(), 1);

    }
}
