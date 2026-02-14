package org.example.HibernateUtils;

import org.example.entity.MenuItem;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        try {
            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(MenuItem.class)
                    .buildSessionFactory();
        } catch (Exception e){
            throw new RuntimeException("[SessionFactory]" + e.getMessage());
        }
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
