package com.modul.master.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pos_mst_role")
public class MstRole {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name", nullable = true)
	private String name;
	@Column(name = "description", nullable = true)
	private String description;
	@Column(name = "created_by")
	private int createdBy;
	@Column(name = "created_on", nullable = true)
	private Date createdOn;
	@Column(name = "modified_by")
	private int modifiedBy;
	@Column(name = "modified_on", nullable = true)
	private Date modifiedOn;
	@Column(name = "active")
	private boolean active;

//	@OneToMany(mappedBy = "MstRole")
//	private List<MstUser> user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

//	public List<MstUser> getUser() {
//		return user;
//	}
//
//	public void setUser(List<MstUser> user) {
//		this.user = user;
//	}
}
