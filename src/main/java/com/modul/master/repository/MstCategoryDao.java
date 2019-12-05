package com.modul.master.repository;

import com.modul.master.model.MstCategory;

import java.util.List;

public interface MstCategoryDao {

    public void save(MstCategory mstCategory);
    public void update(MstCategory mstCategory);
    public MstCategory getCategoryById(int id);
    public List<MstCategory> getAllCategories();

}
