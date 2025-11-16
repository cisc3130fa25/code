package N_bst.C_set;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class TreeSet3130<E> implements NavigableSet3130<E> {
    // Representation: a binary search tree.
    // To keep things simpler, it is not a balanced BST, unlike in the JCF.

    private static class Node<E> {
        E data;
        Node<E> left, right;

        public Node(E data, Node<E> left, Node<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(E data) {
            this(data, null, null);
        }
    }

    @SuppressWarnings("unchecked")
    private class NaturalOrderComparator implements Comparator<E> {
        @Override
        public int compare(E e1, E e2) {
            return ((Comparable<E>) e1).compareTo(e2);
        }
    }

    private Node<E> root = null;
    private int size = 0;
    private final Comparator<E> comparator;

    public TreeSet3130() {
        this.comparator = new NaturalOrderComparator();
    }

    public TreeSet3130(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E element) {
        if (root == null) {
            root = new Node<>(element);
        } else {
            Node<E> parent = null, current = root;

            while (current != null) {
                int comparisonResult = comparator.compare(element, current.data);

                if (comparisonResult == 0) {
                    return false; // element is already in the tree
                } else if (comparisonResult < 0) {
                    parent = current;
                    current = current.left;
                } else { // comparisonResult > 0
                    parent = current;
                    current = current.right;
                }
            }

            if (comparator.compare(element, parent.data) < 0) {
                parent.left = new Node<>(element);
            } else {
                parent.right = new Node<>(element);
            }
        }

        size++;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> current = root;

        while (current != null) {
            int comparisonResult = comparator.compare((E) o, current.data);

            if (comparisonResult == 0) {
                return true;
            } else if (comparisonResult < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("not yet implemented"); // TODO
    }

    @Override
    public E getFirst() {
        if (root == null) {
            throw new NoSuchElementException();
        }

        Node<E> current = root;

        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }

    @Override
    public E getLast() {
        if (root == null) {
            throw new NoSuchElementException();
        }

        Node<E> current = root;

        while (current.right != null) {
            current = current.right;
        }

        return current.data;
    }

    @Override
    public E higher(E e) {
        return null; // TODO
    }

    @Override
    public E lower(E e) {
        return null; // TODO
    }

    @Override
    public Iterator<E> iterator() { // likely con be done much more efficiently
        return toInorderList().iterator();
    }

    private List<E> toInorderList() {
        List<E> list = new ArrayList<>();
        toInorderList(root, list);
        return list;
    }

    private void toInorderList(Node<E> root, List<E> list) {
        if (root != null) {
            toInorderList(root.left, list);
            list.add(root.data);
            toInorderList(root.right, list);
        }
    }
}
