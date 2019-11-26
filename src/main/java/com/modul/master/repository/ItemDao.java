package com.modul.master.repository;

import com.modul.master.model.MstCategory;
import com.modul.master.model.MstItem;

import java.util.List;

public interface MstItemDao {

    public void save(MstItem mstItem);
    public void update(MstItem mstItem);
    public MstItem getItemById(int id);
    public List<MstItem> getAllItems();

}
