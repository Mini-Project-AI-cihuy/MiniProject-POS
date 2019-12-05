package com.modul.master.service;

import com.modul.master.model.TPurchaseRequest;
import com.modul.master.model.TPurchaseRequestDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TPurcahseRequestServiceImpl implements TPurchaseRequestService {
    @Override
    public void saveOrupdatePR(TPurchaseRequest tPurchaseRequest) {

    }

    @Override
    public TPurchaseRequest getPRById(int id) {
        return null;
    }

    @Override
    public List<TPurchaseRequest> getAllPR() {
        return null;
    }

    @Override
    public void saveOrupdatePRDetail(TPurchaseRequestDetail tPurchaseRequestDetail) {

    }

    @Override
    public TPurchaseRequestDetail getPRDetailById(int id) {
        return null;
    }

    @Override
    public List<TPurchaseRequestDetail> getAllPRDetail() {
        return null;
    }
}
