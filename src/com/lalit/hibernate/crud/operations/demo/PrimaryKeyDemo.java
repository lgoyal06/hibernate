package com.lalit.hibernate.crud.operations.demo;

import com.lalit.hibernate.crud.operations.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String... s) throws Exception {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Student student = new Student("Lucky", "Goyal", "lucky@gmail.com");
        Student student1 = new Student("Lucky", "Goyal", "lucky@gmail.com");
        Student student2 = new Student("Lucky", "Goyal", "lucky@gmail.com");
        //Active transaction is must in a order to perform save operation
        //Transaction help in maintaining ACID property of DB
        session.beginTransaction();
        session.save(student);
        session.save(student1);
        if (false)
            throw new Exception();
        session.save(student2);
        session.getTransaction().commit();
    }
}
