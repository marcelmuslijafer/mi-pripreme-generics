package generics.tree;

import generics.comparators.MyComparator;

public class BinarySearchTree<T> {
    private Node<T> root;
    private final MyComparator<T> comparator;

    public BinarySearchTree(MyComparator<T> comparator) {
        this.comparator = comparator;
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    public boolean contains(T value) {
        return contains(root, value);
    }

    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    public void printPreOrder() {
        printPreOrder(root);
        System.out.println();
    }

    public void printPostOrder() {
        printPostOrder(root);
        System.out.println();
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }

        if (comparator.compare(value, node.getValue()) < 0) {
            node.setLeft(insert(node.getLeft(), value));
        } else {
            node.setRight(insert(node.getRight(), value));
        }

        return node;
    }

    private boolean contains(Node<T> node, T value) {
        if (node == null) {
            return false;
        }

        if (comparator.compare(value, node.getValue()) < 0) {
            return contains(node.getLeft(), value);
        }

        if (comparator.compare(value, node.getValue()) > 0) {
            return contains(node.getRight(), value);
        }

        return true;
    }

    private void printInOrder(Node<T> node) {
        if (node == null)
            return;

        printInOrder(node.getLeft());
        System.out.print(node.getValue() + " ");
        printInOrder(node.getRight());
    }

    private void printPreOrder(Node<T> node) {
        if (node == null)
            return;

        System.out.print(node.getValue() + " ");
        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());
    }

    private void printPostOrder(Node<T> node) {
        if (node == null)
            return;

        printPostOrder(node.getLeft());
        printPostOrder(node.getRight());
        System.out.print(node.getValue() + " ");
    }
}
