package org.example;

import org.example.entity.Department;
import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

import static org.example.HibernateUtils.HibernateUtils.getSessionFactory;

public class EmployeeApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void check(){
        boolean running = true;
        while(running) {
            System.out.println("\n\n1. add Department");
            System.out.println("2. add Employee");
            System.out.println("3. view Department and its Employee");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: addDept(); break;
                case 2: addEmp(); break;
                case 3: viewDeptEmployee(); break;
                case 4: running = false;
            }

        }
    }
    private static void addDept() {

        System.out.print("Enter department name: ");
        String name = scanner.next();

        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Department dept = new Department(name);
        session.persist(dept);

        tx.commit();
        session.close();

        System.out.println("Department added.");
    }

    private static void addEmp(){
        System.out.print("Enter employee name: ");
        String empName = scanner.next();

        System.out.print("Enter department id: ");
        int deptId = scanner.nextInt();

        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Department dept = session.get(Department.class, deptId);

        if (dept == null) {
            System.out.println("Department not found.");
            session.close();
            return;
        }

        Employee emp = new Employee(empName);

        emp.setDepartment(dept);

        session.persist(emp);

        tx.commit();
        session.close();

        System.out.println("Employee added.");

    }

    private static void viewDeptEmployee() {

        Session session = getSessionFactory().openSession();

        List<Employee> list = session
                .createQuery("FROM Employee", Employee.class)
                .list();

        for (Employee e : list) {

            System.out.println("\nDepartment: " + e.getName());

            System.out.println("Employee: " + e.getDepartment().getName());
        }

        session.close();
    }




}
