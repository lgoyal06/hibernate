package com.lalit.hibernate.mapping.onetooneonly;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String... s) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg-mapping.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Instructor instructor = session.get(Instructor.class, 2);
        session.delete(instructor);
        session.getTransaction().commit();
    }
}
