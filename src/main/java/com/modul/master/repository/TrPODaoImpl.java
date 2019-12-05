package com.modul.master.repository;

import com.modul.master.model.MstCategory;
import com.modul.master.model.TrPurchaseOrder;
import com.modul.master.model.TrPurchaseOrderDetail;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrPODaoImpl implements TrPODao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public TrPurchaseOrder getOrder(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (TrPurchaseOrder) session.get(TrPurchaseOrder.class, id);
    }

    @Override
    public List<TrPurchaseOrder> getAllOrder() {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(TrPurchaseOrder.class);
        return crit.list();
    }

    @Override
    public List<TrPurchaseOrderDetail> getAllOrderDetail() {
        Session session = sessionFactory.getCurrentSession();
        Criteria critD = session.createCriteria(TrPurchaseOrderDetail.class);
        return critD.list();
    }
}
