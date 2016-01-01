package com.cs406.util;

import java.util.Arrays;
import java.util.Collections;

/**
 * This datastructure is a sorted set, when you add things to it, it adds the item in order
 *
 *
 *
 *
 * @author Geoffrey Shapiro
 */
public class SortedSet<T extends Comparable> {
    private static final int DEFAULT_CAPACITY = 100;

    private T[] elements;
    private int size; // current size
    private int current; // the current position in the traversal of the set
    private int capacity; // The max amount of things we can have in the set

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
     *
     * @param elem the element to check
     * @return true if the element is in the set, false otherwise.
     */
    public boolean contains(T elem) {
        // binary search
        int left = 0;
        int right = size - 1;

        while (left <= right) {
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
            else if (comp < 0)
                right = mid - 1;

            else // it's in the upper half
                left = mid + 1;
        }

        return false;  // not found
    }

    public boolean add(T elem) {
        if (isFull()) return false;
        if(!contains(elem)) {
            elements[size] = elem;
            size++;
            Arrays.sort(elements, 0, size);
            return true;
        }
        else
            return false;
    }

    public boolean remove(T elem) {
        for(int i = 0; i < size-1; i++)
            if (elements[i].equals(elem)) {
                for (int x = i; x < size-1; x++)
                    elements[x] = elements[x+1];
                size--;
                return true;
            }
        return false;
    }

    public T min() { return elements[0]; }

    public T max() { return elements[size-1]; }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;

    }

    public boolean isFull() {
        if (size == capacity)
            return true;
        else
            return false;

    }
    public int size() { return size; }

    public void reset() {this.current = 0;}


}


