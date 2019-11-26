package com.modul.master.controller;

import com.modul.master.model.MstCategory;
import com.modul.master.service.MstCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MstCategoryController {

    @Autowired
    MstCategoryService mstCategoryService;

    @RequestMapping("/formCategory")
    public String formCategory(Model m){
        m.addAttribute("category", new MstCategory());
        return "category/formCategory";
    }

    @RequestMapping("/listCategory")
    public String listCategory(Model m){
        List<MstCategory> list = mstCategoryService.getAllCategories();
        m.addAttribute("listCategory", list);
        m.addAttribute("category", new MstCategory());
        return "category/listCategory";
    }

    @RequestMapping(value="/addCategory", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") MstCategory mstCategory){
        mstCategoryService.save(mstCategory);
        return "redirect:/listCategory";
    }

    @RequestMapping(value="/editCategory/{id}")
    public String editCategory(@PathVariable int id, Model m){
        MstCategory mstCategory = mstCategoryService.getCategoryById(id);
        m.addAttribute("category", mstCategory);
        return "category/editCategory";
    }

    @RequestMapping(value="/saveCategory", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("category") MstCategory mstCategory){
        mstCategoryService.update(mstCategory);
        return "redirect:/listCategory";
    }

    @RequestMapping(value="/deactivateCategory/{id}", method = RequestMethod.GET)
    public String deactivateCategory(@PathVariable int id){
        MstCategory mstCategory = mstCategoryService.getCategoryById(id);
        mstCategory.setActive(1);
        mstCategoryService.update(mstCategory);
        return "redirect:/listCategory";
    }
}
