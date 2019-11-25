package com.modul.master.controller;

import com.modul.master.model.Role;
import com.modul.master.model.User;
import com.modul.master.service.RoleService;
import com.modul.master.service.UserService;
import com.modul.master.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserValidator userValidator;

    @Autowired
    RoleService roleService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }

    @RequestMapping("/userForm")
    public String showForm(Model m){
        List<Role> allRole = roleService.getAllRole();
        Map<Integer, String> role = new HashMap<>();
        for(Role curRole : allRole){
            role.put(curRole.getId_role(), curRole.getRole_type());
        }
        m.addAttribute("role", role);
        m.addAttribute("user", new User());
        return "formCategory";
    }

    /* It provides list of employees in model object */
    @RequestMapping("/user")
    public String viewUser(Model m){
        List<User> list = userService.getUsers();
        m.addAttribute("allUser",list);
        return "listCategory";
    }

    /*It saves object into database. The @ModelAttribute puts request data
     *  into model object. You need to mention RequestMethod.POST method
     *  because default request is GET*/
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(@Validated @ModelAttribute("user") User user, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "formCategory";
        }
        userService.save(user);
        return "redirect:/user";//will redirect to viewemp request mapping
    }

    /* It displays object data into form for the given id.
     * The @PathVariable puts URL data into variable.*/
    @RequestMapping(value="/editUser/{id}")
    public String edit(@PathVariable int id, Model m){
        User user = userService.getUser(id);
        m.addAttribute("user",user);
        return "editCategory";
    }
    /* It updates model object. */
    @RequestMapping(value="/editSave",method = RequestMethod.POST)
    public String editSave(@Validated @ModelAttribute("user") User user, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "formCategory";
        }
        userService.update(user);
        return "redirect:/user";
    }
    /* It deletes record for the given id in URL and redirects to /viewemp */
    @RequestMapping(value="/deleteUser/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        User user = userService.getUser(id);
        userService.delete(user);
        return "redirect:/user";
    }
}
