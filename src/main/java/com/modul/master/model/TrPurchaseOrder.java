package com.modul.master.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="pos_t_po")
public class TrPurchaseOrder {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "pr_id")
    private int prId;
    @Column(name = "outlet_id")
    private int outletId;
    @Column(name = "supplier_id")
    private int supplierId;
    @Column(name = "po_no")
    private String poNo;
    @Column(name = "notes", nullable = true)
    private String notes;
    @Column(name = "grand_total")
    private double grandTotal;
    @Column(name = "status")
    private String status;
    @Column(name = "created_by", nullable = true)
    private int createdBy;
    @Column(name = "created_on", nullable = true)
    private Date createdOn;
    @Column(name = "modified_by", nullable = true)
    private int modifiedBy;
    @Column(name = "modified_on", nullable = true)
    private Date modifiedOn;

    @OneToOne(targetEntity = TrPurchaseRequest.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "pr_id", referencedColumnName = "id", insertable = false, updatable = false)
    private TrPurchaseRequest trPurchaseRequest;

    @ManyToOne(targetEntity = MstOutlet.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "outlet_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MstOutlet mstOutlet;

    @ManyToOne(targetEntity = MstSupplier.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MstSupplier mstSupplier;

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

    public int getOutletId() {
        return outletId;
    }

    public void setOutletId(int outletId) {
        this.outletId = outletId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
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

    public TrPurchaseRequest getTrPurchaseRequest() {
        return trPurchaseRequest;
    }

    public void setTrPurchaseRequest(TrPurchaseRequest trPurchaseRequest) {
        this.trPurchaseRequest = trPurchaseRequest;
    }

    public MstOutlet getMstOutlet() {
        return mstOutlet;
    }

    public void setMstOutlet(MstOutlet mstOutlet) {
        this.mstOutlet = mstOutlet;
    }

    public MstSupplier getMstSupplier() {
        return mstSupplier;
    }

    public void setMstSupplier(MstSupplier mstSupplier) {
        this.mstSupplier = mstSupplier;
    }
}
