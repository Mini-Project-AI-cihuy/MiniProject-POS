package com.modul.master.service;

import com.modul.master.model.MstOutlet;

import java.util.List;

public interface OutletService {
    public void save(MstOutlet outlet);
    public void update(MstOutlet outlet);
    public void delete(MstOutlet outlet);
    public MstOutlet getOutlet(int id);
    public List<MstOutlet> getOutlets();
}
