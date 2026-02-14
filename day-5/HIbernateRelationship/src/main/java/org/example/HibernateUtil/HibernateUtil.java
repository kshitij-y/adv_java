package org.example.HibernateUtil;

import org.example.entity.Passport;
import org.example.entity.Person;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory =
            new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Person.class)
                    .addAnnotatedClass(Passport.class)
                    .buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
