package com.akash;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        student s1 = new student();
        s1.setSid(101);
        s1.setSname("Akash");
        s1.setTech("Java");

        // Hibernate configuration
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(student.class);

        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction(); // ✅ Hibernate 6+ needs explicit transaction

        session.persist(s1); // OR session.save(s1);

        session.getTransaction().commit();

        session.close();
        factory.close();

        System.out.println("✅ Student saved successfully!");
    }
}
