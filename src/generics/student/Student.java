package generics.student;

import java.util.Arrays;
import java.util.Objects;

public class Student {

    public static final double GENERATION_AVERAGE = 3.13;
    public static final int SUBJECT_COUNT = 6;

    private final String id;

    private final int[] grades;

    public Student(String id) {
        this.id = id;
        grades = new int[SUBJECT_COUNT];
    }

    public String getId() {
        return id;
    }

    public void setGrade(Subject subject, int grade) {
        if (grade < 0 || grade > 5) {
            return;
        }
        grades[subject.ordinal()] = grade;
    }

    public double average() {
        double sum = 0.0;
        for (int i = 0; i < SUBJECT_COUNT; i++) {
            if (grades[i] != 0) {
                sum += grades[i];
            }
        }
        return sum/SUBJECT_COUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Arrays.equals(grades, student.grades);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(grades);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Student{id='%s', grades=%s, average=%.2f}", id, Arrays.toString(grades), average());
    }
}
