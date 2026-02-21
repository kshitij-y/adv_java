package org.example;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static org.example.HibernateUtils.HibernateUtils.getSessionFactory;

public class EmployeeDAO {
    public void saveEmployee(Employee emp){

        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(emp);
        tx.commit();
        session.close();
    }

    public Employee fetchEmployeeById(int id){

        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Employee emp = session.get(Employee.class, id);
        if(emp == null) return null;
        tx.commit();
        session.close();
        return emp;
    }

    public void updateEmployee(int id, double sal){

        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Employee emp = session.get(Employee.class, id);

        emp.setSalary(sal);
        session.update(emp);
        tx.commit();
        session.close();

    }

    public void deleteEmployee(int id){

        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.delete(session.get(Employee.class, id));

        tx.commit();
        session.close();
    }
}
