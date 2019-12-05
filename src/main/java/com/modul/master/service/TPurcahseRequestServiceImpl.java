package com.modul.master.service;

import com.modul.master.model.TPurchaseRequest;
import com.modul.master.model.TPurchaseRequestDetail;
import com.modul.master.repository.TPurchaseRequestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TPurcahseRequestServiceImpl implements TPurchaseRequestService {

    @Autowired
    TPurchaseRequestDao tPurchaseRequestDao;

    @Override
    public List<TPurchaseRequest> getPRByOutletId(int outletId) {
        return tPurchaseRequestDao.getPRByOutletId(outletId);
    }

    @Override
    public List<TPurchaseRequest> getPRByStatus(String status, int outletId) {
        return tPurchaseRequestDao.getPRByStatus(status, outletId);
    }

    @Override
    public TPurchaseRequest getPRById(int id) {
        return tPurchaseRequestDao.getPRById(id);
    }

    @Override
    public List<TPurchaseRequestDetail> getPRDetailByprId(int prId) {
        return tPurchaseRequestDao.getPRDetailByprId(prId);
    }
}
