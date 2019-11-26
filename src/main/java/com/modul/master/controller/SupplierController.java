package com.modul.master.controller;

import com.modul.master.model.*;
import com.modul.master.repository.LocationDao;
import com.modul.master.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @Autowired
    LocationDao locationDao;

    //index supplier
    @RequestMapping(value = "/suppliers", method = RequestMethod.GET)
    public String indexSupplier(Model model) {
        //data for table
        List<MstSupplier> list = supplierService.getSuppliers();
        model.addAttribute("suppliers", list);
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
        model.addAttribute("supplier", new MstSupplier());
        model.addAttribute("supplierEdit", supplierService.getSupplier(1));
        model.addAttribute("province", province);
        model.addAttribute("region", region);
        model.addAttribute("district", district);
        model.addAttribute("search", new Search());
        return "supplier/suppliers";
    }

    //index supplier
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchSupplier(@ModelAttribute Search search,Model model) {
        //data for table
        List<MstSupplier> list = supplierService.searchSuppliers(search.getAny());
        model.addAttribute("suppliers", list);
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
        model.addAttribute("supplier", new MstSupplier());
        model.addAttribute("supplierEdit", supplierService.getSupplier(1));
        model.addAttribute("province", province);
        model.addAttribute("region", region);
        model.addAttribute("district", district);
        model.addAttribute("search", new Search());
        return "supplier/suppliers";
    }

    //detail supplier
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String getSupplier(ModelMap model, @PathVariable int id) {
        model.addAttribute("supplier", supplierService.getSupplier(id));
        model.addAttribute("region", locationDao.getRegionById(supplierService.getSupplier(id).getRegionId()));
        return "supplier/detail";
    }

    //add supplier
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("supplier") MstSupplier supplier, Model model) {
//        if (result.hasErrors()) {
//            model.addAttribute("user", user);
//            return "userForm";
//        }
        supplierService.save(supplier);
        return "redirect:/suppliers";//will redirect to viewemp request mapping
    }

    //edit supplier
    //index supplier
    @RequestMapping(value = "/supplierFormEdit/{id}", method = RequestMethod.GET)
    public String editSupplier(Model model,@PathVariable int id) {
        //data for table
        List<MstSupplier> list = supplierService.getSuppliers();
        model.addAttribute("suppliers", list);
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

        model.addAttribute("supplierEdit", supplierService.getSupplier(id));
        model.addAttribute("province", province);
        model.addAttribute("region", region);
        model.addAttribute("district", district);
        return "supplier/supplierEditForm";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("supplier") MstSupplier supplier, Model model) {
//        if (result.hasErrors()) {
//            model.addAttribute("user", user);
//            return "userForm";
//        }
        supplierService.update(supplier);
        return "redirect:/suppliers";//will redirect to viewemp request mapping
    }

    //delete
    @RequestMapping(value = "/deactivatedSupplier/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        MstSupplier supplier = supplierService.getSupplier(id);
        supplier.setActive(1);
        supplierService.update(supplier);
        return "redirect:/suppliers";
    }


//    @Autowired
//    UserValidator userValidator;
//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.addValidators(userValidator);
//    }

}
