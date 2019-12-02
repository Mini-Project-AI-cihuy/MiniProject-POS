package com.modul.master.model;


import org.springframework.web.bind.annotation.CrossOrigin;
import sun.management.LazyCompositeData;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_mst_user")
public class MstUser {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "role_id")
	private int roleId;
	@Column(name = "employee_id")
	private int employeeId;
	@Column(name = "created_by",nullable = true)
	private int createdBy;
	@Column(name = "created_on", nullable = true)
	private Date createdOn;
	@Column(name = "modified_by",nullable = true)
	private int modifiedBy;
	@Column(name = "modified_on", nullable = true)
	private Date modifiedOn;
	@Column(name = "active")
	private boolean active;


	@ManyToOne(targetEntity = MstRole.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
	private MstRole mstRole;


	@OneToOne(targetEntity = MstEmployee.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id", referencedColumnName = "id", insertable = false, updatable = false)
	private MstEmployee mstEmployee;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public MstRole getMstRole() {
		return mstRole;
	}

	public void setMstRole(MstRole mstRole) {
		this.mstRole = mstRole;
	}

	public MstEmployee getMstEmployee() {
		return mstEmployee;
	}

	public void setMstEmployee(MstEmployee mstEmployee) {
		this.mstEmployee = mstEmployee;
	}
}