package com.modul.master.repository;

import com.modul.master.model.TPurchaseRequest;
import com.modul.master.model.TPurchaseRequestDetail;
import com.modul.master.service.TPurchaseRequestService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TPurcahseRequestDaoImpl implements TPurchaseRequestDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<TPurchaseRequest> getPRByOutletId(int outletId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TPurchaseRequest.class);
        criteria.add(Restrictions.eq("outletId",outletId));
        return criteria.list();
    }

    @Override
    public List<TPurchaseRequest> getPRByStatus(String status, int outletId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TPurchaseRequest.class);
        criteria.add(Restrictions.eq("outletId",outletId));
        criteria.add(Restrictions.eq("status",status).ignoreCase());
        return criteria.list();
    }

    @Override
    public TPurchaseRequest getPRById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (TPurchaseRequest) session.get(TPurchaseRequest.class, id);
    }

    @Override
    public List<TPurchaseRequestDetail> getPRDetailByprId(int prId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TPurchaseRequestDetail.class);
        criteria.add(Restrictions.eq("prId",prId));
        return criteria.list();
    }

}
