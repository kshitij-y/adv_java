package org.example;

import org.example.HibernateUtil.HibernateUtil;
import org.example.entity.Passport;
import org.example.entity.Person;
import org.hibernate.Session;
import java.time.LocalDate;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        session.beginTransaction();

        System.out.println("Enter Person Details: ");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();

        Person person = new Person(name, email, age);




        System.out.println("Enter Passport details: ");

        System.out.print("Passport Number: ");
        String passportNumber = scanner.next();

        System.out.print("Country: ");
        String country = scanner.next();

        Passport passport = new Passport(
                passportNumber,
                country,
                LocalDate.now(),
                LocalDate.now().plusYears(10)
        );

        person.setPassport(passport);

        session.save(person);

        session.getTransaction().commit();
        session.close();
    }
}
