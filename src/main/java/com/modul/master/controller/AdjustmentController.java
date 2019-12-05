package com.modul.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdjustmentController {


    @RequestMapping(value = "/cobaadjust", method = RequestMethod.GET)
    public String viewAdjustment(){

        return "adjustment/viewAdjustment";
    }
}
