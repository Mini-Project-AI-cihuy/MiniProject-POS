package com.modul.master.controller;

import com.modul.master.model.*;
import com.modul.master.repository.LocationDao;
import com.modul.master.service.OutletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OutletController {
    @Autowired
    OutletService outletService;

    @Autowired
    LocationDao locationDao;

//    @RequestMapping("/")
//    public  String index (){
//        return "outlet/outlet";
//    }

    @RequestMapping("/outlets")
    public String listOutlet(Model model){
        List<MstOutlet> list = outletService.getOutlets();
        model.addAttribute("outlets",list);

        //data for pop up table
        List<MstProvince> allProvince = locationDao.getAllProvince();
        Map<Integer, String> province = new HashMap<>();
        for (MstProvince curProvince : allProvince) {
            province.put(curProvince.getId(), curProvince.getName());
        }
        List<MstRegion> allRegion = locationDao.getAllRegion();
        Map<Integer, String> region = new HashMap<>();
        for (MstRegion curegion : allRegion) {
            region.put(curegion.getId(), curegion.getName());
        }
        List<MstDistrict> allDistrict = locationDao.getAllDistrict();
        Map<Integer, String> district = new HashMap<>();
        for (MstDistrict curdistrict : allDistrict) {
            district.put(curdistrict.getId(), curdistrict.getName());
        }
        model.addAttribute("create", new MstOutlet());
        model.addAttribute("edit", new MstOutlet());
        model.addAttribute("province", province);
        model.addAttribute("region", region);
        model.addAttribute("district", district);
        return "outlet/outlet";
    }

    @RequestMapping(value = "/createOutlet", method = RequestMethod.POST)
    public String createOutlet(@Valid @ModelAttribute("create") MstOutlet outlet, BindingResult result){
        if (result.hasErrors()) {
            return "error";
        }
        outlet.setActive(true);
        outletService.save(outlet);
        return "redirect:/outlets";
    }

    //REST
//    @RequestMapping(value = "/outletJson/{id}" , method = RequestMethod.GET)
//    public @ResponseBody
//    MstOutlet getOutlet(@PathVariable int id) {
//        return outletService.getOutlet(id);
//    }

    @RequestMapping(value = "/editOutlet", method = RequestMethod.POST)
    public String editOutlet(@ModelAttribute("edit") MstOutlet outlet) {
        outlet.setActive(true);
        outletService.update(outlet);
        return "redirect:/outlets";
    }

    @RequestMapping("/deleteOutlet/{id}")
    public String deleteOutlet(@PathVariable int id) {
        MstOutlet outlet = outletService.getOutlet(id);
        outletService.delete(outlet);
        return "redirect:/outlets";
    }

    //rest
    @RequestMapping(value = "/outletJson/{id}" , method = RequestMethod.GET)
    public @ResponseBody
    MstOutlet getOutlet(@PathVariable int id ) {
        return outletService.getOutlet(id);
    }

}
