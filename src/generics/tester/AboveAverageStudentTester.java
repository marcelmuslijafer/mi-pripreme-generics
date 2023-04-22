package generics.tester;

import generics.student.Student;

public class AboveAverageStudentTester implements Tester<Student> {

    @Override
    public boolean test(Student s) {
        return s.average() > Student.GENERATION_AVERAGE;
    }

}
