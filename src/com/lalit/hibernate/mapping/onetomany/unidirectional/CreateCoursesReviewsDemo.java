package com.lalit.hibernate.mapping.onetomany.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesReviewsDemo {

    public static void main(String... s) {
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg-mapping-one-to-many-uni.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Review.class).buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
            Course courseA = new Course("Title A 2");
            Review review = new Review("Great Course");
            Review review2 = new Review("Wastage of money Course");
            courseA.addReview(review);
            courseA.addReview(review2);
            session.save(courseA);
            session.getTransaction().commit();
        }
    }
}
