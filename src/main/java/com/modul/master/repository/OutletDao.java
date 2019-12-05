package com.modul.master.repository;

import com.modul.master.model.MstOutlet;

import java.util.List;

public interface OutletDao {
    public  void save(MstOutlet outlet);
    public  void update(MstOutlet outlet);
    public  void delete(MstOutlet outlet);
    public MstOutlet getOutletById(int id);
    public List<MstOutlet> getListOutlets();
}
