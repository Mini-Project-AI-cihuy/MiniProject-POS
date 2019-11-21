package com.modul.master.service;

import com.modul.master.model.MstDistrict;
import com.modul.master.model.MstProvince;
import com.modul.master.model.MstRegion;

import java.util.List;

public interface LocationService {
    public MstProvince getProvinceById(int province_id) ;

    public List<MstProvince> getAllProvince() ;

    public MstRegion getRegionById(int region_id) ;

    public List<MstRegion> getAllRegion() ;

    public MstDistrict getDistrictById(int district_id) ;

    public List<MstDistrict> getAllDistrict() ;
}
