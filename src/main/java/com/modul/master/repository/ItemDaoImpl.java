package com.modul.master.repository;

import com.modul.master.model.MstItem;
import com.modul.master.model.MstItemInventory;
import com.modul.master.model.MstItemVariant;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(MstItemInventory mstItemInventory) {
        Session session = sessionFactory.getCurrentSession();
        session.save(mstItemInventory);
        session.flush();
    }

    @Override
    public void update(MstItemInventory mstItemInventory) {
        Session session = sessionFactory.getCurrentSession();
        session.update(mstItemInventory);
        session.flush();
    }

    @Override
    public MstItemInventory getItemById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (MstItemInventory) session.get(MstItemInventory.class, id);
    }

    @Override
    public List<MstItemInventory> getAllItems() {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(MstItemInventory.class);
        return crit.list();
    }
}
