package com.lalit.hibernate.mapping.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudentDemo {

    public static void main(String... s) {
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg-mapping-many-to-many.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class
        ).buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
            Course courseA = new Course("Title A 222");
            Review review = new Review("Great Course");
            Review review2 = new Review("Wastage of money Course");
            courseA.addReview(review);
            courseA.addReview(review2);
            session.save(courseA);
            Student student1 = new Student("Lalit1", "Goyal1", "lgoyalxxx@gmail.com");
            Student student2 = new Student("Lalit2", "Goyal2", "lgoyalxxxx@gmail.com");
            Student student3 = new Student("Lalit3", "Goyal3", "lgoyalxxxxx@gmail.com");
            courseA.addStudent(student1);
            courseA.addStudent(student2);
            courseA.addStudent(student3);
            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.getTransaction().commit();
        }
    }
}
