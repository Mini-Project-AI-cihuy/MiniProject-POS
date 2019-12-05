package com.modul.master.service;

import com.modul.master.model.TPurchaseRequest;
import com.modul.master.model.TPurchaseRequestDetail;

import java.util.List;

public interface TPurchaseRequestService {
    //PR
    public List<TPurchaseRequest> getPRByOutletId(int outletId);
    public List<TPurchaseRequest> getPRByStatus(String status, int outletId);
    public TPurchaseRequest getPRById(int id);

    //PR detail
    public List<TPurchaseRequestDetail> getPRDetailByprId(int prId);

}
