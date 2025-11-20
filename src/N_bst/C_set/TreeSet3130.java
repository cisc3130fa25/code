package N_bst.C_set;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeSet3130<E> implements NavigableSet3130<E> {
    // Representation: a binary search tree.
    // To keep things simpler, it is not a balanced BST, unlike in the JCF.
    // As a result, many methods that run in O(log n) time in the JCF,
    // here run much less efficiently, in O(n) time.

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
    public E lower(E e) {
        return null; // TODO
    }

    @Override
    public E higher(E e) {
        return null; // TODO
    }

    @Override
    public Iterator<E> iterator() {
        return new BstInorderIterator();
    }

    // Leetcode 173: https://leetcode.com/problems/binary-search-tree-iterator/
    private class BstInorderIterator implements Iterator<E> {
        private final Deque<Node<E>> stack = new ArrayDeque<>();

        public BstInorderIterator() {
            pushLeft(root);
        }

        private void pushLeft(Node<E> node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Node<E> node = stack.pop();
            pushLeft(node.right);
            return node.data;
        }
    }
}
