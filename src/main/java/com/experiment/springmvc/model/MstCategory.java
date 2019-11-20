package com.experiment.springmvc.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="pos_mst_category")
public class MstCategory {

    @Id
    @Column(name="id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name="created_by")
    private int createdBy;
    @Column(name="created_on")
    private Date createdOn;
    @Column(name="modified_by")
    private int modifiedBy;
    @Column(name="modified_on")
    private Date modifiedOn;
    @Column(name="active")
    private boolean active;

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

    @Override
    public String toString() {
        return "MstCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdBy=" + createdBy +
                ", createdOn=" + createdOn +
                ", modifiedBy=" + modifiedBy +
                ", modifiedOn=" + modifiedOn +
                ", active=" + active +
                '}';
    }
}
