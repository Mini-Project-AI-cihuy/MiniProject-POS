package com.modul.master.service;


import com.modul.master.model.EmployeeOutlet;
import com.modul.master.repository.EmployeeOutletDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class EmployeeOutletService {

    @Autowired
    EmployeeOutletDao employeeOutletDao;

    public void save(EmployeeOutlet employeeOutlet) {
        employeeOutletDao.save(employeeOutlet);
    }


    public void update(EmployeeOutlet employeeOutlet) {
        employeeOutletDao.update(employeeOutlet);
    }

    public void delete(EmployeeOutlet employeeOutlet) {
        employeeOutletDao.delete(employeeOutlet);
    }


    public EmployeeOutlet getEmployeeOutletId(int id) {
        return employeeOutletDao.getEmployeeOutlet(id);
    }


    public List<EmployeeOutlet> getAllEmployeeOutlet() {
        return employeeOutletDao.getAllEmployeeOutlet();
    }
}