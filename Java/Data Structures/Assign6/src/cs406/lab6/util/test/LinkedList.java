package com.cs406.util;

/**
 * <p>LinkedList class for Data Structures (420-406)</p>
 *
 * @author Ian Clement
 */
public class LinkedList<T> {

    /* private inner class for link "chains" */
    private class Link<T> {
        Link<T> next;
        T element;
    }

    /**
     * Move a reference `i` links along the chain. Returns null if `i` exceeds chain length.
     * @param i number of links to move.
     * @return the reference to the link after `i` moves.
     */
    private Link<T> move(int i) {
        // move traversal forward i times.
        Link<T> current = head;
        for(int j=0; j<i && current != null; j++)
            current = current.next;
        return current;
    }

    /* a list is represented with a head "dummy" node to simplify the
     * add/remove operation implementation. */
    private Link<T> head;

    /* a tail pointer is used to make list append operations
     *     add(x),
     *     add(size(), x)
     * more efficient */
    private Link<T> tail;

    private int size;

    /* stores the position in the traversal */
    private Link<T> traversal;

    /* for checking that the list isn't modified (list length) during a traversal */
    private boolean modified;
    
    /* operations that modify the list's size */

    public LinkedList() {
        // create a "dummy" link, representing an empty list
        head = new Link<T>();
        tail = head;
        size = 0;
        modified = true;
    }

    /**
     * Appends the specified element to the end of this list.
     * @param element the element to add to the list.
     * @precondition   None.
     * @postcondition  `element` is the last element of the list. The size of the list is increased by 1.
     */
    public void add(T element) {
        // add a new link at the end of the list, set tail accordingly
        tail.next = new Link<T>();
        tail = tail.next;
        tail.element = element;
        size++;
        modified = true;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * @param position position in the list to add the element.
     * @param element element to add.
     * @precondition  position is between 0 and list size (inclusive).
     * @postcondition   The element is added to the list at position. If position is list size, it is appended to the end of the list. The size of the list is increased by 1.
     */
    public void add(int position, T element) {
        if(position < 0 || position > size)
            throw new ListBoundsException();
        
        // when "appending" call the add(x) method
        if(position == size) {
            add(element);
            return;
        }
        // move a link pointer to the desired position (point to link "position")
        Link<T> current = move(position);

        // place new link between "position" and "position + 1"
        Link<T> tmp = new Link<T>();
        tmp.element = element;
        tmp.next = current.next;
        current.next = tmp;

        size++;
        modified = true;
    }

    /**
     * Removes the element at the specified position in this list.
     * @param position position in the list to remove.
     * @return element removed.
     * @precondition position is between 0 and list size (exclusive).
     * @postcondition   The element at `position` is removed from the list. The size of the list is decreased by 1. The removed element is returned.
     */
    public T remove(int position) {
        if(position < 0 || position >= size)
            throw new ListBoundsException();
        
        // move a link pointer to the desired position (point to link "position")
        Link<T> current = move(position);
        T element = current.next.element;
        current.next = current.next.next;
        
        // reset the tail if we're removing the last link
        if(current.next == null)
            tail = current;
        
        size--;
        modified = true;
        
        return element;
    }

    /**
     * Removes all of the elements from this list.
     * @precondition None.
     * @postcondition All elements are removed from the list and the size is set to 0.
     */
    public void clear() {
        head.next = null; // remove all the links
        tail = head; // empty list
        size = 0;
        modified = true;
    }

    /**
     * Retrieve the element at the specified position in this list.
     * @param position position in the list to add the element.
     * @return the element at the position.
     * @precondition   position is between 0 and list size (exclusive).
     * @postcondition  Returns the element at position in the list.
     */
    public T get(int position){
        if(position < 0 || position >= size)
            throw new ListBoundsException();

        // move a link pointer to the desired position (point to link "position")
        Link<T> link = move(position + 1);
        return link.element;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @param position position in the list to add the element.
     * @param element element to set at position.
     * @return the previous value in this position.
     * @precondition   position is between 0 and list size (exclusive).
     * @postcondition  Sets a new value for the element at location position in the list.
     */
    public T set(int position, T element){
        if(position < 0 || position >= size)
            throw new ListBoundsException();

        // move a link pointer to the desired position (point to link "position")
        Link<T> current = move(position + 1);
        T ret = current.element;
        current.element = element;
        return ret;
    }

    /**
     * Initialize a traversal of the list.
     * @precondition None.
     * @postcondition  If the list contains elements, the traversal cursor is positioned on the first element. Otherwise, the traversal is complete (trivially).
     */
    public void reset(){
        traversal = head;
        modified = false; // reset this boolean to check for modification within traversal.
    }

    /**
       Method: has_next
       Purpose:

    */
    /**
     * Determine if a traversal can continue.
     * @return Returns true is there are elements left in the traversal, false otherwise.
     * @precondition   The traversal has been initialized and no add or remove operations have been performed since the initialization.
     * @postcondition  Returns true is there are elements left in the traversal, false otherwise.
     */
    public boolean hasNext(){
        return traversal.next != null;
    }

    /**
     * Return the traversal element in the traversal, and then advance the traversal cursor to the next element in the list.
     * @return the traversal element in the traversal.
     * @precondition The traversal has been initialized and no add or remove operations have been performed since the initialization. The traversal still has at least one element left.
     * @postcondition  If there is a next element, the traversal cursor has advanced to it and it is returned. At the end of the traversal cursor is undefined, meaning that is no longer refers to an element.
     */
    public T next(){
        if(!hasNext() || modified)
            throw new ListTraversalException();
        traversal = traversal.next;
        return traversal.element;
    }

    /**
     * Determine if this list contains no elements.
     * @return Returns true if this list contains no elements, false otherwise.
     * @precondition  None.
     * @postcondition Returns true if this list contains no elements, false otherwise.
     */
    public boolean isEmpty(){
        return size() == 0;
    }

    /**
     * Determine the number of elements in this list.
     * @return the number of elements in this list.
     * @precondition  None.
     * @postcondition  Returns the number of elements in this list.
     */
    public int size(){
        return size;
    }

    /**
     * Determine if the provided element is in the list.
     * @param element
     * @return true if this list contains no elements false otherwise.
     * @precondition  None.
     * @postcondition Returns true if this list contains no elements false otherwise.
     */
    public boolean contains(T element){
        // simple linear search
        Link<T> current = head.next;
        while(current != null) {
            if(current.element == element)
                return true;
            current = current.next;
        }
        return false;
    }
    
}


     
      
