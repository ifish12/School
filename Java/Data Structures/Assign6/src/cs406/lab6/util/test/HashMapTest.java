package com.cs406.util.test;

import com.cs406.util.Entry;
import com.cs406.util.HashMap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HashMapTest {

    private HashMap<String, Integer> map;

    @Before
    public void setUp() throws Exception {
        map = new HashMap<String, Integer>();
    }

    @Test
    public void testGetAndPut() { //", "[required]") {
        map.put("foo", 42);
        assertTrue(map.containsKey("foo"));
        assertTrue(map.get("foo") == 42);
        assertTrue(map.size() == 1);
    }

    @Test
    public void testNegativeKey() {
        HashMap<Integer, Void> map = new HashMap<Integer, Void>();
        map.put(-10, null);
    }

    @Test
    public void testUpdateValue() {//", "[required]" ) {
        map.put("foo", 42);
        int i = map.get("foo");
        map.put("foo", i + 1);
        assertTrue(map.get("foo") == 43);
        assertTrue(map.size() == 1);
    }

    @Test
    public void testMultipleEntries() {// ( "multiple key-value entrys", "[required]" ) {
        map.put("aardvark", 1);
        map.put("aardwolf", 2);
        map.put("albatross", 3);
        assertTrue(map.size() == 3);
        assertTrue(map.containsKey(new String("aardvark")));
        assertFalse(map.containsKey(new String("capybara")));
        assertTrue(map.get(new String("aardvark")) == 1);
    }

    @Test
    public void testTraversal() {//( "traversal", "[required]" ) {

        map.put("aardvark", 1);
        map.put("aardwolf", 2);
        map.put("albatross", 0);

        //SECTION( "Keys" )
        {

            String[] keys = {"aardvark", "aardwolf", "albatross"};
            int[] occurs = new int[3];

            map.reset();
            while (map.hasNext()) {
                Entry<String, Integer> e = map.next();
                boolean found = false;
                for (int i = 0; i < 3; i++)
                    if (keys[i].equals(e.getKey())) {
                        occurs[i]++;
                        found = true;
                        break;
                    }
                assertTrue(found);
            }

            for (int i = 0; i < 3; i++)
                assertTrue(occurs[i] == 1);
        }

        //SECTION( "Values" )
        {

            int[] occurs = new int[3];

            map.reset();
            while (map.hasNext()) {
                Entry<String, Integer> e = map.next();
                assertTrue(e.getValue() >= 0);
                assertTrue(e.getValue() <= 2);
                occurs[e.getValue()]++;
            }

            for (int i = 0; i < 3; i++)
                assertTrue(occurs[i] == 1);

        }

    }

    @Test
    public void testRehashing() { // ("rehashing", "[required]") {
        HashMap<Integer, Integer> squares = new HashMap<Integer, Integer>(10, 0.7);
        assertTrue(squares.getTotalBuckets() == 10);
        for (int i = 0; i < 10; i++)
            squares.put(i, i * i);

        assertTrue(squares.getTotalBuckets() == 20);

        //SECTION("Entries all accounted for") {
        for (int i = 0; i < 10; i++) {
            assertTrue(squares.containsKey(i));
            assertTrue(squares.get(i) == i * i);
        }
        //}

        //SECTION ( "Put still works" ) {
        squares.put(10, 100);
        assertTrue(squares.get(10) == 100);
        //}

        //SECTION ( "Remove still works and buckets never decrease" ) {
        squares.remove(5);
        assertTrue(squares.size() == 10);
        assertTrue(squares.getTotalBuckets() == 20);
        //}
    }
}