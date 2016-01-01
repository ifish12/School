package cs406.lab6.util;

/*
  ================================================================================

  Class: HashMap<K,V>
  * Version: 8
  * Author:  Ian Clement <ian.clement@johnabbott.qc.ca>
  * For:     cs406
  * Date:    2015/03/26
  * Purpose: hash map implementation of the map ADT.

  * Changes from version 7:
      - Added javadoc for methods

  * Changes from version 6:
      - Entry has read-only key to prevent the user from updating a key and causing
        it to change buckets.

  * Changes from version 5:
      - changes all key comparisons from == to .equals() (or equivalent)
      - removed leading comma from pretty print.

  * Changes from version 4:
      - fixed the error "ArrayOutOfBounds" in rehash.
      - added "pretty printer": toString()

  * Changes from version 3:
      - ported from C++ to Java

  * Changes from version 2:
      1. moved struct back into the hash_map class but using the templates
         provided to hash_map.

  * Changes from Version 1:
      1. added serialization (methods).
      2. moved Link struct in it's own header file. Used capital 'L' to
         differentiate from link() function.
      3. moved exceptions to their own header file.


  ================================================================================
*/


/**
 * <p>HashMap class for Data Structures (420-406)
 * </p>
 * <p>Implements the map using open addressing</p>
 *
 * @author Ian Clement
 */
public class HashMap<K,V> {

    private static final int DEFAULT_TOTAL_BUCKETS = 100;
    private static final double DEFAULT_FACTOR = 0.75;

    private class Link<T> {
        public Link next;
        public T element;
    }

    /* store as array of link pointers */
    private Link<Entry<K,V>>[] buckets;

    private int mapSize;
    private int totalBuckets;
    private double factor;


    /* stores the current position in the traversal */
    private int currentBucket;
    private Link<Entry<K,V>> current;

    /* for checking that the map isn't modified (map size) during a traversal */
    private boolean modified;

    private void rehash() {
        // only rehash when the load factor exceeds the limit
        if((double) mapSize / (double) totalBuckets < factor)
            return;

        int previousTotalBuckets = totalBuckets;
        Link<Entry<K,V>>[] previousBuckets = buckets;

        totalBuckets *= 2;

        // allocation the new bucket array
        buckets = (Link<Entry<K,V>>[]) new Link[totalBuckets];

        // loop through the previous buckets array and move all links to the new array.
        for(int i=0; i<previousTotalBuckets; i++) {

            if(previousBuckets[i] != null) { // skip empty lists

                // move each link in the linked list to their new position in the larger bucket array
                // recycle the memory by relinking each link.
                // careful: list of keys that hashed to a bucket in the previous bucket size will not necessarily be hashed to the same bucket in the new size.

                Link<Entry<K,V>> current = previousBuckets[i];
                while(current != null) {
                    Link tmp = current.next; // store next link since we overwrite `current.next` below
                    int index = hash(current.element.getKey().hashCode());

                    // place at the head of the list
                    current.next = buckets[index];
                    buckets[index] = current;

                    current = tmp;
                }
            }
        }
        modified = true;
    }

    private int hash(int code) {
        code = code < 0 ? -code : code;
        return code % totalBuckets;
    }


    public HashMap() {
        this(DEFAULT_TOTAL_BUCKETS, DEFAULT_FACTOR);
    }

    public HashMap(int totalBuckets) {
        this(totalBuckets, DEFAULT_FACTOR);
    }

    public HashMap(int totalBuckets, double factor) {
        this.totalBuckets = totalBuckets;
        this.factor = factor;
        mapSize = 0;

        // allocate space for buckets
        buckets = (Link<Entry<K,V>>[]) new Link[totalBuckets];
        // modified = true;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * @param key the key of the entry.
     * @param value the value of the entry.
     * @precondition None.
     * @postcondition The value to which key is mapped to is set to value. If the map previously contained a entry
     *                for key (i.e.: contains key(key) is true), the old value is replaced by value.
     */
    public void put(K key, V value) {
        // get index by hashing
        int index = hash(key.hashCode());

        // search for the key in the list
        Link<Entry<K,V>> current;
        for(current = buckets[index]; current != null && !current.element.getKey().equals(key); current = current.next);

        // key not found: add an entry to the "head" of the list
        if(current == null) {
            current = new Link<Entry<K,V>>();
            current.element = new Entry<K,V>(key);
            current.element.setValue(value);
            current.next = buckets[index];
            buckets[index] = current;
            mapSize++;
            modified = true;

            // added an entry -> rehash
            rehash();
        }
        else // key found: replace value
            current.element.setValue(value);
    }

    /**
     * Retrieve the value mapped to by the specified key.
     * @param key the key to find in the map.
     * @return the value associated with key.
     * @precondition The map contains a entry for key.
     * @postcondition  Returns the value to which the specified key is mapped.
     */
    public V get(K key) {
        // get index by hashing
        int index = hash(key.hashCode());

        // search list for the link containing key
        Link<Entry<K,V>> current;
        for(current = buckets[index]; current != null && !current.element.getKey().equals(key); current = current.next);

        // throw if key not found: precondition violated.
        if(current == null)
            throw new KeyNotFoundException();

        return current.element.getValue();
    }

    /**
     * From this map, remove the entry for the specified key, if it is present.
     * @param key the key of the entry to remove
     * @return the removed value.
     * @precondition None.
     * @postcondition If there is a entry for key, then it is removed, otherwise the map remains the same.
     */
    public V remove(K key) {
        // get index by hashing
        int index = hash(key.hashCode());

        // search list for link containing key, keep track of previous link for deletion.
        Link<Entry<K,V>> current;
        Link<Entry<K,V>> previous = null;
        for(current = buckets[index]; current != null && !current.element.getKey().equals(key); current = current.next)
            previous = current;

        // key not found: precondition violated.
        if(current == null)
            throw new KeyNotFoundException();

        V tmp = current.element.getValue();
        if(previous == null) // remove buckets[i]
            buckets[index] = current.next;
        else             // remove within linked list
            previous.next = current.next;

        mapSize--;
        modified = true;

        return tmp;
    }

    /**
     * Removes all of the entrys from this map.
     * @precondition None.
     * @postcondition All entrys are removed from this map.
     */
    public void clear() {
        for(int i=0; i< totalBuckets; i++)
            buckets[i] = null;
        // alternative: buckets = (Link[]) new Object[totalBuckets];
        mapSize = 0;
    }

    /**
     * Determine is a map contains a entry for the specified key.
     * @param key the key to find in the map.
     * @return true if this map contains a entry for the specified key, false otherwise.
     * @precondition None.
     * @postcondition Returns true if this map contains a entry for the specified key, false otherwise.
     */
    public boolean containsKey(K key) {
        // get index by hashing
        int index = hash(key.hashCode());

        // search list for link containing key
        Link<Entry<K,V>> current;
        for(current = buckets[index]; current != null && !current.element.getKey().equals(key); current = current.next) ;
        return current != null;
    }

    /**
     * Initialize a traversal of the map.
     * @precondition None.
     * @postcondition If the map contains entrys, the traversal cursor is positioned on the first entry. Otherwise, the traversal is complete (trivially).
     */
    public void reset() {
        // starting from the first bucket, move `current` to the next available link
        // if the map is empty current will be NULL
        for(currentBucket = 0; currentBucket < totalBuckets && buckets[currentBucket] == null; currentBucket++);
        current = (currentBucket < totalBuckets) ? buckets[currentBucket] : null;
        modified = false;
    }

    /**
     * Determine if a traversal can continue.
     * @return true is there are elements left in the traversal, false otherwise.
     * @precondition The traversal has been initialized and no put or remove operations have been performed since the initialization.
     * @postcondition Returns true is there are elements left in the traversal, false otherwise.
     */
    public boolean hasNext() {
        return current != null;
    }

    /**
     * Return the current entry in the traversal, and then advance the traversal cursor to the next entry in the map.
     * @return the next entry in the map.
     * @precondition The traversal has been initialized and no add or remove operations have been performed since the initialization. The traversal still has at least one entry left.
     * @postcondition If there is a next entry, the traversal cursor has advanced to it and it is returned. At the end of the traversal cursor is undefined, meaning that is no longer refers to a entry.
     */
    public Entry<K,V> next() {
        if(current == null || modified)
            throw new MapTraversalException();

        // to return the current element in the traversal
        Link<Entry<K,V>> tmp = current;

        // if the current list isn't done
        if(current.next != null)
            current = current.next;
        else { // move to the next bucket containing links.
            for(currentBucket++; currentBucket < totalBuckets && buckets[currentBucket] == null; currentBucket++);
            // set current to NULL if there is no links left
            current = (currentBucket < totalBuckets) ? buckets[currentBucket] : null;
        }
        return tmp.element;
    }

    /**
     * Determine if the map is empty: it contains no key-value entries.
     * @return true if this map contains no key-value entrys, false otherwise.
     * @precondition None.
     * @postcondition Returns true if this map contains no key-value entrys, false otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Determine the number of key-value entries in this map.
     * @return the number of key-value entries in this map.
     * @precondition None.
     * @postcondition Returns true if this map contains no key-value entrys, false otherwise.
     */
    public int size() {
        return mapSize;
    }

    /**
     * Determine the size of the bucket array.
     * @return the size of the bucket array.
     * @precondition None.
     * @postcondition Returns the size of the bucket array.
     */
    public int getTotalBuckets() {
        return totalBuckets;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean first = true;
        for(int i = 0; i < totalBuckets; i++)
            for(Link<Entry<K,V>> head = buckets[i]; head != null; head = head.next) {
                Entry<K, V> entry = head.element;
                sb.append(first ? "" : ", ").append(entry.getKey()).append(" => ").append(entry.getValue());
                first = false;
            }
        sb.append("}");
        return sb.toString();
    }

    public String toStringBuckets() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for(int i = 0; i < totalBuckets; i++) {
            int count = 0;
            for (Link<Entry<K, V>> head = buckets[i]; head != null; head = head.next) count++;
            sb.append("\t" + count + ": [");

            boolean first = true;
            for (Link<Entry<K, V>> head = buckets[i]; head != null; head = head.next) {
                Entry<K, V> entry = head.element;
                sb.append(first ? "" : ", ").append(entry.getKey()).append(" => ").append(entry.getValue());
                first = false;
            }
            sb.append("]\n");
        }
        sb.append("}");

        return sb.toString();
    }

}
