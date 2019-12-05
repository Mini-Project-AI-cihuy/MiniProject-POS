package com.modul.master.model;


import org.springframework.web.bind.annotation.CrossOrigin;
import sun.management.LazyCompositeData;

import javax.persistence.*;
import java.util.Date;
import java.util.IdentityHashMap;

@Entity
@Table(name = "pos_mst_user")
public class MstUser {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "role_id", nullable = false)
	private Integer roleId;
	@Column(name = "employee_id", nullable = false)
	private Integer employeeId;
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

	public MstUser() {
	}

	public MstUser(String username, String password, Integer roleId, Integer employeeId, int createdBy, Date createdOn, int modifiedBy, Date modifiedOn, boolean active, MstRole mstRole, MstEmployee mstEmployee) {
		this.username = username;
		this.password = password;
		this.roleId = roleId;
		this.employeeId = employeeId;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.modifiedBy = modifiedBy;
		this.modifiedOn = modifiedOn;
		this.active = active;
		this.mstRole = mstRole;
		this.mstEmployee = mstEmployee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

//	public int getRoleId() {
//		return roleId;
//	}
//
//	public void setRoleId(int roleId) {
//		this.roleId = roleId;
//	}
//
//	public int getEmployeeId() {
//		return employeeId;
//	}
//
//	public void setEmployeeId(int employeeId) {
//		this.employeeId = employeeId;
//	}


	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
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

	@Override
	public String toString() {
		return "MstUser{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", roleId=" + roleId +
				", employeeId=" + employeeId +
				", createdBy=" + createdBy +
				", createdOn=" + createdOn +
				", modifiedBy=" + modifiedBy +
				", modifiedOn=" + modifiedOn +
				", active=" + active +
				", mstRole=" + mstRole +
				", mstEmployee=" + mstEmployee +
				'}';
	}
}