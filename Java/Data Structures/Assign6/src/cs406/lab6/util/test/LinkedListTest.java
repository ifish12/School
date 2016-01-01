package com.cs406.util.test;

import com.cs406.util.LinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    private LinkedList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new LinkedList<Integer>();
        for(int i=0; i<10; i++)
            list.add(i);

    }

    @Test
    public void testGet() {
        for(int i=0; i<10; i++)
            assertEquals(new Integer(i), list.get(i));
    }

    @Test
    public void testTraversal() {
        list.reset();
        for(int i=0; i<10 && list.hasNext(); i++)
            assertEquals(new Integer(i), list.next());

    }

    @Test
    public void testSize() {
        assertFalse(list.isEmpty());
        assertEquals(10, list.size());
    }

    @Test
    public void testAdd() {
        list.add(list.size(), 10);
        assertEquals(new Integer(10), list.get(10));

    }

    @Test
    public void testSet() {
        for(int i=0; i<10; i++)
            assertEquals(new Integer(i), list.set(i, i + 5));
        for(int i=0; i<10; i++)
            assertEquals(new Integer(i + 5), list.get(i));
    }

    @Test
    public void testClear() {
        list.clear();
        assertTrue(list.isEmpty());

    }

    @Test
    public void testAdd2() {
        for(int i=0; i<10; i++)
            list.add(0, i);
        for(int i=0; i<10; i++)
            assertEquals(new Integer(9-i), list.get(i));

        list.add(5, 1000);
        assertEquals(new Integer(1000), list.get(5));
    }

    @Test
    public void testRemove() {
        for(int i=0; i<3; i++)
            assertEquals(new Integer(i+2), list.remove(2));
        assertEquals(7, list.size());
        assertEquals(new Integer(1), list.get(1));
        assertEquals(new Integer(5), list.get(2));
        assertEquals(new Integer(9), list.get(6));


        // test remove
        while(!list.isEmpty())
            list.remove(0);
        assertEquals(0, list.size());
    }

}