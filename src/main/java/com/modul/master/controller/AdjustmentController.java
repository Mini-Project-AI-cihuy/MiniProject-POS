package com.modul.master.controller;


import com.modul.master.model.TrAdjustment;
import com.modul.master.model.TrAdjustmentDetail;
import com.modul.master.model.TrAdjustmentHistory;
import com.modul.master.service.AdjustmentDetailServiceImpl;
import com.modul.master.service.AdjustmentHistoryService;
import com.modul.master.service.AdjustmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdjustmentController {


    @Autowired
    AdjustmentServiceImpl adjustmentService;

    @Autowired
    AdjustmentDetailServiceImpl adjustmentDetailService;


    @Autowired
    AdjustmentHistoryService adjustmentHistoryService;

    @RequestMapping(value = "/viewAdjusts", method = RequestMethod.GET)
    public ModelAndView viewAdjustment() {
        ModelAndView mv = new ModelAndView("adjustment/viewAdjustment");
        mv.addObject("adjustments", adjustmentService.getAllAdjustment());
        return mv;
    }

    @RequestMapping(value = "/actionAdjust", method = RequestMethod.GET)
    public ModelAndView createorexport(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        if (request.getParameter("create") != null) {
            mv.setViewName("adjustment/detailAdjustment");
        } else if (request.getParameter("export") != null) {

        }
        return mv;
    }

    @RequestMapping(value = "/detailAdjust", method = RequestMethod.GET)
    public ModelAndView detailAdjustment(@RequestParam Integer id) {

        ModelAndView mv = new ModelAndView("adjustment/detailAdjustment");
        TrAdjustment adjustment = adjustmentService.getAdjustment(id);

        List<TrAdjustmentDetail> adjustmentDetail = adjustmentDetailService.getAdjustmentDetailbyId(id);

        List<TrAdjustmentHistory> adjustmentHistories = adjustmentHistoryService.getAdjustmentHistorybyId(id);

        mv.addObject("adjustments", adjustment);
        mv.addObject("adjustmentDetail", adjustmentDetail);
        mv.addObject("adjustmentHistory", adjustmentHistories);
        return mv;
    }
}
