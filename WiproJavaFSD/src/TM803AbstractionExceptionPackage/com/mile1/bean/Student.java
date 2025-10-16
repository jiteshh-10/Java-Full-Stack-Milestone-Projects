package TM803AbstractionExceptionPackage.com.mile1.bean;


public class Student {
    // Instance variables
    private String name;
    private int[] marks;
    private String grade;

    // Default constructor
    public Student() {
        // Auto-generated
    }

    // Parameterized constructor
    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    // --- Getters and Setters ---
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
