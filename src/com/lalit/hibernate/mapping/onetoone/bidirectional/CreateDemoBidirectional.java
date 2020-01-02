package com.lalit.hibernate.mapping.onetoone.bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemoBidirectional {
    public static void main(String... s) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg-mapping.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Instructor instructor = new Instructor("lucky11", "aggarwal", "lalit.goyal@gmail.com");
        InstructorDetails instructorDetails = new InstructorDetails("http://www.youtube.com/lalit.goyal06", "coding");
        instructorDetails.setInstructor(instructor);
        instructor.setInstructorDetails(instructorDetails);
        session.save(instructorDetails);
        session.getTransaction().commit();
    }
}
