package com.modul.master.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pos_mst_employee")
public class MstEmployee {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
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
	private int active;

	@OneToOne(mappedBy = "mstEmployee", cascade = CascadeType.ALL)
	private EmployeeOutlet employeeOutlet;

	@OneToOne(mappedBy = "mstEmployee", cascade = CascadeType.ALL)
	private MstUser mstUser;

	public MstEmployee() {

	}

	public MstEmployee(String firstName, String lastName, String email, String title, boolean haveAccount, int createdBy, Date createdOn, int modifiedBy, Date modifiedOn, int active, EmployeeOutlet employeeOutlet, MstUser mstUser) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.title = title;
		this.haveAccount = haveAccount;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.modifiedBy = modifiedBy;
		this.modifiedOn = modifiedOn;
		this.active = active;
		this.employeeOutlet = employeeOutlet;
		this.mstUser = mstUser;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public int isActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public EmployeeOutlet getEmployeeOutlet() {
		return employeeOutlet;
	}

	public void setEmployeeOutlet(EmployeeOutlet employeeOutlet) {
		this.employeeOutlet = employeeOutlet;
	}

	public MstUser getMstUser() {
		return mstUser;
	}

	public void setMstUser(MstUser mstUser) {
		this.mstUser = mstUser;
	}

	@Override
	public String toString() {
		return "MstEmployee{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", title='" + title + '\'' +
				", haveAccount=" + haveAccount +
				", createdBy=" + createdBy +
				", createdOn=" + createdOn +
				", modifiedBy=" + modifiedBy +
				", modifiedOn=" + modifiedOn +
				", active=" + active +
				", employeeOutlet=" + employeeOutlet +
				", mstUser=" + mstUser +
				'}';
	}
}
