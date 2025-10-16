package TM501IOStreams;

import java.io.Serializable;

public class Employee implements Serializable {
    // A version number for serialization to prevent issues during deserialization
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private int age;
    private double salary;

    // Constructor
    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Overriding the toString() method for easy display
    @Override
    public String toString() {
        return id + " " + name + " " + age + " " + salary;
    }
}