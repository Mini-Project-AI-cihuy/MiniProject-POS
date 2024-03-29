package com.modul.master.repository;

import com.modul.master.model.MstDistrict;
import com.modul.master.model.MstProvince;
import com.modul.master.model.MstRegion;
import org.hibernate.Session;

import java.util.List;

public interface LocationDao {
    public MstProvince getProvinceById(int province_id) ;

    public List<MstProvince> getAllProvince() ;

    public MstRegion getRegionById(int region_id) ;

    public List<MstRegion> getAllRegion() ;

    public List<MstRegion> getAllRegionbyProvince(int idProvince) ;

    public List<MstDistrict> getAllDistrictbyRegion(int idRegion) ;


    public MstDistrict getDistrictById(int district_id) ;

    public List<MstDistrict> getAllDistrict() ;
}
