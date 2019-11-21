package com.modul.master.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="pos_mst_region")
public class MstRegion {

    @Id
    @Column(name="id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name="province_id")
    private int provinceId;
    @Column(name="created_by")
    private int createdBy;
    @Column(name="created_on")
    private Date createdOn;
    @Column(name="modified_by")
    private int modifiedBy;
    @Column(name="modified_on")
    private Date modifiedOn;
    @Column(name="active")
    private int active;


    @ManyToOne(targetEntity = MstProvince.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MstProvince mstProvinces;

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }


    public MstProvince getMstProvinces() {
        return mstProvinces;
    }

    public void setMstProvinces(MstProvince mstProvinces) {
        this.mstProvinces = mstProvinces;
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
}
