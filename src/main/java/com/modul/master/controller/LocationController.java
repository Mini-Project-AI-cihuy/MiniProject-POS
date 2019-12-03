package com.modul.master.controller;

import com.modul.master.model.MstDistrict;
import com.modul.master.model.MstRegion;
import com.modul.master.model.MstSupplier;
import com.modul.master.repository.LocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LocationController {

    @Autowired
    LocationDao locationDao;

    //REST get regions
    @RequestMapping(value = "/regionJson/{id}" , method = RequestMethod.GET)
    public @ResponseBody
    List<MstRegion> getRegions(@PathVariable int id) {
        //do business logic
        return locationDao.getAllRegionbyProvince(id);
    }

    //REST get district
    @RequestMapping(value = "/districtJson/{id}" , method = RequestMethod.GET)
    public @ResponseBody
    List<MstDistrict> getDistricts(@PathVariable int id) {
        //do business logic
        return locationDao.getAllDistrictbyRegion(id);
    }
}
