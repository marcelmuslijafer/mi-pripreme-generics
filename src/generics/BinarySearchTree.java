package generics;

public class BinarySearchTree<T> {
    private Node<T> root;
    private MyComparator<T> comparator;

    public BinarySearchTree(MyComparator<T> comparator) {
        this.comparator = comparator;
    }

    public void insert(T value) {

    }

    public boolean contains(T value) {
        return false;
    }

    public void delete(T value) {

    }

    public void printInOrder() {

    }

    public void printPreOrder() {

    }

    public void printPostOrder() {

    }
}
