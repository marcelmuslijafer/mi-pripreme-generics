package generics.test;

import generics.comparators.IntegerComparator;
import generics.comparators.StudentGradeComparator;
import generics.student.Student;
import generics.student.Subject;
import generics.tree.BinarySearchTree;

import java.util.Random;

public class Test {


    private static final Random random = new Random();

    public static void main(String[] args) {
        int count = Integer.parseInt(args[0]);

        testInt(count);
        testStudent(count);

    }

    public static void testInt(int count) {
        System.out.println();
        System.out.println("****************************************************************");
        System.out.println("************************* INTEGER TEST *************************");
        System.out.println("****************************************************************");
        System.out.println();
        int upperBound = 30;
        int lowerBound = 1;

        BinarySearchTree<Integer> bst = new BinarySearchTree<>(new IntegerComparator());

        System.out.println("NUMBERS: ");
        for (int i = 0; i < count; i++) {
            int number = random.nextInt(lowerBound, upperBound+1);
            System.out.println(number + " ");
            bst.insert(number);
        }
        System.out.println();

        System.out.println("INORDER:");
        bst.printInOrder();

        System.out.println("PREORDER:");
        bst.printPreOrder();

        System.out.println("POSTORDER:");
        bst.printPostOrder();

        System.out.println("CONTAINS: ");
        for (int i = lowerBound; i < upperBound; i++) {
            System.out.println("Contains " + i + " " + bst.contains(i));
        }
    }

    public static void testStudent(int count) {
        System.out.println();
        System.out.println("****************************************************************");
        System.out.println("************************* STUDENT TEST *************************");
        System.out.println("****************************************************************");
        System.out.println();

        BinarySearchTree<Student> bst = new BinarySearchTree<>(new StudentGradeComparator());

        System.out.println("STUDENTS:");
        for (int i = 0; i < count; i++) {
            Student student = new Student(""+i);
            giveRandomGrades(student);
            System.out.println(student);
            bst.insert(student);
        }

        System.out.println("INORDER:");
        bst.printInOrder();
        System.out.println("\nPREORDER:");
        bst.printPreOrder();

        System.out.println("\nPOSTORDER");
        bst.printPostOrder();
    }

    public static void giveRandomGrades(Student student) {
        for (Subject subject : Subject.values()) {
            student.setGrade(subject, random.nextInt(1, 5+1));
        }
    }
}
