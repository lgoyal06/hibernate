package com.lalit.hibernate.mapping.onetomany.bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String... s) {
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg-mapping-one-to-many.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {
            Instructor instructor = new Instructor("lucky111", "aggarwal", "lali1t.goyal@gmail.com");
            InstructorDetails instructorDetails = new InstructorDetails("http://www.youtube.com/lalit1.goyal06", "coding");
            instructor.setInstructorDetails(instructorDetails);
            session.getTransaction().begin();
            session.save(instructor);
            session.getTransaction().commit();
        }
    }
}
