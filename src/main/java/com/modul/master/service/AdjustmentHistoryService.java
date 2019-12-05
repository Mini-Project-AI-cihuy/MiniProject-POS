package com.modul.master.service;

import com.modul.master.model.TrAdjustment;
import com.modul.master.model.TrAdjustmentHistory;
import com.modul.master.repository.AdjustmentHistoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AdjustmentHistoryService {

    @Autowired
    AdjustmentHistoryDao adjustmentHistoryDao;


    public void save(TrAdjustmentHistory adjustmentHistory) {
        adjustmentHistoryDao.save(adjustmentHistory);
    }


    public void update(TrAdjustmentHistory adjustmentHistory) {
        adjustmentHistoryDao.update(adjustmentHistory);
    }


    public void delete(TrAdjustmentHistory adjustmentHistory) {
        adjustmentHistoryDao.delete(adjustmentHistory);
    }


    public TrAdjustmentHistory getAdjustmentHistory(int id) {
        return adjustmentHistoryDao.getAdjustmentHistory(id);
    }

    public List<TrAdjustmentHistory> getAllAdjustmentHistory() {
        return adjustmentHistoryDao.getAllAdjustmentHistory();
    }

    public List<TrAdjustmentHistory> getAdjustmentHistorybyId(int adjustmentId){
        return adjustmentHistoryDao.getAdjustmentHistorybyId(adjustmentId);
    }

}
