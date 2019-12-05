package com.modul.master.service;

import com.modul.master.model.TrPurchaseOrder;
import com.modul.master.model.TrPurchaseOrderDetail;

import java.util.List;

public interface TrPOService {

    public TrPurchaseOrder getOrder(int id);
    public List<TrPurchaseOrder> getAllOrder();
    public List<TrPurchaseOrderDetail> getAllOrderDetail();

}
