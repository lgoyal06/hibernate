package com.lalit.hibernate.mapping.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentAndCoursesDemo {

    public static void main(String... s) {
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg-mapping-many-to-many.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class
        ).buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();

            Student student1 = new Student("Lalit4", "Goyal4", "lgoyaly@gmail.com");
            Student student2 = new Student("Lalit5", "Goyal5", "lgoyalyy@gmail.com");
            Student student3 = new Student("Lalit6", "Goyal6", "lgoyalyy@gmail.com");
            session.save(student1);
            session.save(student2);
            session.save(student3);
            Course courseA = new Course("Title A 21");
            Review review = new Review("Great Course");
            Review review2 = new Review("Wastage of money Course");
            courseA.addStudent(student1);
            courseA.addStudent(student2);
            courseA.addStudent(student3);
            courseA.addReview(review);
            courseA.addReview(review2);
            session.save(courseA);
            session.getTransaction().commit();
        }
    }
}
