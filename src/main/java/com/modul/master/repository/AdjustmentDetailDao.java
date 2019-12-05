package com.modul.master.repository;

import com.modul.master.model.TrAdjustment;
import com.modul.master.model.TrAdjustmentDetail;

import java.util.List;

public interface AdjustmentDetailDao {
    public void save(TrAdjustmentDetail adjustmentDetail);

    public void update(TrAdjustmentDetail adjustmentDetail);

    public void delete(TrAdjustmentDetail adjustmentDetail);

    public TrAdjustmentDetail getAdjustmentDetail(int id);

    public List<TrAdjustmentDetail> getAdjustmentDetailsbyId(int adjustmentId);

    public List<TrAdjustmentDetail> getAllAdjustmentDetail();


}
