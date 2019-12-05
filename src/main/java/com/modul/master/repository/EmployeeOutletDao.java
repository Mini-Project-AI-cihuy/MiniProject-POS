package com.modul.master.repository;

import com.modul.master.model.EmployeeOutlet;

import java.util.List;

public interface EmployeeOutletDao  {
    public void save(EmployeeOutlet employeeOutlet);
    public void update(EmployeeOutlet employeeOutlet);
    public void delete(EmployeeOutlet employeeOutlet);
    public EmployeeOutlet getEmployeeOutlet(int id);
    public List<EmployeeOutlet> getAllEmployeeOutlet();
}
