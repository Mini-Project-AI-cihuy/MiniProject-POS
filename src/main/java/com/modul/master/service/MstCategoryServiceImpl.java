package com.modul.master.service;

import com.modul.master.model.MstCategory;
import com.modul.master.repository.MstCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MstCategoryServiceImpl implements MstCategoryService{

    @Autowired
    MstCategoryDao mstCategoryDao;

    public void save(MstCategory mstCategory){
        mstCategoryDao.save(mstCategory);
    }
    public void update(MstCategory mstCategory){
        mstCategoryDao.update(mstCategory);
    }
    public MstCategory getCategoryById(int id){
        return mstCategoryDao.getCategoryById(id);
    }
    public List<MstCategory> getAllCategories(){
        return mstCategoryDao.getAllCategories();
    }

}
