package dao.custom.impl;

import dao.custom.CoursesDAO;
import entity.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfigration;

import java.util.List;

public class CourseDAOImpl implements CoursesDAO {
    @Override
    public boolean add(Course entity) {
        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Course entity) {
        Session session = FactoryConfigration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(String s) {
        Session session = FactoryConfigration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Course courses = session.get(Course.class, s);
        session.delete(courses);

        transaction.commit();

        return true;
    }

    @Override
    public Course find(String s) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        Session session = FactoryConfigration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Course_Datail ");
        List<Course> list = query.list();

        transaction.commit();
        session.close();
        return list;
    }
}
