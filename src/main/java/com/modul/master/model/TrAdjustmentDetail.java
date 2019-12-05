package com.modul.master.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_adjustment_detail")
public class TrAdjustmentDetail {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "adjustment_id")
    private int adjustmentId;
    @Column(name = "variant_id")
    private int variantId;
    @Column(name = "in_stock")
    private int inStock;
    @Column(name = "actual_stock")
    private int actualStock;
    @Column(name = "created_by", nullable = true)
    private Integer createdBy;
    @Column(name = "created_on", nullable = true)
    private Date createdOn;
    @Column(name = "modified_by", nullable = true)
    private Integer modifiedBy;
    @Column(name = "modified_on", nullable = true)
    private Date modifiedOn;

    @ManyToOne(targetEntity = TrAdjustment.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "adjustment_id", referencedColumnName = "id", insertable = false, updatable = false)
    private TrAdjustment adjustment;

    @OneToOne(targetEntity = MstItemVariant.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "variant_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MstItemVariant itemVariant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdjustmentId() {
        return adjustmentId;
    }

    public void setAdjustmentId(int adjustmentId) {
        this.adjustmentId = adjustmentId;
    }

    public int getVariantId() {
        return variantId;
    }

    public void setVariantId(int variantId) {
        this.variantId = variantId;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public int getActualStock() {
        return actualStock;
    }

    public void setActualStock(int actualStock) {
        this.actualStock = actualStock;
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

    public TrAdjustment getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(TrAdjustment adjustment) {
        this.adjustment = adjustment;
    }

    public MstItemVariant getItemVariant() {
        return itemVariant;
    }

    public void setItemVariant(MstItemVariant itemVariant) {
        this.itemVariant = itemVariant;
    }
}
