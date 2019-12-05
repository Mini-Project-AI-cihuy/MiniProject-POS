package com.modul.master.model;


import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "pos_t_adjustment")
public class TrAdjustment {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "outlet_id")
    private int outletId;
    @Column(name = "notes", nullable = true)
    private String notes;
    @Column(name = "status")
    private String status;
    @Column(name = "created_by", nullable = true)
    private Integer createdBy;
    @Column(name = "created_on", nullable = true)
    private Date createdOn;
    @Column(name = "modified_by", nullable = true)
    private Integer modifiedBy;
    @Column(name = "modified_on", nullable = true)
    private  Date modifiedOn;

    @ManyToOne(targetEntity = MstOutlet.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "outlet_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MstOutlet mstOutlet;

//    @OneToMany(mappedBy = "adjustment", fetch = FetchType.EAGER)
//    private Set<TrAdjustmentDetail> adjustmentDetails;
//
//    @OneToMany(mappedBy = "trAdjustment", fetch = FetchType.EAGER)
//    private List<TrAdjustmentHistory> adjustmentHistories;


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

    public MstOutlet getMstOutlet() {
        return mstOutlet;
    }

    public void setMstOutlet(MstOutlet mstOutlet) {
        this.mstOutlet = mstOutlet;
    }

//    public Set<TrAdjustmentDetail> getAdjustmentDetails() {
//        return adjustmentDetails;
//    }
//
//    public void setAdjustmentDetails(Set<TrAdjustmentDetail> adjustmentDetails) {
//        this.adjustmentDetails = adjustmentDetails;
//    }
//
//    public List<TrAdjustmentHistory> getAdjustmentHistories() {
//        return adjustmentHistories;
//    }
//
//    public void setAdjustmentHistories(List<TrAdjustmentHistory> adjustmentHistories) {
//        this.adjustmentHistories = adjustmentHistories;
//    }
//    public Set<TrAdjustmentHistory> getAdjustmentHistories() {
//        return adjustmentHistories;
//    }
//
//    public void setAdjustmentHistories(Set<TrAdjustmentHistory> adjustmentHistories) {
//        this.adjustmentHistories = adjustmentHistories;
//    }
}
