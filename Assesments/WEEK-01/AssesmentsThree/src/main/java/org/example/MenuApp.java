package org.example;

import org.example.entity.MenuItem;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

import static org.example.HibernateUtils.HibernateUtils.getSessionFactory;

public class MenuApp {
    private static Scanner scanner = new Scanner(System.in);
    public MenuApp(){}
    public static void check( ) {

        boolean running = true;
        while(running) {
            System.out.println("\n\n1. Add Menu Item");
            System.out.println("2. View");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");

            System.out.println("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: addItem(); break;
                case 2: viewItem(); break;
                case 3: updateItems(); break;
                case 4: deleteItems(); break;
                case 5: running = false;
            }

        }
    }

    static void addItem(){
        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Name: ");
        String name = scanner.next();

        System.out.print("Price: ");
        Double price = scanner.nextDouble();

        System.out.print("Category: ");
        String category = scanner.next();

        System.out.println("Available [true/false]");
        Boolean available = scanner.nextBoolean();

        MenuItem menuItem = new MenuItem(name, price, category, available);

        session.save(menuItem);
        tx.commit();
        session.close();
    }

    static void viewItem() {

        Session session = getSessionFactory().openSession();

        try {
            List<MenuItem> list = session.createQuery("from MenuItem", MenuItem.class).list();

            for(MenuItem item : list) {
                System.out.println(
                        item.getId() + " | " +
                                item.getName() + " | " +
                                item.getPrice() + " | " +
                                item.getCategory() + " | " +
                                item.getAvailable()
                );
            }

        } finally {
            session.close();
        }
    }

    static void updateItems() {

        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {

            System.out.print("Enter ID to update: ");
            int id = scanner.nextInt();

            MenuItem item = session.get(MenuItem.class, id);

            if(item == null) {
                System.out.println("Item not found");
                return;
            }

            System.out.print("New Name: ");
            item.setName(scanner.next());

            System.out.print("New Price: ");
            item.setPrice(scanner.nextDouble());

            System.out.print("New Category: ");
            item.setCategory(scanner.next());

            System.out.print("Available [true/false]: ");
            item.setAvailable(scanner.nextBoolean());

            session.update(item);

            tx.commit();

        } catch(Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    static void deleteItems() {

        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {

            System.out.print("Enter ID to delete: ");
            int id = scanner.nextInt();

            MenuItem item = session.get(MenuItem.class, id);

            if(item == null) {
                System.out.println("Item not found");
                return;
            }

            session.delete(item);

            tx.commit();

            System.out.println("Deleted successfully.");

        } catch(Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
