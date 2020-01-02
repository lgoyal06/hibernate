package com.lalit.hibernate.mapping.onetooneonly;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String... s) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg-mapping.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Instructor instructor = new Instructor("lalit", "goyal", "lgoyal06@gmail.com");
        InstructorDetails instructorDetails = new InstructorDetails("http://www.youtube.com/lgoyal06", "coding");
        instructor.setInstructorDetails(instructorDetails);
        session.save(instructor);
        session.getTransaction().commit();
    }
}
