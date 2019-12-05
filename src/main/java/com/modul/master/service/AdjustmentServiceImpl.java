package com.modul.master.service;

import com.modul.master.model.TrAdjustment;
import com.modul.master.repository.AdjustmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class AdjustmentServiceImpl {

    @Autowired
    AdjustmentDao adjustmentDao;


    public void save(TrAdjustment adjustment) {
        adjustmentDao.save(adjustment);
    }


    public void update(TrAdjustment adjustment) {
        adjustmentDao.update(adjustment);
    }


    public void delete(TrAdjustment adjustment) {
        adjustmentDao.delete(adjustment);
    }


    public TrAdjustment getAdjustment(int id) {
      return adjustmentDao.getAdjustment(id);
    }

    public List<TrAdjustment> getAllAdjustment() {
        return adjustmentDao.getAllAdjustment();
    }

    public List<TrAdjustment> getAllAdjustmentDistinct(){
        return adjustmentDao.getDistinctValue();
    }

}
