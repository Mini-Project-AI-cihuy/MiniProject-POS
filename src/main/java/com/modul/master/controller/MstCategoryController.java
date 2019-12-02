package com.modul.master.controller;

import com.modul.master.model.MstCategory;
import com.modul.master.service.MstCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MstCategoryController {

    @Autowired
    MstCategoryService mstCategoryService;

    @RequestMapping("/formCategory")
    public String formCategory(Model m){
        m.addAttribute("category", new MstCategory());
        return "MstCategory/formCategory";
    }

    @RequestMapping("/listCategory")
    public String listCategory(Model m){
        List<MstCategory> list = mstCategoryService.getAllCategories();
        m.addAttribute("listCategory", list);
        m.addAttribute("category", new MstCategory());
        m.addAttribute("categoryD", new MstCategory());
        return "MstCategory/listCategory";
    }

//    @RequestMapping(value="/addCategory", method = RequestMethod.POST)
//    public String addCategory(@ModelAttribute("category") MstCategory mstCategory){
//        mstCategoryService.save(mstCategory);
//        return "redirect:/listCategory";
//    }

//    @RequestMapping(value="/editCategory/{id}")
//    public String editCategory(@PathVariable int id, Model m){
//        MstCategory mstCategory = mstCategoryService.getCategoryById(id);
//        m.addAttribute("category", mstCategory);
//        return "MstCategory/editCategory";
//    }
//
    @RequestMapping(value="/saveCategory", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("category") MstCategory mstCategory){
        mstCategoryService.save(mstCategory);
        return "redirect:/listCategory";
    }

    @RequestMapping(value="/deactivateCategory", method = RequestMethod.POST)
    public String deactivateCategory(@ModelAttribute("category") MstCategory mstCategory){
        MstCategory category = mstCategoryService.getCategoryById(mstCategory.getId());
        category.setActive(1);
        mstCategoryService.update(category);
        return "redirect:/listCategory";
    }

    //REST get supplier
    @RequestMapping(value = "/categoryJson/{id}" , method = RequestMethod.GET)
    public @ResponseBody
    MstCategory getCategoryById(@PathVariable int id) {
        //do business logic
        return mstCategoryService.getCategoryById(id);
    }

}
