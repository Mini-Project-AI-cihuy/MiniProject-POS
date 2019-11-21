package com.modul.master.service;

import com.modul.master.model.MstSupplier;
import com.modul.master.repository.SupplierDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierDao supplierDao;

    @Override
    public void save(MstSupplier supplier) {
        supplierDao.save(supplier);
    }

    @Override
    public void update(MstSupplier supplier) {
        supplierDao.update(supplier);
    }

    @Override
    public void delete(MstSupplier supplier) {
        supplierDao.delete(supplier);
    }

    @Override
    public MstSupplier getSupplier(int id) {
        return supplierDao.getSupplier(id);
    }

    @Override
    public List<MstSupplier> getSuppliers() {
        return supplierDao.getSuppliers();
    }
}
