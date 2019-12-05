package com.modul.master.repository;

import com.modul.master.model.MstEmployee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//import org.hibernate.Query;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
    SessionFactory sessionFactory;


	@Override
	public void save(MstEmployee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);
		session.flush();
	}

	@Override
	public void update(MstEmployee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.update(employee);
		session.flush();
	}

	@Override
	public void delete(MstEmployee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(employee);
		session.flush();
	}

	@Override
	public MstEmployee getEmployee(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (MstEmployee) session.get(MstEmployee.class, id);
	}

	@Override
	public List<MstEmployee> getEmployees() {
		Session session = sessionFactory.openSession();
		return session.createCriteria(MstEmployee.class).list();
	}

	@Override
	public List<MstEmployee> getEmployeeActive() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MstEmployee.class);
		criteria.add(Restrictions.eq("active", 0));
		return criteria.list();
	}

//	@Override
//	public List<MstEmployee> getEmployeeActive() {
//		Session session = sessionFactory.openSession();
//		Query<MstEmployee> employeeQuery = session.createSQLQuery("SELECT * FROM pos_mst_employee WHERE active = 1").addEntity(MstEmployee.class);
//		return employeeQuery.getResultList();
//	}

}
