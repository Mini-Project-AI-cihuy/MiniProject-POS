package com.modul.master.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pos_mst_employee")
public class MstEmployee {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email", nullable = true)
	private String email;
	@Column(name = "title", nullable = true)
	private String title;
	@Column(name = "have_account")
	private boolean haveAccount;
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

	@OneToOne(mappedBy = "mstEmployee", cascade = CascadeType.ALL)
	private EmployeeOutlet employeeOutlet;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isHaveAccount() {
		return haveAccount;
	}

	public void setHaveAccount(boolean haveAccount) {
		this.haveAccount = haveAccount;
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

//	public EmployeeOutlet getEmployeeOutlet() {
//		return employeeOutlet;
//	}
//
//	public void setEmployeeOutlet(EmployeeOutlet employeeOutlet) {
//		this.employeeOutlet = employeeOutlet;
//	}
}
