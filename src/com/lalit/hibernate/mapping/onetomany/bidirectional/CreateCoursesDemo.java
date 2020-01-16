package com.lalit.hibernate.mapping.onetomany.bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

    public static void main(String... s) {
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg-mapping-one-to-many.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {
            Course courseA = new Course("Title A 2");
            Course courseB = new Course("Title B 2");
            Course courseC = new Course("Title C 2");
            session.getTransaction().begin();
            Instructor instructor = session.get(Instructor.class, 2);
            courseA.setInstructor(instructor);
            courseB.setInstructor(instructor);
            courseC.setInstructor(instructor);
            //instructor.add(courseA);
            //instructor.add(courseB);
            //instructor.add(courseC);
            session.save(courseA);
            session.save(courseB);
            session.save(courseC);
            session.getTransaction().commit();
        }
    }
}
