package com.modul.master.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_adjustment_history")
public class TrAdjustmentHistory {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "adjustment_id")
    private Integer adjustmentId;
    @Column(name = "status")
    private String status;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "created_on")
    private Date createOn;

    @ManyToOne(targetEntity = TrAdjustment.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "adjustment_id", referencedColumnName = "id", insertable = false, updatable = false)
    private TrAdjustment trAdjustment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdjustmentId() {
        return adjustmentId;
    }

    public void setAdjustmentId(Integer adjustmentId) {
        this.adjustmentId = adjustmentId;
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

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public TrAdjustment getTrAdjustment() {
        return trAdjustment;
    }

    public void setTrAdjustment(TrAdjustment trAdjustment) {
        this.trAdjustment = trAdjustment;
    }
}
