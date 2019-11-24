package com.modul.master.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="pos_mst_district")
public class MstDistrict {

    @Id
    @Column(name="id")
    private int id;
    @Column(name="region_id")
    private int regionId;
    @Column(name = "name")
    private String name;
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


    @ManyToOne(targetEntity = MstRegion.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MstRegion mstRegion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
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

    public MstRegion getMstRegion() {
        return mstRegion;
    }

    public void setMstRegion(MstRegion mstRegion) {
        this.mstRegion = mstRegion;
    }
}
