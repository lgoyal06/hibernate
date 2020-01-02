package com.lalit.hibernate.crud.operations.demo;

import com.lalit.hibernate.crud.operations.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String... s) {
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {
            Student student = new Student("Lalit", "Goyal", "lgoyal06@gmail.com");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }
    }
}
