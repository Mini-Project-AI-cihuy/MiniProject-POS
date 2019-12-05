package com.modul.master.repository;

import com.modul.master.model.TrAdjustmentHistory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdjustmentHistoryDaoImpl implements AdjustmentHistoryDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(TrAdjustmentHistory adjustmentHistory) {
        Session session = sessionFactory.getCurrentSession();
        session.save(adjustmentHistory);
        session.flush();
    }

    @Override
    public void update(TrAdjustmentHistory adjustmentHistory) {
        Session session = sessionFactory.getCurrentSession();
        session.update(adjustmentHistory);
        session.flush();
    }

    @Override
    public void delete(TrAdjustmentHistory adjustmentHistory) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(adjustmentHistory);
        session.flush();
    }

    @Override
    public TrAdjustmentHistory getAdjustmentHistory(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (TrAdjustmentHistory) session.get(TrAdjustmentHistory.class, id);
    }

    @Override
    public List<TrAdjustmentHistory> getAdjustmentHistorybyId(int adjustmentId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TrAdjustmentHistory.class);
        criteria.add(Restrictions.eq("adjustmentId", adjustmentId));
        return criteria.list();
    }

    @Override
    public List<TrAdjustmentHistory> getAllAdjustmentHistory() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(TrAdjustmentHistory.class).list();
    }
}
