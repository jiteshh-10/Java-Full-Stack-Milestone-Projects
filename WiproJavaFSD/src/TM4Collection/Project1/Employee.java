package TM4Collection.Project1;

public class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
    private String address;

    // Constructor to initialize the employee object
    public Employee(String firstName, String lastName, String mobileNumber, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.address = address;
    }

    // Getter methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    // This method is required by the Comparable interface.
    // It tells Collections.sort() to sort objects based on the firstName.
    @Override
    public int compareTo(Employee other) {
        return this.firstName.compareTo(other.getFirstName());
    }
}
