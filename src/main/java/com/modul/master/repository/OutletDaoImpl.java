package com.modul.master.repository;

import com.modul.master.model.MstOutlet;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OutletDaoImpl implements OutletDao{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(MstOutlet outlet) {
        Session session = sessionFactory.getCurrentSession();
        session.save(outlet);
        session.flush();
    }

    @Override
    public void update(MstOutlet outlet) {
        Session session = sessionFactory.getCurrentSession();
        session.update(outlet);
        session.flush();
    }

    @Override
    public void delete(MstOutlet outlet) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(outlet);
        session.flush();
    }

    @Override
    public MstOutlet getOutletById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (MstOutlet) session.get(MstOutlet.class, id);
    }

    @Override
    public List<MstOutlet> getListOutlets() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MstOutlet.class).list();
    }

//    @Override
//    public List<MstOutlet> getListOutlets() {
//        Session session = sessionFactory.getCurrentSession();
//        Criteria crit = session.createCriteria(MstOutlet.class);
//        crit.add(Restrictions.eq("active", 0));
//        return crit.list();
//    }
}
