package org.example.HibernateUtils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        try {
            return new Configuration()
                    .configure("Hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (Exception e){
            throw new RuntimeException("[SessionFactory]" + e.getMessage());
        }
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
