package com.modul.master.controller;


import com.modul.master.model.MstCategory;
import com.modul.master.model.MstItem;
import com.modul.master.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping("/items")
    public String listItem(Model m){
        List<MstItem> list = itemService.getAllItems();
        m.addAttribute("items", list);
        m.addAttribute("item", new MstItem());
        return "item/items";
    }
}
