package com.modul.master.service;

import com.modul.master.model.MstEmployee;
import com.modul.master.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class EmployeeServiceImpl {

    @Autowired
    EmployeeDAO employeeDAO;


    public void save(MstEmployee employee) {
        employeeDAO.save(employee);
    }


    public void update(MstEmployee employee) {
        employeeDAO.update(employee);
    }

    public void delete(MstEmployee employee) {
        employeeDAO.delete(employee);
    }


    public MstEmployee getEmployeeId(int id) {
        return employeeDAO.getEmployee(id);
    }


    public List<MstEmployee> getEmployees() {
        return employeeDAO.getEmployees();
    }

    public List<MstEmployee> getEmployeesActive() {
        return employeeDAO.getEmployeeActive();
    }
}
