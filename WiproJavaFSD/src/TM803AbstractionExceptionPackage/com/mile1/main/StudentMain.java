package TM803AbstractionExceptionPackage.com.mile1.main;

import
import com.mile1.bean.Student;
import com.mile1.service.StudentReport;
import com.mile1.service.StudentService;

public class StudentMain {

    // Static data array initialized with test cases
    static Student data[] = new Student[4];

    // Use a static initializer block to set up the data
    static {
        for (int i = 0; i < data.length; i++) {
            data[i] = new Student();
        }
        data[0] = new Student("Sekar", new int[] {85, 75, 95});
        data[1] = new Student(null, new int[] {11, 22, 33});
        data[2] = null;
        data[3] = new Student("Manoj", null);
    }

    public static void main(String[] args) {
        StudentReport studentReport = new StudentReport();
        StudentService studentService = new StudentService();

        System.out.println("Grade Calculation:");

        // Loop through the data to validate and find grades
        for (Student student : data) {
            try {
                String validationResult = studentReport.validate(student);
                if (validationResult.equals("VALID")) {
                    String grade = studentReport.findGrades(student);
                    System.out.println("Grade for " + student.getName() + ": " + grade);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
            }
        }

        System.out.println("\n--- Summary Report ---");
        // Call the counting methods and print the results
        System.out.println("Number of Objects with null marks array: " + studentService.findNumberOfNullMarksArray(data));
        System.out.println("Number of Objects with null name: " + studentService.findNumberOfNullName(data));
        System.out.println("Number of null Objects: " + studentService.findNumberOfNullObjects(data));
    }
}