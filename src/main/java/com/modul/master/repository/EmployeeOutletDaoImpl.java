package com.modul.master.repository;

import com.modul.master.model.EmployeeOutlet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeOutletDaoImpl implements EmployeeOutletDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(EmployeeOutlet employeeOutlet) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employeeOutlet);
        session.flush();
    }

    @Override
    public void update(EmployeeOutlet employeeOutlet) {
        Session session = sessionFactory.getCurrentSession();
        session.update(employeeOutlet);
        session.flush();
    }

    @Override
    public void delete(EmployeeOutlet employeeOutlet) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(employeeOutlet);
        session.flush();
    }

    @Override
    public EmployeeOutlet getEmployeeOutlet(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (EmployeeOutlet) session.get(EmployeeOutlet.class, id);
    }

    @Override
    public List<EmployeeOutlet> getAllEmployeeOutlet() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(EmployeeOutlet.class).list();
    }
}
