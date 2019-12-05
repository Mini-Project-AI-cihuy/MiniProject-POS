package com.modul.master.service;

import com.modul.master.model.MstDistrict;
import com.modul.master.model.MstProvince;
import com.modul.master.model.MstRegion;
import com.modul.master.model.MstSupplier;

import java.util.List;

public interface SupplierService {
    public void save(MstSupplier supplier);
    public void delete(MstSupplier supplier);
    public MstSupplier getSupplier(int id);
    public List<MstSupplier> getSuppliers();
    public List<MstSupplier> searchSuppliers(String search);
}