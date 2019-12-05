package com.modul.master.repository;

import com.modul.master.model.MstSupplier;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
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
        session.saveOrUpdate(supplier);
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
        Criteria crit = session.createCriteria(MstSupplier.class);
        crit.add(Restrictions.eq("active", 0));
        return crit.list();
    }

    @Override
    public List<MstSupplier> searchSuppliers(String param) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(MstSupplier.class);
        Criterion byname = Restrictions.ilike("name", param, MatchMode.ANYWHERE);
        Criterion byaddress = Restrictions.ilike("address", param, MatchMode.ANYWHERE);
        Criterion byphone = Restrictions.ilike("phone", param, MatchMode.ANYWHERE);
        Criterion bymail = Restrictions.ilike("email", param, MatchMode.ANYWHERE);
        Disjunction orExp = Restrictions.or(byname, byaddress, byphone, bymail);
        criteria.add(orExp);
        return criteria.list();
    }
}