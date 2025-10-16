package TM1;

public class Project1 {

    // A static inner class to represent an Employee's data
    static class Employee {
        int empNo;
        String empName;
        String joinDate;
        char designationCode;
        String department;
        int basic;
        int hra;
        int it;

        // Constructor to initialize an Employee object
        public Employee(int empNo, String empName, String joinDate, char designationCode, String department, int basic, int hra, int it) {
            this.empNo = empNo;
            this.empName = empName;
            this.joinDate = joinDate;
            this.designationCode = designationCode;
            this.department = department;
            this.basic = basic;
            this.hra = hra;
            this.it = it;
        }
    }

    public static void main(String[] args) {
        // Check if a command-line argument was provided
        if (args.length == 0) {
            System.out.println("Please provide an employee ID as a command line argument.");
            return;
        }

        // Parse the employee ID from the command-line argument
        int searchEmpId = Integer.parseInt(args[0]);

        // Initialize the array of employee data
        Employee[] employees = {
                new Employee(1001, "Ashish",  "01/04/2009", 'e', "R&D",          20000, 8000,  3000),
                new Employee(1002, "Sushma",  "23/08/2012", 'c', "PM",           30000, 12000, 9000),
                new Employee(1003, "Rahul",   "12/11/2008", 'k', "Acct",         10000, 8000,  1000),
                new Employee(1004, "Chahat",  "29/01/2013", 'r', "Front Desk",   12000, 6000,  2000),
                new Employee(1005, "Ranjan",  "16/07/2005", 'm', "Engg",         50000, 20000, 20000),
                new Employee(1006, "Suman",   "1/1/2000",   'e', "Manufacturing",23000, 9000,  4400),
                new Employee(1007, "Tanmay",  "12/06/2006", 'c', "PM",           29000, 12000, 10000)
        };

        boolean found = false;
        // Loop through the employees array to find a match
        for (Employee emp : employees) {
            if (emp.empNo == searchEmpId) {
                found = true;

                // Variables to store designation details
                String designation = "";
                int da = 0;

                // Use switch-case to find Designation and DA based on Designation Code
                switch (emp.designationCode) {
                    case 'e':
                        designation = "Engineer";
                        da = 20000;
                        break;
                    case 'c':
                        designation = "Consultant";
                        da = 32000;
                        break;
                    case 'k':
                        designation = "Clerk";
                        da = 12000;
                        break;
                    case 'r':
                        designation = "Receptionist";
                        da = 15000;
                        break;
                    case 'm':
                        designation = "Manager";
                        da = 40000;
                        break;
                    default:
                        // Handle unknown designation code if necessary
                        designation = "Unknown";
                        da = 0;
                        break;
                }

                // Calculate the total salary
                int salary = emp.basic + emp.hra + da - emp.it;

                // Print the output in the required format
                System.out.printf("%-10s %-10s %-15s %-15s %-10s\n", "Emp No", "Emp Name", "Department", "Designation", "Salary");
                System.out.printf("%-10d %-10s %-15s %-15s %-10d\n", emp.empNo, emp.empName, emp.department, designation, salary);

                // Exit the loop once the employee is found
                break;
            }
        }

        // If the loop finishes and the employee was not found, print the message
        if (!found) {
            System.out.println("There is no employee with empid : " + searchEmpId);
        }
    }
}