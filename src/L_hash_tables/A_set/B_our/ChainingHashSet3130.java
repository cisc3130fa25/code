package L_hash_tables.A_set.B_our;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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

    @Override
    public boolean add(E element) {
        if (contains(element)) {
            return false;
        }

        int index = hash(element);

        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        table[index].addFirst(element); // or addLast, it doesn't matter
        size++;

        if (loadFactor() > maxLoadFactor) {
            grow();
        }

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = hash(o);

        if (table[index] == null) {
            return false;
        } else if (!table[index].contains(o)) {
            return false;
        } else {
            table[index].remove(o);
            size--;
            return true;
        }
    }

    @Override
    public boolean contains(Object o) {
        int index = hash(o);
        return table[index] != null && table[index].contains(o);
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
    }

    // returns the current load factor
    private double loadFactor() {
        return size / (double) table.length;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        LinkedList<E>[] oldTable = table;
        table = (LinkedList<E>[]) new LinkedList[2 * table.length + 1];
        size = 0;

        for (LinkedList<E> oldBucket : oldTable) {
            if (oldBucket != null) {
                for (E element : oldBucket) {
                    add(element);
                }
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        // The following uses O(n) time and O(n) space.
        // It is possible to make both be O(1).
        // But it is too hard for me.

        List<E> list = new ArrayList<>();

        for (LinkedList<E> bucket : table) {
            if (bucket != null) {
                for (E element : bucket) {
                    list.add(element);
                }
            }
        }

        return list.iterator();
    }
}