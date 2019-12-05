package com.modul.master.repository;


import com.modul.master.model.MstRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public void save(MstRole role) {
        Session session = sessionFactory.getCurrentSession();
        session.save(role);
        session.flush();
    }

    @Override
    public void update(MstRole role) {
        Session session = sessionFactory.getCurrentSession();
        session.update(role);
        session.flush();
    }

    @Override
    public void delete(MstRole role) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(role);
        session.flush();
    }

    @Override
    public MstRole getRole(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (MstRole) session.get(MstRole.class, id);
    }

    @Override
    public List<MstRole> getRoles() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MstRole.class).list();
    }
}
