package com.modul.master.repository;

import com.modul.master.model.MstSupplier;

import java.util.List;


public interface SupplierDao {

    public void save(MstSupplier supplier);
    public void update(MstSupplier supplier);
    public void delete(MstSupplier supplier);
    public MstSupplier getSupplier(int id);
    public List<MstSupplier> getSuppliers();
    public List<MstSupplier> searchSuppliers(String param);

}
