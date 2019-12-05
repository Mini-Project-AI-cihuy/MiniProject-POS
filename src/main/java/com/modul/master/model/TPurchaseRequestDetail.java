package com.modul.master.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_pr_detail")
public class TPurchaseRequestDetail {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "pr_id")
    private int prId;
    @Column(name = "variant_id")
    private int variant_id;
    @Column(name = "request_qty")
    private int requestQty;
    @Column(name = "created_by", nullable = true)
    private int createdBy;
    @Column(name = "created_on", nullable = true)
    private Date createdOn;
    @Column(name = "modified_by", nullable = true)
    private int modifiedBy;
    @Column(name = "modified_on", nullable = true)
    private Date modifiedOn;

    @OneToOne(targetEntity = TPurchaseRequest.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "pr_id", referencedColumnName = "id", insertable = false, updatable = false)
    private TPurchaseRequest tPurchaseRequest;

    @ManyToOne(targetEntity = MstItemVariant.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "variant_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MstItemVariant mstItemVariant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrId() {
        return prId;
    }

    public void setPrId(int prId) {
        this.prId = prId;
    }

    public int getVariant_id() {
        return variant_id;
    }

    public void setVariant_id(int variant_id) {
        this.variant_id = variant_id;
    }

    public int getRequestQty() {
        return requestQty;
    }

    public void setRequestQty(int requestQty) {
        this.requestQty = requestQty;
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

    public TPurchaseRequest gettPurchaseRequest() {
        return tPurchaseRequest;
    }

    public void settPurchaseRequest(TPurchaseRequest tPurchaseRequest) {
        this.tPurchaseRequest = tPurchaseRequest;
    }

    public MstItemVariant getMstItemVariant() {
        return mstItemVariant;
    }

    public void setMstItemVariant(MstItemVariant mstItemVariant) {
        this.mstItemVariant = mstItemVariant;
    }
}
