package com.modul.master.service;

import com.modul.master.model.MstCategory;

import java.util.List;

public interface MstCategoryService {

    public void save(MstCategory mstCategory);
    public void update(MstCategory mstCategory);
    public MstCategory getCategoryById(int id);
    public List<MstCategory> getAllCategories();

}
