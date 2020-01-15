package com.lalit.hibernate.mapping.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String... s) {
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg-mapping-many-to-many.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class
        ).buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
            Student student = session.get(Student.class, 2);
            session.delete(student);
            session.getTransaction().commit();
        }
    }
}
