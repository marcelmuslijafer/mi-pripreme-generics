package generics.comparators;

import generics.student.Student;

public class StudentGradeComparator implements MyComparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        if (s1.average() > s2.average())
            return 1;

        if (s1.average() < s2.average())
            return -1;

        return 0;
    }
}
