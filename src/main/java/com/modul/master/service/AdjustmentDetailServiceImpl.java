package com.modul.master.service;

import com.modul.master.model.TrAdjustmentDetail;
import com.modul.master.repository.AdjustmentDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.WebServiceRef;
import java.util.List;

@Transactional
@Service
public class AdjustmentDetailServiceImpl {

    @Autowired
    AdjustmentDetailDao  adjustmentDetailDao;


    public void save(TrAdjustmentDetail adjustmentDetail) {
        adjustmentDetailDao.save(adjustmentDetail);
    }

    public void update(TrAdjustmentDetail adjustmentDetail) {
        adjustmentDetailDao.update(adjustmentDetail);
    }

    public void delete(TrAdjustmentDetail adjustmentDetail) {
        adjustmentDetailDao.delete(adjustmentDetail);
    }

    public TrAdjustmentDetail getAdjustmentDetail(int id) {
        return adjustmentDetailDao.getAdjustmentDetail(id);
    }

    public List<TrAdjustmentDetail> getAdjustmentDetailbyId(int adjustmentId){
        return adjustmentDetailDao.getAdjustmentDetailsbyId(adjustmentId);
    }

    public List<TrAdjustmentDetail> getAllAdjustmentDetail() {
        return adjustmentDetailDao.getAllAdjustmentDetail();
    }
}
