package M_trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

class BinaryTreeMethods {
    // Returns the size of the binary tree that is rooted at the given node.
    static int size(BinaryTreeNode<?> root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + size(root.left) + size(root.right);
        }
    }

    // Returns the height of the binary tree that is rooted at the given node.
    // The height of a tree is a length of the longest path from the root to a
    // leaf (childless node). We consider the height of an empty tree to be -1.
    public static int height(BinaryTreeNode<?> root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(height(root.left), height(root.right));
        }
    }

    // prints the inorder traversal of the binary tree that is rooted at the given node
    public static void printInorderTraversal(BinaryTreeNode<?> root) {
        if (root != null) {
            printInorderTraversal(root.left);
            IO.print(root.data + " ");
            printInorderTraversal(root.right);
        }
    }

    // using a stack to mimic recursion without using recursion
    public static <E> void printInorderTraversalUsingStack(BinaryTreeNode<E> root) {
        Deque<BinaryTreeNode<E>> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            IO.print(root.data + " ");
            root = root.right;
        }
    }

    // prints the postorder traversal of the binary tree that is rooted at the given node
    public static void printPostorderTraversal(BinaryTreeNode<?> root) {
        if (root != null) {
            printPostorderTraversal(root.left);
            printPostorderTraversal(root.right);
            IO.print(root.data + " ");
        }
    }

    public static void printPreorderTraversal(BinaryTreeNode<?> root) {
        if (root != null) {
            IO.print(root.data + " ");
            printPostorderTraversal(root.left);
            printPostorderTraversal(root.right);
        }
    }

    // returns a list of all elements in the tree that is rooted at the given node.
    // the list's elements follow the preorder traversal of the tree.
    public static <E> List<E> preorderList(BinaryTreeNode<E> root) {
        List<E> list = new ArrayList<>();
        preorderListHelper(root, list);
        return list;
    }

    private static <E> void preorderListHelper(BinaryTreeNode<E> root, List<E> list) {
        if (root != null) {
            list.add(root.data);
            preorderListHelper(root.left, list);
            preorderListHelper(root.right, list);
        }
    }

    // aka breadth-first traversal
    public static <E> void printLevelOrderTraversal(BinaryTreeNode<E> root) {
        Queue<BinaryTreeNode<E>> queue = new ArrayDeque<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode<E> current = queue.remove();
                IO.print(current.data + " ");

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            IO.println(); // end of one level
        }
    }

    public static <E> List<List<E>> levelOrderList(BinaryTreeNode<E> root) {
        return null; // TODO for hw
    }
}