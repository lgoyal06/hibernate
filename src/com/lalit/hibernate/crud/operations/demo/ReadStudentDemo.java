package com.lalit.hibernate.crud.operations.demo;

import com.lalit.hibernate.crud.operations.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String... s) {
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {
            Student student = new Student("Lalit1", "Goyal", "lgoyal06@gmail.com");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            Session session1 = sessionFactory.getCurrentSession();
            //Read value
            session1.beginTransaction();
            Student student1 = session1.get(Student.class, student.getId());
            session1.getTransaction().commit();
            System.out.println(student1);
        }
    }
}
