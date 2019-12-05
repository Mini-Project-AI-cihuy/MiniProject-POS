package com.modul.master.repository;

import com.modul.master.model.TrPurchaseOrder;
import com.modul.master.model.TrPurchaseOrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrPODao {

    public TrPurchaseOrder getOrder(int id);
    public List<TrPurchaseOrder> getAllOrder();
    public List<TrPurchaseOrderDetail> getAllOrderDetail();

}
