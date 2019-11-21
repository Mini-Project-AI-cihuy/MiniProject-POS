package com.modul.master.repository;

import com.modul.master.model.MstSupplier;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupplierDaoImpl implements SupplierDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(MstSupplier supplier) {
        Session session = sessionFactory.getCurrentSession();
        session.save(supplier);
        session.flush();
    }

    @Override
    public void update(MstSupplier supplier) {
        Session session = sessionFactory.getCurrentSession();
        session.update(supplier);
        session.flush();
    }

    @Override
    public void delete(MstSupplier supplier) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(supplier);
        session.flush();
    }

    @Override
    public MstSupplier getSupplier(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (MstSupplier) session.get(MstSupplier.class, id);
    }

    @Override
    public List<MstSupplier> getSuppliers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MstSupplier.class).list();
    }
}
