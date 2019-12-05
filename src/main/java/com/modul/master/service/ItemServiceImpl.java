package com.modul.master.service;

import com.modul.master.model.MstItem;
import com.modul.master.model.MstItemInventory;
import com.modul.master.repository.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemDao itemDao;

    @Transactional(readOnly = false)
    @Override
    public void save(MstItemInventory mstItemInventory) {
        itemDao.save(mstItemInventory);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(MstItemInventory mstItemInventory) {
        itemDao.update(mstItemInventory);
    }

    @Override
    public MstItemInventory getItemById(int id) {
        return itemDao.getItemById(id);
    }

    @Override
    public List<MstItemInventory> getAllItems() {
        return itemDao.getAllItems();
    }

    @Override
    public List<MstItemInventory> getAllItemsbyOutletId(int outletId) {
        return itemDao.getAllItemsByOutletId(outletId);
    }
}
