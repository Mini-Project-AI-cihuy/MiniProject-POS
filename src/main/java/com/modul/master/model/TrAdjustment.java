package com.modul.master.model;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "pos_t_adjustment")
public class TrAdjustment {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "outlet_id")
    private int outletId;
    @Column(name = "notes")
    private String notes;
    @Column(name = "status")
    private String status;
    @Column(name = "created_by")
    private int createdBy;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "modified_by")
    private int modifiedBy;
    @Column(name = "modified_on")
    private  Date modifiedOn;

    @ManyToOne(targetEntity = MstOutlet.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "outlet_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MstOutlet mstOutlet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOutletId() {
        return outletId;
    }

    public void setOutletId(int outletId) {
        this.outletId = outletId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public MstOutlet getMstOutlet() {
        return mstOutlet;
    }

    public void setMstOutlet(MstOutlet mstOutlet) {
        this.mstOutlet = mstOutlet;
    }
}
