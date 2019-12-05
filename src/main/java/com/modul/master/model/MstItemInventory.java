package com.modul.master.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_item_inventory")
public class MstItemInventory {

    public MstItemInventory() {
    }

    public MstItemInventory(int variantId, int outletId, int beginning, int alertAtQty) {
        this.variantId = variantId;
        this.outletId = outletId;
        this.beginning = beginning;
        this.alertAtQty = alertAtQty;
    }

    @GeneratedValue
    @Id
    @Column(name = "id",nullable = false)
    private int id;
    @Column(name = "variant_id")
    private int variantId;
    @Column(name = "outlet_id")
    private int outletId;
    @Column(name = "beginning",nullable = false)
    private int beginning;
    @Column(name = "purchase_qty", nullable = true)
    private int purchaseQty;
    @Column(name = "sales_order_qty", nullable = true)
    private int salesOrderQty;
    @Column(name = "transfer_stock_qty", nullable = true)
    private int transferStockQty;
    @Column(name = "adjustment_qty", nullable = true)
    private int adjustmentQty;
    @Column(name = "ending_qty",nullable = false)
    private int endingQty;
    @Column(name = "alert_at_qty",nullable = false)
    private int alertAtQty;
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

    @ManyToOne(targetEntity = MstOutlet.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "outlet_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MstOutlet mstOutlet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVariantId() {
        return variantId;
    }

    public void setVariantId(int variantId) {
        this.variantId = variantId;
    }

    public int getOutletId() {
        return outletId;
    }

    public void setOutletId(int outletId) {
        this.outletId = outletId;
    }

    public int getBeginning() {
        return beginning;
    }

    public void setBeginning(int beginning) {
        this.beginning = beginning;
    }

    public int getPurchaseQty() {
        return purchaseQty;
    }

    public void setPurchaseQty(int purchaseQty) {
        this.purchaseQty = purchaseQty;
    }

    public int getSalesOrderQty() {
        return salesOrderQty;
    }

    public void setSalesOrderQty(int salesOrderQty) {
        this.salesOrderQty = salesOrderQty;
    }

    public int getTransferStockQty() {
        return transferStockQty;
    }

    public void setTransferStockQty(int transferStockQty) {
        this.transferStockQty = transferStockQty;
    }

    public int getAdjustmentQty() {
        return adjustmentQty;
    }

    public void setAdjustmentQty(int adjustmentQty) {
        this.adjustmentQty = adjustmentQty;
    }

    public int getEndingQty() {
        return endingQty;
    }

    public void setEndingQty(int endingQty) {
        this.endingQty = endingQty;
    }

    public int getAlertAtQty() {
        return alertAtQty;
    }

    public void setAlertAtQty(int alertAtQty) {
        this.alertAtQty = alertAtQty;
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

    public MstOutlet getMstOutlet() {
        return mstOutlet;
    }

    public void setMstOutlet(MstOutlet mstOutlet) {
        this.mstOutlet = mstOutlet;
    }
}
