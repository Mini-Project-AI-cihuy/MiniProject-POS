package com.modul.master.repository;

import com.modul.master.model.TPurchaseRequest;
import com.modul.master.model.TPurchaseRequestDetail;

import java.util.List;

public interface TPurchaseRequestDao {
    //PR
    public List<TPurchaseRequest> getPRByOutletId(int outletId);
    public List<TPurchaseRequest> getPRByStatus(String status,int outletId);
    public TPurchaseRequest getPRById(int id);

    //pr detail
    public List<TPurchaseRequestDetail> getPRDetailByprId(int prId);

}
