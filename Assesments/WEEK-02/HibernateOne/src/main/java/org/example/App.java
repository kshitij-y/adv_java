package org.example;

import org.example.entity.Employee;
import java.util.Scanner;


public class App {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        boolean running = true;
        while(running){
            System.out.println("\n\n1. Add Employee");
            System.out.println("2. Fetch Employee by id");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Enter Employee Details: ");
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    sc.nextLine();

                    System.out.print("Department: ");
                    String dept = sc.next();

                    System.out.print("Salary: ");
                    double sal = sc.nextDouble();

                    Employee emp = new Employee(name, dept, sal);
                    employeeDAO.saveEmployee(emp);
                    break;
                }
                case 2: {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    Employee emp = employeeDAO.fetchEmployeeById(id);
                    if(emp == null){
                        System.out.println("\nEmployeeId not found");
                        break;
                    }
                    System.out.println(emp);
                    break;
                }
                case 3: {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    System.out.println("Enter new Salary: ");
                    double sal = sc.nextDouble();

                    employeeDAO.updateEmployee(id, sal);

                }
                case 4: {
                    System.out.print("Enter id: ");
                    int id = sc.nextInt();
                    employeeDAO.deleteEmployee(id);
                    break;
                }
                case 5: running = false;
            }
        }

    }
}
