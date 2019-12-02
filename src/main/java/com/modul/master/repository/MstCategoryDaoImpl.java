package com.modul.master.repository;

import com.modul.master.model.MstCategory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MstCategoryDaoImpl implements MstCategoryDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(MstCategory mstCategory) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(mstCategory);
        session.flush();
    }

    @Override
    public void update(MstCategory mstCategory) {
        Session session = sessionFactory.getCurrentSession();
        session.update(mstCategory);
        session.flush();
    }

    @Override
    public MstCategory getCategoryById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (MstCategory) session.get(MstCategory.class, id);
    }

    @Override
    public List<MstCategory> getAllCategories() {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(MstCategory.class);
        crit.add(Restrictions.eq("active",0));
        List<MstCategory> results = crit.list();
        return results;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
