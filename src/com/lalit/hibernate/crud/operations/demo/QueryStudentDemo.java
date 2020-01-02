package com.lalit.hibernate.crud.operations.demo;

import com.lalit.hibernate.crud.operations.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String... s) {
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<Student> studentList = session.createQuery("from Student where id = 2")
                    .getResultList();
            studentList.stream().forEach(e -> System.out.println(e));
            session.getTransaction().commit();
            Session sessionUpdate = sessionFactory.getCurrentSession();
            sessionUpdate.beginTransaction();
            sessionUpdate.createQuery("update Student set email = 'foo@gmail.com'").executeUpdate();
            sessionUpdate.getTransaction().commit();
        }
    }
}
