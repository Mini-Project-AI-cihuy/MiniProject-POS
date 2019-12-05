package com.modul.master.service;

import com.modul.master.model.TPurchaseRequest;
import com.modul.master.model.TPurchaseRequestDetail;

import java.util.List;

public interface TPurchaseRequestService {
    //PR
    public void saveOrupdatePR(TPurchaseRequest tPurchaseRequest);
    public TPurchaseRequest getPRById(int id);
    public List<TPurchaseRequest> getAllPR();

    //PR Detail
    public void saveOrupdatePRDetail(TPurchaseRequestDetail tPurchaseRequestDetail);
    public TPurchaseRequestDetail getPRDetailById(int id);
    public List<TPurchaseRequestDetail> getAllPRDetail();
}
