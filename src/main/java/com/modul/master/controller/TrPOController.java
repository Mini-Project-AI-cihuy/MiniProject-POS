package com.modul.master.controller;

import com.modul.master.model.*;
import com.modul.master.service.OutletService;
import com.modul.master.service.SupplierService;
import com.modul.master.service.TrPOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TrPOController {
    @Autowired
    TrPOService trPOService;

    @Autowired
    OutletService outletService;

    @Autowired
    SupplierService supplierService;

    @RequestMapping("/listOrder")
    public String listPO(Model m, HttpSession session, ModelMap modelMap){
        List<TrPurchaseOrder> list = trPOService.getAllOrder();
        List<TrPurchaseOrderDetail> listD = trPOService.getAllOrderDetail();

        List<MstSupplier> listSupplier = supplierService.getSuppliers();
        Map<Integer, String> resultSupplier = new HashMap<>();
        for (MstSupplier supplier : listSupplier) {
            resultSupplier.put(supplier.getId(), supplier.getName());
        }
        m.addAttribute("listOrder", list);
        m.addAttribute("supplier", resultSupplier);
        m.addAttribute("editOrder", new TrPurchaseOrder());
        m.addAttribute("orderDetail", listD);

        MstOutlet outlet = (MstOutlet) session.getAttribute("outlet");
        MstOutlet temp = outletService.getOutlet(outlet.getId());
        modelMap.addAttribute("outlet", temp);

        return "TrPurchaseOrder/listOrder";
    }

    @RequestMapping(value = "/orderJson/{id}" , method = RequestMethod.GET)
    public @ResponseBody
    TrPurchaseOrder getOrder(@PathVariable int id) {
        //do business logic
        return trPOService.getOrder(id);
    }

}
