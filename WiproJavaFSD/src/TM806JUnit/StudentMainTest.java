package TM806JUnit;

import TM803AbstractionExceptionPackage.com.mile1.bean.Student;
import TM803AbstractionExceptionPackage.com.mile1.service.StudentReport;
import TM803AbstractionExceptionPackage.com.mile1.service.StudentService;

public class StudentMainTest {

    // Test data for various scenarios
    static Student data[] = new Student[] {
            new Student("A", new int[] { 80, 85, 90 }),   // TC1: A Grade
            new Student("B", new int[] { 40, 45, 50 }),   // TC2: D Grade
            new Student("C", new int[] { 20, 25, 30 }),   // TC3: F Grade
            null,                                         // TC4: Null Student Object
            new Student(null, new int[] { 70, 75, 80 }),  // TC5: Null Name
            new Student("F", null),                       // TC6: Null Marks Array
            new Student("G", new int[] { 90, 95, 99 }),   // Valid student for counting
            new Student(null, null)                       // Student with null name and marks
    };

    public static void main(String[] args) {
        StudentReport studentReport = new StudentReport();
        StudentService studentService = new StudentService();

        System.out.println("--- Testing Grade Calculation ---");
        // TC1: Check for A grade
        System.out.println("TC1: Grade for " + data[0].getName() + " is " + studentReport.findGrades(data[0]));
        // TC2: Check for D grade
        System.out.println("TC2: Grade for " + data[1].getName() + " is " + studentReport.findGrades(data[1]));
        // TC3: Check for F grade
        System.out.println("TC3: Grade for " + data[2].getName() + " is " + studentReport.findGrades(data[2]));

        System.out.println("\n--- Testing Exception Handling ---");
        // TC4: Test for NullStudentObjectException
        try {
            studentReport.validate(data[3]);
        } catch (Exception e) {
            System.out.println("TC4: " + e.toString());
        }
        // TC5: Test for NullNameException
        try {
            studentReport.validate(data[4]);
        } catch (Exception e) {
            System.out.println("TC5: " + e.toString());
        }
        // TC6: Test for NullMarksArrayException
        try {
            studentReport.validate(data[5]);
        } catch (Exception e) {
            System.out.println("TC6: " + e.toString());
        }

        System.out.println("\n--- Testing Null Counting Functions ---");
        // TC7: Test findNumberOfNullName function
        System.out.println("TC7: Number of Null Names: " + studentService.findNumberOfNullName(data));
        // TC8: Test findNumberOfNullObjects function
        System.out.println("TC8: Number of Null Objects: " + studentService.findNumberOfNullObjects(data));
        // TC9: Test findNumberOfNullMarks function
        System.out.println("TC9: Number of Null Marks Arrays: " + studentService.findNumberOfNullMarksArray(data));
    }
}