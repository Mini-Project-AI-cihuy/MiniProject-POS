package com.modul.master.controller;

import com.modul.master.model.MstCategory;
import com.modul.master.model.MstItem;
import com.modul.master.model.MstItemInventory;
import com.modul.master.model.MstItemVariant;
import com.modul.master.service.ItemService;
import com.modul.master.service.MstCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    MstCategoryService mstCategoryService;

    MstItem tempMstItem;
    MstItemVariant tempMstItemVariant;


    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public String listItem(Model m) {
        List<MstItemInventory> listInventory = itemService.getAllItems();
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


//    //REST get district
//    @RequestMapping(value = "/updateItem/{id}" , method = RequestMethod.GET)
//    public @ResponseBody
//    MstItemVariant getDistricts(@PathVariable int id) {
//        //do business logic
//        return locationDao.getAllDistrictbyRegion(id);
//    }
//
//
//    @RequestMapping(value = "/updateItemInventory", method = RequestMethod.POST)
//    public String updateItems(@ModelAttribute("item") MstItem mstItem,
//                              @ModelAttribute("itemVarian") MstItemVariant mstItemVariant,
//                              @RequestParam("beginning") int beginning,
//                              @RequestParam("AlertAt") int alertAt) {
//
//        tempMstItem = new MstItem(mstItem.getName(), mstItem.getCategoryId());
//        tempMstItemVariant = new MstItemVariant(tempMstItem.getId(),
//                mstItemVariant.getName(),mstItemVariant.getSku(),mstItemVariant.getPrice());
//
//        return "item/itemVariantForm";
////        return "redirect:/items";
//    }
}
