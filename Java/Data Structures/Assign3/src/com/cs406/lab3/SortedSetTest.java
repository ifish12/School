package com.cs406.lab3;

import com.cs406.util.EmptySetException;
import com.cs406.util.FullSetException;
import com.cs406.util.SortedSet;
import com.cs406.util.TraversalException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedSetTest {

    private SortedSet<Integer> set;

    @Before
    public void setUp() throws Exception {
        set = new SortedSet<Integer>();
        set.add(254);
        set.add(54);
        set.add(224);
        set.add(234);
        set.add(2);
        set.add(224);
        set.add(26);
        set.add(435);
    }

    @Test
    public void testConstructorMakesEmptySet() {
        set = new SortedSet<Integer>();
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }

    @Test
    public void testContains()  {
        assertTrue( set.contains(26) );   // low end
        assertTrue( set.contains(224) );  // middle
        assertTrue( set.contains(435) );  // high end
        assertFalse( set.contains(21) );  // low end
        assertFalse( set.contains(123) ); // middle
        assertFalse( set.contains(500) );  // high end
    }

    @Test
    public void testAdd()  {
        System.out.print("I am inside testAdd");
        assertFalse(set.add(26));
        assertFalse(set.add(26));
        assertTrue( set.add(1) );
        assertTrue( set.add(321) );
        assertTrue( set.add(973) );
        assertTrue( set.add(4) );
        assertFalse(set.add(973));
    }


    @Test
    public void testRemove()  {
        System.out.print("I am inside testRemove");
        assertTrue(set.remove(26));
        assertTrue( set.remove(15) );
        assertFalse(set.remove(731) );
    }
    @Test
    public void testNoDuplicates() {
        // TODO
    }

    @Test
    public void testFullSet() {
        assertFalse(set.isFull());
    }

    @Test (expected = FullSetException.class)
    public void testFullSetException() {
        // TODO
    }


    @Test
    public void testEmptySet() {
        assertFalse(set.isEmpty());
    }

    @Test
    public void testRemoveOnEmptySet() {
        // TODO
    }

    @Test
    public void testMin()  {
        assertFalse(set.size() == 1);
    }

    @Test
    public void testMax()  {
        assertFalse(set.size() == 100);
    }
    
    @Test
    public void testMinMaxInSingletonSet() {
        // TODO
    }
    /*
    @Test (expected = EmptySetException.class)
    public void testMinOnEmptySet() {
        SortedSet<Integer> set = new SortedSet<>();
        set.min();
    }

    @Test (expected = EmptySetException.class)
    public void testMaxOnEmptySet() {
        SortedSet<Integer> set = new SortedSet<>();
        set.max();
    }

    @Test
    public void testTraversal() {
        set.reset();
        assertTrue(set.hasNext());
        assertTrue(set.next() == 26);
        assertTrue(set.hasNext());
        assertTrue(set.next() == 54);
        assertTrue(set.hasNext());
        assertTrue(set.next() == 224);
        assertTrue(set.hasNext());
        assertTrue(set.next() == 234);
        assertTrue(set.hasNext());
        assertTrue(set.next() == 254);
        assertTrue(set.hasNext());
        assertTrue(set.next() == 435);
        assertFalse(set.hasNext());
    }

    @Test
    public void testTraversalWithoutError() {
        set.reset();
        try {
            while (set.hasNext())
                set.next();
        }
        catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testTraversalEmptySet() {
        SortedSet<Integer> set = new SortedSet<>();
        set.reset();
        assertFalse(set.hasNext());
    }

    @Test (expected = TraversalException.class)
    public void testAddDuringTraversal() {
        set.reset();
        set.next();
        set.add(123);
        set.next();
    }

    @Test (expected = TraversalException.class)
    public void testCallNextOnCompletedTraversal() {
        set.reset();
        while(set.hasNext())
            set.next();
        set.next();
    }

    @Test
    public void testIsSubset()  {
        int capacity = 100;
        SortedSet<Integer> all = new SortedSet<Integer>(capacity);
        SortedSet<Integer> even = new SortedSet<Integer>(capacity);
        for (int i = 0; i < capacity; i++) {
            all.add(i);
            if (i % 2 == 0)
                even.add(i);
        }

        assertTrue(even.isSubset(all));
        assertFalse(all.isSubset(even));

        // remove from subset
        even.remove(2);
        assertTrue(even.isSubset(all));
        even.add(2);

        // remove from superset
        all.remove(2);
        assertFalse(even.isSubset(all));

        // empty set is subset of all sets
        SortedSet<Integer> empty = new SortedSet<>();
        assertTrue(empty.isSubset(even));
        assertFalse(even.isSubset(empty));


        // equal sets are subsets of each other
        SortedSet<Integer> all2 = new SortedSet<>();
        all.reset();
        while (all.hasNext())
            all2.add(all.next());
        assertTrue(all2.isSubset(all));
        assertTrue(all.isSubset(all2));

        // another way this might occur:
        assertTrue(all.isSubset(all));
    }
*/
}
