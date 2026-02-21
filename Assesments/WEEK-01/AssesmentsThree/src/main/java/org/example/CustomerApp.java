package org.example;

import org.example.entity.Customers;
import org.example.entity.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

import static org.example.HibernateUtils.HibernateUtils.getSessionFactory;

public class CustomerApp {
    private static Scanner scanner = new Scanner(System.in);
    public static void check(){
        boolean running = true;
        while(running) {
            System.out.println("\n\n1. add Customer");
            System.out.println("2. addOrder");
            System.out.println("3. viewCustomers");
            System.out.println("4. Exit");

            System.out.println("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: checkCustomerOrder(); break;
                case 2: addOrder(); break;
                case 3: viewCustomers(); break;
                case 4: running = false;
            }

        }
    }
    static void checkCustomerOrder(){
        System.out.println("Enter Customers Details");
        System.out.print("Name: ");
        String cName = scanner.next();

        System.out.print("Email: ");
        String cEmail = scanner.next();

        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            Customers customers = new Customers(cName, cEmail);
            session.save(customers);
            tx.commit();
            session.close();
        } catch (Exception e){
            System.out.println("[checkCustomerOrder]: " + e.getMessage());
        }
    }

    static void addOrder(){
        System.out.print("Custmer ID: ");
        int id = scanner.nextInt();
        System.out.println("Enter Orders Details");
        System.out.print("Product name: ");
        String name = scanner.next();

        System.out.print("Amount: ");
        Double amount = scanner.nextDouble();

        try {
            Session session = getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            Orders orders = new Orders(name, amount);

            Customers customers = session.get(Customers.class, id);

            if(customers == null){
                System.out.println("Customer id not found");
                return;
            }
            customers.addOrder(orders);
            session.update(customers);
            tx.commit();
            session.close();

        } catch (Exception e){
            System.out.println("[addOrder]: " + e.getMessage());
        }
    }

    static void viewCustomers() {

        Session session = getSessionFactory().openSession();

        try {

            List<Customers> customersList =
                    session.createQuery(
                            "SELECT DISTINCT c FROM Customers c LEFT JOIN FETCH c.orders",
                            Customers.class
                    ).getResultList();

            for (Customers c : customersList) {

                System.out.println("Customer: [" + c.getName() + ", " + c.getEmail() + "]");

                for (Orders o : c.getOrders()) {
                    System.out.println("      Order: [" + o.getProductName() + ", " + o.getAmount() + "]");
                }
            }

            session.close();

        } catch (Exception e) {
            System.out.println("[viewCustomers]: " + e.getMessage());
        }
    }
}
