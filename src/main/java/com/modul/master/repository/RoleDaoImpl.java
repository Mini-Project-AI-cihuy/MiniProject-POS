package com.modul.master.repository;

import com.modul.master.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleDaoImpl implements RoleDao {

    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role getRoleById(int id_role) {
        Session session = sessionFactory.getCurrentSession();
        return (Role) session.get(Role.class, id_role);
    }

    @Override
    public List<Role> getAllRole() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Role.class).list();
    }


}
