package com.modul.master.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="pos_mst_item_variant")
public class MstItemVariant {

    @Id
    @Column(name="id")
    private int id;
    @Column(name = "item_id")
    private String itemId;
    @Column(name="name")
    private String name;
    @Column(name="sku", nullable = true)
    private String sku;
    @Column(name="price", nullable = true)
    private int price;
    @Column(name="created_on", nullable = true)
    private Date createdOn;
    @Column(name="modified_by", nullable = true)
    private int modifiedBy;
    @Column(name="modified_on", nullable = true)
    private Date modifiedOn;
    @Column(name="active")
    private int active;

    @ManyToOne(targetEntity = MstItem.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MstItem mstItem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public MstItem getMstItem() {
        return mstItem;
    }

    public void setMstItem(MstItem mstItem) {
        this.mstItem = mstItem;
    }
}
