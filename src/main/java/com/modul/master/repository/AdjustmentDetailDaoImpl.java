package com.modul.master.repository;

import com.modul.master.model.TrAdjustment;
import com.modul.master.model.TrAdjustmentDetail;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdjustmentDetailDaoImpl implements AdjustmentDetailDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(TrAdjustmentDetail adjustmentDetail) {
        Session session = sessionFactory.getCurrentSession();
        session.save(adjustmentDetail);
        session.flush();
    }

    @Override
    public void update(TrAdjustmentDetail adjustmentDetail) {
        Session session = sessionFactory.getCurrentSession();
        session.update(adjustmentDetail);
        session.flush();
    }

    @Override
    public void delete(TrAdjustmentDetail adjustmentDetail) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(adjustmentDetail);
        session.flush();
    }

    @Override
    public TrAdjustmentDetail getAdjustmentDetail(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (TrAdjustmentDetail) session.get(TrAdjustmentDetail.class, id);
    }

    @Override
    public List<TrAdjustmentDetail> getAdjustmentDetailsbyId(int adjustmentId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TrAdjustmentDetail.class);
        criteria.add(Restrictions.eq("adjustmentId", adjustmentId));
        return criteria.list();
    }

    @Override
    public List<TrAdjustmentDetail> getAllAdjustmentDetail() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(TrAdjustmentDetail.class).list();
    }
}
