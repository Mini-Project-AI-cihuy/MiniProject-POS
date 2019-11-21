package com.modul.master.controller;

import com.modul.master.model.MstProvince;
import com.modul.master.model.MstSupplier;
import com.modul.master.service.LocationService;
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
    LocationService locationService;

    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    //get all suppliers
    @RequestMapping("/suppliers")
    public String viewUser(Model model){
        List<MstSupplier> list = supplierService.getSuppliers();
        model.addAttribute("supplier",list);
        return "supplier/suppliersIndex";
    }

    //detail supplier
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String getUser(ModelMap model, @PathVariable int id) {
        model.addAttribute("supplier", supplierService.getSupplier(id));
        return "supplier/detail";
    }


//    @Autowired
//    LocationService locationService;

//    @Autowired
//    UserValidator userValidator;

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.addValidators(userValidator);
//    }

//    @RequestMapping("/supplierForm")
//    public String showForm(Model m){
//        List<MstProvince> allRole = locationService.getAllProvince();
//        Map<Integer, String> province = new HashMap<>();
//        for(MstProvince curRole : allRole){
//            province.put(curRole.getId(), curRole.getName());
//        }
//        m.addAttribute("province", province);
//        m.addAttribute("supplier", new MstSupplier());
//        return "supplier/supplierForm";
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
