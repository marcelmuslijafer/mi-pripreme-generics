package generics.tree;

import generics.comparators.MyComparator;
import generics.tester.Tester;

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

    public int countIf(Tester<? super T> tester) {
        return countIf(root, tester);
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

    private int countIf(Node<T> node, Tester<? super T> tester) {
        if (node == null)
            return 0;

        int count = 0;
        if (tester.test(node.getValue())) {
            count++;
        }

        count += countIf(node.getLeft(), tester) + countIf(node.getRight(), tester);
        return count;
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
