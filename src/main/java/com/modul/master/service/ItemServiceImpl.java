package com.modul.master.service;

import com.modul.master.model.MstItem;
import com.modul.master.repository.ItemDao;
import com.modul.master.service.ItemService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
    public void save(MstItem mstItem) {
        itemDao.save(mstItem);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(MstItem mstItem) {
        itemDao.update(mstItem);
    }

    @Override
    public MstItem getItemById(int id) {
        return itemDao.getItemById(id);
    }

    @Override
    public List<MstItem> getAllItems() {
        return itemDao.getAllItems();
    }
}
