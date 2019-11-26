package com.modul.master.repository;

import com.modul.master.model.MstCategory;
import com.modul.master.model.MstItem;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(MstItem mstItem) {
        Session session = sessionFactory.getCurrentSession();
        session.save(mstItem);
        session.flush();
    }

    @Override
    public void update(MstItem mstItem) {
        Session session = sessionFactory.getCurrentSession();
        session.update(mstItem);
        session.flush();
    }

    @Override
    public MstItem getItemById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (MstItem) session.get(MstItem.class, id);
    }

    @Override
    public List<MstItem> getAllItems() {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(MstItem.class);
        crit.add(Restrictions.eq("active", 0));
        return crit.list();
    }
}
