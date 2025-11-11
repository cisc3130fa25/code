package L_hash_tables.A_set.B_our;

import java.util.Iterator;
import java.util.LinkedList;

public class ChainingHashSet3130<E> implements Set3130<E> {
    // Representation: a hash table.
    // We use chaining to resolve collisions: that is, at
    // each index, we have a chain of linked nodes for all
    // the elements that belong at that index.

    private LinkedList<E>[] table;
    private int size = 0;
    private final double maxLoadFactor;
    // the highest level that this set's load factor can go.
    // when the load factor goes above this level, we resize

    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private static final double DEFAULT_MAX_LOAD_FACTOR = 0.75;

    public ChainingHashSet3130() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }

    @SuppressWarnings("unchecked")
    public ChainingHashSet3130(int initialCapacity, double maxLoadFactor) {
        if (maxLoadFactor <= 0) {
            throw new IllegalArgumentException("max load factor must be positive");
        }

        table = (LinkedList<E>[]) new LinkedList[initialCapacity];
        this.maxLoadFactor = maxLoadFactor;
    }

    @Override
    public int size() {
        return size;
    }

    @Overrides
    public boolean add(E element) {
        if (contains(element)) {
            // in the element is already an element return false 
            // this is the contains methods we created for Hashset 
            return false;
        }

        int index = hash(element);
        //create an index for this 

        if (table[index] == null) {
            // if there is no linked list, create the linked list at the index of the table 
            table[index] = new LinkedList<>();
        }

        table[index].add(element);
        size++;

        if (loadFactor() > maxLoadFactor) {
            //Resize and grow 
            grow();
        }

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = hash(o);

        if (table[index] == null) {
            // if the index we are looking for is null there are no linked lists return false 
            return false;
        } else if (!table[index].contains(o)) {
            // if there is a linked list at this bucket but o is not in the LL return false 
            return false;
        } else {
            table[index].remove(o);
            // table at this index is a Containter a linekd list 
            // in the case where we find the o we remove it. 
            // whats the remove method being called here
            size--;
            // after removing decrease the size 
            return true;
        }
    }

    @Override
    public boolean contains(Object o) {
        int index = hash(o);
        return table[index] != null && table[index].contains(o);
        // first thing to do is check if there is the index of the hashcode is null. then chek if 
        // how does the conaitns methods runs in a cosntatn time becausse the length of the LL of your hashset is shoty 

        // why does the contains method runi na constant time vs not O(n) when in a hashset 
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        int count = 0;

        for (LinkedList<E> bucket : table) {
            if (bucket != null) {
                for (E element : bucket) {
                    sb.append(element);
                    count++;

                    if (count < size) {
                        sb.append(", ");
                    }
                }
            }
        }

        return sb.append("]").toString();
    }

    // given any object, returns the index at which the object belongs
    private int hash(Object o) {
        return Math.abs(o.hashCode()) % table.length;
        // hashcode might be a negaatiave thts why we call abs value 
        
    }

    // returns the current load factor
    private double loadFactor() {
        return size / (double) table.length;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        // keep a ref to the old table 
        LinkedList<E>[] oldTable = table;
        // table is now pointed to a new array full of linked lsit that's twice the length plus one
        table = (LinkedList<E>[]) new LinkedList[2 * table.length + 1];
        // set size to zero, why?
        // because the add method will automatically increase the size 
        size = 0;
// old buck is a linked list 
        for (LinkedList<E> oldBucket : oldTable) {
            if (oldBucket != null) {
                // whats going on in the for loop? were adding the old linked list ?
                for (E element : oldBucket) {
                    add(element);
                    // adds the method to the table and also increases the size 
                }
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
