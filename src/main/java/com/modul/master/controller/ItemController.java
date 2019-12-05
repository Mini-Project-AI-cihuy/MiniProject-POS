package com.modul.master.controller;

import com.modul.master.model.*;
import com.modul.master.service.ItemService;
import com.modul.master.service.MstCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    MstCategoryService mstCategoryService;

    MstItem tempMstItem = null;
    MstItemVariant tempMstItemVariant = null;
    MstItemInventory tempMstItemInventory = null;
    List<MstItemInventory> tempListItemInventory = null;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public String listItem(Model m, HttpSession session) {
        MstOutlet outlet = (MstOutlet) session.getAttribute("outlet");
        System.out.println("idOutlet : " + outlet.getId());
        List<MstItemInventory> listInventory = itemService.getAllItemsbyOutletId(outlet.getId());
        //data for dropdown on pop up
        List<MstCategory> listCategory = mstCategoryService.getAllCategories();
        Map<Integer, String> resultCategory = new HashMap<>();
        for (MstCategory category : listCategory) {
            resultCategory.put(category.getId(), category.getName());
        }
        m.addAttribute("itemInventory", new MstItemInventory());
        m.addAttribute("item", new MstItem());
        m.addAttribute("itemVarian", new MstItemVariant());
        m.addAttribute("itemInventory", new MstItemInventory());
        m.addAttribute("category", resultCategory);
        m.addAttribute("items", listInventory);
        return "item/items";
    }

    @RequestMapping(value = "/updateItemInventory", method = RequestMethod.POST)
    public String updateItems(HttpSession session, @RequestParam("variantName") String variantName,
                @RequestParam("unitPrice") int unitPrice,
                @RequestParam("sku") String sku,
                @RequestParam("beginning") int beginning,
                @RequestParam("alertAt") int alertAt) {
        MstOutlet outlet = (MstOutlet) session.getAttribute("outlet");
        tempMstItemVariant = new MstItemVariant(variantName, sku, unitPrice);
        System.out.println(tempMstItemVariant.getId());
        System.out.println(tempMstItemVariant.getName());
        tempMstItemInventory = new MstItemInventory(tempMstItemVariant.getId(), outlet.getId(), beginning, alertAt);
        System.out.println(tempMstItemInventory.getAlertAtQty());
        return "item/items";
//        return "redirect:/items";
    }
}
