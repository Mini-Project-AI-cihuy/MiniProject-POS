package com.modul.master.repository;

import com.modul.master.model.MstDistrict;
import com.modul.master.model.MstProvince;
import com.modul.master.model.MstRegion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LocationDaoImpl implements LocationDao{

    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public MstProvince getProvinceById(int province_id) {
        Session session = sessionFactory.getCurrentSession();
        return (MstProvince) session.get(MstProvince.class, province_id);
    }

    @Override
    public List<MstProvince> getAllProvince() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MstProvince.class).list();
    }

    @Override
    public MstRegion getRegionById(int region_id) {
        Session session = sessionFactory.getCurrentSession();
        return (MstRegion) session.get(MstRegion.class, region_id);
    }

    @Override
    public List<MstRegion> getAllRegion() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MstRegion.class).list();
    }

    @Override
    public MstDistrict getDistrictById(int district_id) {
        Session session = sessionFactory.getCurrentSession();
        return (MstDistrict) session.get(MstDistrict.class, district_id);
    }

    @Override
    public List<MstDistrict> getAllDistrict() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MstDistrict.class).list();
    }
}
