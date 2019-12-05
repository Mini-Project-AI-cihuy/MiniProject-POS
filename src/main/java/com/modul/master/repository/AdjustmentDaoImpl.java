package com.modul.master.repository;

import com.modul.master.model.TrAdjustment;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdjustmentDaoImpl implements AdjustmentDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(TrAdjustment adjustment) {
        Session session = sessionFactory.getCurrentSession();
        session.save(adjustment);
        session.flush();
    }

    @Override
    public void update(TrAdjustment adjustment) {
        Session session = sessionFactory.getCurrentSession();
        session.update(adjustment);
        session.flush();
    }

    @Override
    public void delete(TrAdjustment adjustment) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(adjustment);
        session.flush();
    }

    @Override
    public TrAdjustment getAdjustment(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (TrAdjustment) session.get(TrAdjustment.class, id);
    }

    @Override
    public List<TrAdjustment> getAllAdjustment() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(TrAdjustment.class).list();
    }

    @Override
    public List<TrAdjustment> getDistinctValue() {
        return sessionFactory.getCurrentSession()
            .createCriteria(TrAdjustment.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }
}
