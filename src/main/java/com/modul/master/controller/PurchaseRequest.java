package com.modul.master.controller;

import com.modul.master.model.MstDistrict;
import com.modul.master.model.MstOutlet;
import com.modul.master.model.TPurchaseRequest;
import com.modul.master.model.TPurchaseRequestDetail;
import com.modul.master.service.OutletService;
import com.modul.master.service.TPurchaseRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PurchaseRequest {

    @Autowired
    OutletService outletService;

    @Autowired
    TPurchaseRequestService tPurchaseRequestService;

    @RequestMapping(value = "/listRequest",method = RequestMethod.GET)
    public String listPR(HttpSession session, ModelMap modelMap){
        MstOutlet outlet = (MstOutlet) session.getAttribute("outlet");
        MstOutlet temp = outletService.getOutlet(outlet.getId());
        modelMap.addAttribute("outlet",temp);
        modelMap.addAttribute("request", new TPurchaseRequest());
        modelMap.addAttribute("requestDetail", new TPurchaseRequestDetail());
        modelMap.addAttribute("listRequest", tPurchaseRequestService.getPRByOutletId(outlet.getId()));
        System.out.println(outlet.getId());
        return "purchaseRequest/listPurchaseRequest";
//        return "purchaseRequest/formRequest";
    }

    //REST get request by status
    @RequestMapping(value = "/requestJson/{status}" , method = RequestMethod.GET)
    public @ResponseBody
    List<TPurchaseRequest> getRequest(HttpSession session, @PathVariable String status) {
        //do business logic
        MstOutlet outlet = (MstOutlet) session.getAttribute("outlet");
        return tPurchaseRequestService.getPRByStatus(status,outlet.getId());
    }

    //REST get request by id
    @RequestMapping(value = "/requestJsonById/{id}" , method = RequestMethod.GET)
    public @ResponseBody
    TPurchaseRequest getRequestById(@PathVariable int id) {
        //do business logic
        return tPurchaseRequestService.getPRById(id);
    }

    //REST get request by status
    @RequestMapping(value = "/requestDetailJsonByPrId/{prId}" , method = RequestMethod.GET)
    public @ResponseBody
    List<TPurchaseRequestDetail> getRequest(@PathVariable int prId) {
        //do business logic
        return tPurchaseRequestService.getPRDetailByprId(prId);
    }

}
