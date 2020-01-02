package com.lalit.hibernate.mapping.onetoone.bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String... s) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg-mapping.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            InstructorDetails instructorDetails = session.get(InstructorDetails.class, 13);
            System.out.println(instructorDetails.getInstructor());
            instructorDetails.getInstructor().setInstructorDetails(null);
            session.delete(instructorDetails);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }

    }
}
