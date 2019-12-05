package com.modul.master.model;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Table(name="pos_mst_item")
public class MstItem {

    @GeneratedValue
    @Id
    @Column(name="id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name="CATEGORY_ID")
    private int categoryId;
    @Column(name="created_by", nullable = true)
    private Integer createdBy;
    @Column(name="created_on", nullable = true)
    private Date createdOn;
    @Column(name="modified_by", nullable = true)
    private Integer modifiedBy;
    @Column(name="modified_on", nullable = true)
    private Date modifiedOn;
    @Column(name="active")
    private int active;

    @ManyToOne(targetEntity = MstCategory.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "id", insertable = false, updatable = false)
    private MstCategory mstCategory;

    public MstItem() {
    }

    public MstItem(String name, int categoryId) {
        this.name = name;
        this.categoryId = categoryId;
        this.active=0;
    }

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

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
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
