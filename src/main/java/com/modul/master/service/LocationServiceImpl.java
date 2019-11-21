package com.modul.master.service;

import com.modul.master.model.MstDistrict;
import com.modul.master.model.MstProvince;
import com.modul.master.model.MstRegion;
import com.modul.master.repository.LocationDao;
import com.modul.master.repository.SupplierDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class LocationServiceImpl implements LocationService {


    @Autowired
    LocationDao locationDao;

    @Override
    public MstProvince getProvinceById(int province_id) {
        return locationDao.getProvinceById(province_id);
    }

    @Override
    public List<MstProvince> getAllProvince() {
        return locationDao.getAllProvince();
    }

    @Override
    public MstRegion getRegionById(int region_id) {
        return locationDao.getRegionById(region_id);
    }

    @Override
    public List<MstRegion> getAllRegion() {
        return locationDao.getAllRegion();
    }

    @Override
    public MstDistrict getDistrictById(int district_id) {
        return locationDao.getDistrictById(district_id);
    }

    @Override
    public List<MstDistrict> getAllDistrict() {
        return locationDao.getAllDistrict();
    }
}
