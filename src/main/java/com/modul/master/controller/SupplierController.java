package com.modul.master.controller;

import com.modul.master.model.MstDistrict;
import com.modul.master.model.MstProvince;
import com.modul.master.model.MstRegion;
import com.modul.master.model.MstSupplier;
import com.modul.master.repository.LocationDao;
import com.modul.master.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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


    //get all suppliers
    @RequestMapping("/suppliers")
    public String viewUser(Model model){
        List<MstSupplier> list = supplierService.getSuppliers();
        model.addAttribute("supplier",list);
        return "supplier/suppliers";
    }

    //detail supplier
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String getUser(ModelMap model, @PathVariable int id) {
        model.addAttribute("supplier", supplierService.getSupplier(id));
        return "supplier/detail";
    }

    //add suplier
    @RequestMapping("/supplierForm")
    public String showForm(Model m){
        List<MstProvince> allProvince = locationDao.getAllProvince();
        Map<Integer, String> province = new HashMap<>();
        for(MstProvince curProvince : allProvince){
            province.put(curProvince.getId(), curProvince.getName());
        }
        List<MstRegion> allRegion = locationDao.getAllRegion();
        Map<Integer, String> region = new HashMap<>();
        for(MstRegion curegion : allRegion){
            region.put(curegion.getId(), curegion.getName());
        }
        List<MstDistrict> allDistrict = locationDao.getAllDistrict();
        Map<Integer, String> district = new HashMap<>();
        for(MstDistrict curdistrict : allDistrict){
            district.put(curdistrict.getId(), curdistrict.getName());
        }
        m.addAttribute("supplier", new MstSupplier());
        m.addAttribute("province", province);
        m.addAttribute("region", region);
        m.addAttribute("district", district);
        return "supplier/supplierForm";
    }

    //add supplier
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("supplier") MstSupplier supplier,  Model model){
//        if (result.hasErrors()) {
//            model.addAttribute("user", user);
//            return "userForm";
//        }
        supplierService.save(supplier);
        return "redirect:/suppliers";//will redirect to viewemp request mapping
    }

    //edit supplier
    @RequestMapping("/supplierForm/{id}")
    public String showFormEdit(Model m, @PathVariable int id){
        List<MstProvince> allProvince = locationDao.getAllProvince();
        Map<Integer, String> province = new HashMap<>();
        for(MstProvince curProvince : allProvince){
            province.put(curProvince.getId(), curProvince.getName());
        }
        List<MstRegion> allRegion = locationDao.getAllRegion();
        Map<Integer, String> region = new HashMap<>();
        for(MstRegion curegion : allRegion){
            region.put(curegion.getId(), curegion.getName());
        }
        List<MstDistrict> allDistrict = locationDao.getAllDistrict();
        Map<Integer, String> district = new HashMap<>();
        for(MstDistrict curdistrict : allDistrict){
            district.put(curdistrict.getId(), curdistrict.getName());
        }
        m.addAttribute("supplier", supplierService.getSupplier(id));
        m.addAttribute("province", province);
        m.addAttribute("region", region);
        m.addAttribute("district", district);
        return "supplier/supplierEditForm";
    }

    //add supplier
    @RequestMapping(value="/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("supplier") MstSupplier supplier,  Model model){
//        if (result.hasErrors()) {
//            model.addAttribute("user", user);
//            return "userForm";
//        }
        supplierService.update(supplier);
        return "redirect:/suppliers";//will redirect to viewemp request mapping
    }




//    @Autowired
//    UserValidator userValidator;
//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.addValidators(userValidator);
//    }


//    /*It saves object into database. The @ModelAttribute puts request data
//     *  into model object. You need to mention RequestMethod.POST method
//     *  because default request is GET*/
//    @RequestMapping(value="/save", method = RequestMethod.POST)
//    public String save(@Validated @ModelAttribute("user") User user, BindingResult result, Model model){
//        if (result.hasErrors()) {
//            model.addAttribute("user", user);
//            return "userForm";
//        }
//        supplierService.save(user);
//        return "redirect:/user";//will redirect to viewemp request mapping
//    }
//
//    /* It displays object data into form for the given id.
//     * The @PathVariable puts URL data into variable.*/
//    @RequestMapping(value="/editUser/{id}")
//    public String edit(@PathVariable int id, Model m){
//        User user = userService.getUser(id);
//        m.addAttribute("user",user);
//        return "userEditForm";
//    }
//    /* It updates model object. */
//    @RequestMapping(value="/editSave",method = RequestMethod.POST)
//    public String editSave(@Validated @ModelAttribute("user") User user, BindingResult result, Model model){
//        if (result.hasErrors()) {
//            model.addAttribute("user", user);
//            return "userForm";
//        }
//        userService.update(user);
//        return "redirect:/user";
//    }
//    /* It deletes record for the given id in URL and redirects to /viewemp */
//    @RequestMapping(value="/deleteUser/{id}",method = RequestMethod.GET)
//    public String delete(@PathVariable int id){
//        User user = userService.getUser(id);
//        userService.delete(user);
//        return "redirect:/user";
//    }
}
