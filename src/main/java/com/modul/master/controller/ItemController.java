package com.modul.master.controller;

import com.modul.master.model.*;
import com.modul.master.service.ItemService;
import com.modul.master.service.MstCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    MstCategoryService mstCategoryService;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public String listItem(Model m){
        List<MstItemInventory> listInventory = itemService.getAllItems();
        //data for dropdown on pop up
        List<MstCategory> listCategory = mstCategoryService.getAllCategories();
        Map<Integer, String> resultCategory = new HashMap<>();
        for (MstCategory category : listCategory) {
            resultCategory.put(category.getId(), category.getName());
        }
        m.addAttribute("itemInventory", new MstItemInventory());
        m.addAttribute("category",resultCategory);
        m.addAttribute("items", listInventory);
        return "item/items";
    }
}
