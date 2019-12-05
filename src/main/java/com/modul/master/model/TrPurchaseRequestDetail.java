package com.modul.master.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="pos_t_pr_detail")
public class TrPurchaseRequestDetail {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "pr_id")
    private int prId;
    @Column(name = "variant_id")
    private int variantId;
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

    @ManyToOne(targetEntity = MstItemVariant.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "variant_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MstItemVariant mstItemVariant;

    @OneToOne(targetEntity = TrPurchaseRequest.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "pr_id", referencedColumnName = "id", insertable = false, updatable = false)
    private TrPurchaseRequest trPurchaseRequest;

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

    public int getVariantId() {
        return variantId;
    }

    public void setVariantId(int variantId) {
        this.variantId = variantId;
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

    public MstItemVariant getMstItemVariant() {
        return mstItemVariant;
    }

    public void setMstItemVariant(MstItemVariant mstItemVariant) {
        this.mstItemVariant = mstItemVariant;
    }

    public TrPurchaseRequest getTrPurchaseRequest() {
        return trPurchaseRequest;
    }

    public void setTrPurchaseRequest(TrPurchaseRequest trPurchaseRequest) {
        this.trPurchaseRequest = trPurchaseRequest;
    }
}
