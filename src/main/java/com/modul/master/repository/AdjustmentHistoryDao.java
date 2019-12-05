package com.modul.master.repository;

import com.modul.master.model.TrAdjustment;
import com.modul.master.model.TrAdjustmentHistory;

import java.util.List;

public interface AdjustmentHistoryDao {

    public void save(TrAdjustmentHistory adjustmentHistory);

    public void update(TrAdjustmentHistory adjustmentHistory);

    public void delete(TrAdjustmentHistory  adjustmentHistory);

    public TrAdjustmentHistory getAdjustmentHistory(int id);

    public List<TrAdjustmentHistory> getAdjustmentHistorybyId(int adjustmentId);

    public List<TrAdjustmentHistory> getAllAdjustmentHistory();
}
