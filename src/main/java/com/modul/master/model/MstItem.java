package com.modul.master.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="pos_mst_item")
public class MstItem {

    @Id
    @Column(name="id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name="CATEGORY_ID")
    private int categoryId;
    @Column(name="created_by", nullable = true)
    private int createdBy;
    @Column(name="created_on", nullable = true)
    private Date createdOn;
    @Column(name="modified_by", nullable = true)
    private int modifiedBy;
    @Column(name="modified_on", nullable = true)
    private Date modifiedOn;
    @Column(name="active")
    private int active;

    @ManyToOne(targetEntity = MstCategory.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "id", insertable = false, updatable = false)
    private MstCategory mstCategory;

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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public MstCategory getMstCategory() {
        return mstCategory;
    }

    public void setMstCategory(MstCategory mstCategory) {
        this.mstCategory = mstCategory;
    }
}
