package com.cs406.util;

/**
 * DESCRIBE THIS DATA STRUCTURE
 *
 * @author YOU
 */
public class SortedSet<T extends Comparable> {
    private static final int DEFAULT_CAPACITY = 100;

    private T[] elements;
    private int size;
    private int current;
    private int capacity;

    public SortedSet() {
        this(DEFAULT_CAPACITY);
    }

    public SortedSet(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.elements = (T[]) new Comparable[capacity];
    }

    /**
     * Check if an element is in the set.
     * @param elem the element to check
     * @return true if the element is in the set, false otherwise.
     */
    public boolean contains(T elem) {
        // binary search
        int left = 0;
        int right = size - 1;

        while(left <= right)
        {
            int mid = (left + right) / 2;  // find middle position with integer division

            /* use the `x.compareTo(y)` method of the `Comparable`
                result < 0  => x < y
                result == 0 => x = y
                result > 0  => x > y
             */
            int comp = elem.compareTo(elements[mid]);

            if (comp == 0)  // found it, done
                return true;

            // check to see if it's in the lower half
            else if(comp < 0)
                right = mid - 1;

            else // it's in the upper half
                left = mid + 1;
        }

        return false;  // not found
    }


}
