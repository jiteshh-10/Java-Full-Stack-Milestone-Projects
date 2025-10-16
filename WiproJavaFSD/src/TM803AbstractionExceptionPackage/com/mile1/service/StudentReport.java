package TM803AbstractionExceptionPackage.com.mile1.service;

import com.mile1.bean.Student;
import com.mile1.exception.NullMarksArrayException;
import com.mile1.exception.NullNameException;
import com.mile1.exception.NullStudentObjectException;

public class StudentReport {

    public String findGrades(Student studentObject) {
        int[] marks = studentObject.getMarks();
        int sum = 0;

        for (int mark : marks) {
            if (mark < 35) {
                return "F";
            }
            sum += mark;
        }

        if (sum <= 150) return "D"; // UPDATED: Changed from C to D
        else if (sum <= 200) return "C"; // UPDATED: New C range
        else if (sum <= 250) return "B"; // UPDATED: New B range
        else if (sum <= 300) return "A"; // UPDATED: New A range
        else return "A+";               // UPDATED: New A+ range
    }

    public <Student> String validate(Student s) throws NullStudentObjectException, NullNameException, NullMarksArrayException {
        if (s == null) {
            throw new NullStudentObjectException();
        } else {
            if (s.getName() == null) {
                throw new NullNameException();
            } else if (s.getMarks() == null) {
                throw new NullMarksArrayException();
            } else {
                return "VALID";
            }
        }
    }
}