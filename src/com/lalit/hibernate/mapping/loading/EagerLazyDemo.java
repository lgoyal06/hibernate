package com.lalit.hibernate.mapping.loading;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

import java.util.List;

public class EagerLazyDemo {

    public static void main(String... s) {
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg-mapping-one-to-many.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
            Instructor instructor = session.get(Instructor.class, 2);
            session.getTransaction().commit();
            session.close();
            Session session1 = sessionFactory.getCurrentSession();
            session1.getTransaction().begin();
            Query<Course> query = session1.createQuery("Select c from Course c where c.instructor.id =:theInstructorId", Course.class);
            query.setParameter("theInstructorId", 2);
            List<Course> courses = query.getResultList();
            instructor.setCourses(courses);
            session1.getTransaction().commit();
            System.out.println(instructor.getCourses());
        }
    }
}
