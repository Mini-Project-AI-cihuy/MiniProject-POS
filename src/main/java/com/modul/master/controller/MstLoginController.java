package com.modul.master.controller;

import com.modul.master.model.MstUser;
import com.modul.master.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class MstLoginController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView m = new ModelAndView();
        if (error != null) {
            m.addObject("error", "Invalid username and password error.");
        }

        if (logout != null) {
            m.addObject("msg", "You have left successfully.");
        }

        m.setViewName("MstLogin/login");
        return m;
    }

    @RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
    public String pageResetPassword(ModelMap modelMap) {
        return "MstLogin/resetPassword";
    }

    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public String resetPassword(HttpSession session,
                                @RequestParam(value = "email", required = false) String email,
                                @RequestParam(value = "password", required = false) String password,
                                @RequestParam(value = "repassword", required = false) String repassword,
                                ModelMap modelMap) {
        MstUser user = userService.getUserByEmail(email);
        if (email.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
            modelMap.addAttribute("errorMatch", "Form cannot empty!");
        } else if (user == null) {
            modelMap.addAttribute("error", "invalid email");
        } else if (!repassword.equalsIgnoreCase(password)){
            modelMap.addAttribute("errorMatch", "New Password and Re-Password are not match");
        } else if (user != null) {
            user.setPassword(password);
            userService.updateUser(user);
            session.setAttribute("msg", "Reset Password Succeed");
            return "redirect:/login";
        }
        return "MstLogin/resetPassword";
    }

}
