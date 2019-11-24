package com.modul.master.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_mst_supplier")
public class MstSupplier {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "province_id")
    private int provinceId;
    @Column(name = "region_id")
    private int regionId;
    @Column(name = "district_id")
    private int districtId;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "created_by", nullable = true)
    private int createdBy;
    @Column(name = "created_on", nullable = true)
    private Date createdOn;
    @Column(name = "modified_by", nullable = true)
    private int modifiedBy;
    @Column(name = "modified_on", nullable = true)
    private Date modifiedOn;
    @Column(name = "active")
    private int active;

        @ManyToOne(targetEntity = MstDistrict.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "district_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MstDistrict mstDistrict;

    @ManyToOne(targetEntity = MstRegion.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MstRegion mstRegion;

    @ManyToOne(targetEntity = MstProvince.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "province_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MstProvince mstProvinces;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public MstDistrict getMstDistrict() {
        return mstDistrict;
    }

    public void setMstDistrict(MstDistrict mstDistrict) {
        this.mstDistrict = mstDistrict;
    }

    public MstRegion getMstRegion() {
        return mstRegion;
    }

    public void setMstRegion(MstRegion mstRegion) {
        this.mstRegion = mstRegion;
    }

    public MstProvince getMstProvinces() {
        return mstProvinces;
    }

    public void setMstProvinces(MstProvince mstProvinces) {
        this.mstProvinces = mstProvinces;
    }
}
