package com.modul.master.repository;

import com.modul.master.model.MstEmployee;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeDAO {
	public void save(MstEmployee employee);
	public void update(MstEmployee employee);
	public void delete(MstEmployee employee);
	public MstEmployee getEmployee(int id);
	public List<MstEmployee> getEmployees();
	public List<MstEmployee> getEmployeeActive();

//	@Query(value = "SELECT * FROM pos_mst_employee WHERE active = true", nativeQuery = true)
//	List<MstEmployee> findAllActiveEmployee();
}
