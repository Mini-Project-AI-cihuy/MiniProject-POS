package com.modul.master.repository;

import com.modul.master.model.TrAdjustment;

import java.util.List;

public interface AdjustmentDao {

    public void save(TrAdjustment adjustment);

    public void update(TrAdjustment adjustment);

    public void delete(TrAdjustment adjustment);

    public TrAdjustment getAdjustment(int id);

    public List<TrAdjustment> getAllAdjustment();

    public List<TrAdjustment> getDistinctValue();
}
