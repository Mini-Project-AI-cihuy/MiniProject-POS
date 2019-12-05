package com.modul.master.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="pos_t_purchase_detail")
public class TrPurchaseOrderDetail {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "po_id", nullable = true)
    private int poId;
    @Column(name = "variant_id")
    private int variantId;
    @Column(name = "request_qty")
    private int requestQty;
    @Column(name = "unit_cost", nullable = true)
    private double unitCost;
    @Column(name = "sub_total", nullable = true)
    private double subTotal;
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

    @OneToOne(targetEntity = TrPurchaseOrder.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "po_id", referencedColumnName = "id", insertable = false, updatable = false)
    private TrPurchaseOrder trPurchaseOrder;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoId() {
        return poId;
    }

    public void setPoId(int poId) {
        this.poId = poId;
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

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
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

    public TrPurchaseOrder getTrPurchaseOrder() {
        return trPurchaseOrder;
    }

    public void setTrPurchaseOrder(TrPurchaseOrder trPurchaseOrder) {
        this.trPurchaseOrder = trPurchaseOrder;
    }
}
