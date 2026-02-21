package org.example;


import org.example.entity.Course;
import org.example.entity.Department;
import org.example.entity.IDCard;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static org.example.HibernateUtils.HibernateUtils.getSessionFactory;

public class App {
    public static void main( String[] args ) {
        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Department deptOne = new Department("CSE");

        Student stuOne = new Student("Kshitij kumar");
        Student stuTwo = new Student("Avinash Dhanuka");

        stuOne.setDepartment(deptOne);
        stuTwo.setDepartment(deptOne);

        deptOne.getStudents().add(stuOne);
        deptOne.getStudents().add(stuTwo);

        IDCard cardOne = new IDCard(12214966);
        IDCard cardTwo = new IDCard(12210000);

        stuOne.setIdcard(cardOne);
        stuTwo.setIdcard(cardTwo);

        cardOne.setStudent(stuOne);
        cardTwo.setStudent(stuTwo);

        Course cOne = new Course("SPRING");
        Course cTwo = new Course("JAVA");

        stuOne.getCourses().add(cOne);


        stuTwo.getCourses().add(cOne);
        stuTwo.getCourses().add(cTwo);

        session.save(deptOne);
        session.save(stuOne);
        session.save(stuTwo);
        session.save(cardOne);
        session.save(cardTwo);
        session.save(cOne);
        session.save(cTwo);

        tx.commit();
        session.close();

    }
}
