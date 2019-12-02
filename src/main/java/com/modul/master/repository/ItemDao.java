package com.modul.master.repository;

import com.modul.master.model.MstCategory;
import com.modul.master.model.MstItem;
import com.modul.master.model.MstItemInventory;

import java.util.List;

public interface ItemDao {

    public void save(MstItemInventory mstItemInventory);
    public void update(MstItemInventory mstItemInventory);
    public MstItemInventory getItemById(int id);
    public List<MstItemInventory> getAllItems();

}
