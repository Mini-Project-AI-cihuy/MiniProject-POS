package com.modul.master.controller;


import com.modul.master.model.*;
import com.modul.master.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
//    UserServiceImpl userServiceImpl;

    UserEmployeeService userEmployeeService;

    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    RoleService roleService;

    @Autowired
    OutletService outletService;

    @Autowired
    EmployeeOutletService employeeOutletService;


    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    public ModelAndView viewUser() {
        ModelAndView mv = new ModelAndView("employees/showEmployee");
        List<MstRole> list = roleService.getAllRole();
        Map<Integer, String> role = new HashMap<>();
        for (MstRole getRole : list) {
            role.put(getRole.getId(), getRole.getName());
        }
        List<MstOutlet> list1 = outletService.getOutlets();
        Map<Integer, String> outlet = new HashMap<>();
        for (MstOutlet getOutlet : list1) {
            outlet.put(getOutlet.getId(), getOutlet.getName());
        }
        mv.addObject("user", new MstUser());
        mv.addObject("employee", new MstEmployee());
        mv.addObject("roles", role);
        mv.addObject("employees", employeeService.getEmployeesActive());
        mv.addObject("outlets", outlet);
        return mv;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ModelAndView saveEmployee(String firstName, String lastName, String email, String title, String username,
                                     @RequestParam(value = "checkbox", required = false) String checkboxValue, String password,
                                     @RequestParam("mstUser.roleId") Integer roleId,
                                     @RequestParam("employeeOutlet.outletId") Integer outletId) {

        MstEmployee mstEmployee = new MstEmployee();
        EmployeeOutlet employeeOutlet = new EmployeeOutlet();
        MstUser mstUser = new MstUser();


        if (checkboxValue != null) {
            mstEmployee.setFirstName(firstName);
            mstEmployee.setLastName(lastName);
            mstEmployee.setEmail(email);
            mstEmployee.setTitle(title);
            mstEmployee.setActive(0);
            mstEmployee.setHaveAccount(true);
            employeeService.save(mstEmployee);

            employeeOutlet.setEmployeeId(mstEmployee.getId());
            employeeOutlet.setOutletId(outletId);
            employeeOutletService.save(employeeOutlet);

            mstUser.setUsername(username);
            mstUser.setPassword(password);
            mstUser.setActive(true);
            mstUser.setEmployeeId(mstEmployee.getId());
            mstUser.setRoleId(roleId);
            userEmployeeService.save(mstUser);
        } else {
            mstEmployee.setFirstName(firstName);
            mstEmployee.setLastName(lastName);
            mstEmployee.setEmail(email);
            mstEmployee.setTitle(title);
            mstEmployee.setActive(0);
            mstEmployee.setHaveAccount(false);
            employeeService.save(mstEmployee);

            employeeOutlet.setEmployeeId(mstEmployee.getId());
            employeeOutlet.setMstEmployee(mstEmployee);
            employeeOutlet.setOutletId(outletId);
            employeeOutletService.save(employeeOutlet);
        }
        return viewUser();
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editEmployee(@RequestParam Integer id, @ModelAttribute("employee") MstEmployee theEmployee) {
        ModelAndView mv = new ModelAndView("employees/editEmployee");
        MstEmployee employee = employeeService.getEmployeeId(id);

        List<MstRole> list = roleService.getAllRole();
        Map<Integer, String> role = new HashMap<>();
        for (MstRole getRole : list) {
            role.put(getRole.getId(), getRole.getName());
        }

        List<MstOutlet> list1 = outletService.getOutlets();
        Map<Integer, String> outlet = new HashMap<>();
        for (MstOutlet getOutlet : list1) {
            outlet.put(getOutlet.getId(), getOutlet.getName());
        }
        mv.addObject("employee", new MstEmployee());
        mv.addObject("employees", employee);
        mv.addObject("roles", role);
        mv.addObject("outlets", outlet);
        return mv;
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public ModelAndView updateEmployee(@RequestParam("idUser") int idUser, @RequestParam("idEmployeeOutlet") int idEmployeeOutlet,
                                       @RequestParam("idEmployee") int idEmployee, String firstName, String lastName, String email,
                                       String title, String username, String password, @RequestParam("mstUser.roleId") Integer roleId,
                                       @RequestParam("employeeOutlet.outletId") Integer outletId) {

        ModelAndView mv = new ModelAndView();
        MstEmployee mstEmployee = new MstEmployee();
        EmployeeOutlet employeeOutlet = new EmployeeOutlet();
        MstUser mstUser = new MstUser();

        mstEmployee.setId(idEmployee);
        mstEmployee.setFirstName(firstName);
        mstEmployee.setLastName(lastName);
        mstEmployee.setEmail(email);
        mstEmployee.setTitle(title);
        mstEmployee.setActive(0);
        mstEmployee.setHaveAccount(true);
        employeeService.update(mstEmployee);


        employeeOutlet.setId(idEmployeeOutlet);
        employeeOutlet.setEmployeeId(mstEmployee.getId());
        employeeOutlet.setOutletId(outletId);
        employeeOutletService.update(employeeOutlet);


        mstUser.setId(idUser);
        mstUser.setUsername(username);
        mstUser.setPassword(password);
        mstUser.setActive(true);
        mstUser.setEmployeeId(mstEmployee.getId());
        mstUser.setRoleId(roleId);
        userEmployeeService.update(mstUser);

        return viewUser();

    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteUser(@RequestParam Integer id) {
        ModelAndView mv = new ModelAndView();
        MstEmployee mstEmployee = employeeService.getEmployeeId(id);
        mstEmployee.setActive(1);
        employeeService.update(mstEmployee);
        return viewUser();
    }
}
