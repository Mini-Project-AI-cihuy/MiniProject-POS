package com.modul.master.repository;

import com.modul.master.model.MstUser;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<MstUser> getUser() {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(MstUser.class);
        return crit.list();
    }

    @Override
    public void updateUser(MstUser user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        session.flush();
    }

}
