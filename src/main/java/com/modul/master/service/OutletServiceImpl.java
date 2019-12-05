package com.modul.master.service;

import com.modul.master.model.MstOutlet;
import com.modul.master.repository.OutletDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class OutletServiceImpl implements OutletService{

    @Autowired
    OutletDao outletDao;

    @Transactional(readOnly = false)
    @Override
    public void save(MstOutlet outlet) {
        outletDao.save(outlet);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(MstOutlet outlet) {
        outletDao.update(outlet);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(MstOutlet outlet) {
        outletDao.delete(outlet);
    }

    @Override
    public MstOutlet getOutlet(int id) {
        return outletDao.getOutletById(id);
    }

    @Override
    public List<MstOutlet> getOutlets() {
        return outletDao.getListOutlets();
    }

}
