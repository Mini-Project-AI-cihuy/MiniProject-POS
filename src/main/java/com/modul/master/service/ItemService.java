package com.modul.master.service;

import com.modul.master.model.MstCategory;
import com.modul.master.model.MstItem;
import com.modul.master.model.MstItemInventory;

import java.util.List;

public interface ItemService {

    public void save(MstItemInventory mstItemInventory);
    public void update(MstItemInventory mstItemInventory);
    public MstItemInventory getItemById(int id);
    public List<MstItemInventory> getAllItems();
    public List<MstItemInventory> getAllItemsbyOutletId(int outletId);

}
