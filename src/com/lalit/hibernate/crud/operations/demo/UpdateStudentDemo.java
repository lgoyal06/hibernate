package com.lalit.hibernate.crud.operations.demo;

import com.lalit.hibernate.crud.operations.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String... s) {
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            //SessionFactory--> Session --> Transaction
            Student student = new Student("Lalit45", "Goyal", "lgoyal06@gmail.com");
            session.beginTransaction();
            session.save(student);

            Student student1 = session.get(Student.class, student.getId());

            // session.getTransaction().commit();
            Session session1 = sessionFactory.getCurrentSession();
            // session1.beginTransaction();
            student1.setEmail("lalit.goyal1@gmail.com");
            session.getTransaction().commit();
            System.out.println(student1);
        }
    }
}
