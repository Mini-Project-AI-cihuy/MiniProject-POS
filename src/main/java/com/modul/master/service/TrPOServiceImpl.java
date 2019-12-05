package com.modul.master.service;

import com.modul.master.model.TrPurchaseOrder;
import com.modul.master.model.TrPurchaseOrderDetail;
import com.modul.master.repository.TrPODao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TrPOServiceImpl implements TrPOService {

    @Autowired
    TrPODao trPODao;

    @Override
    public TrPurchaseOrder getOrder(int id) {
        return trPODao.getOrder(id);
    }

    public List<TrPurchaseOrder> getAllOrder(){
        return trPODao.getAllOrder();
    }

    @Override
    public List<TrPurchaseOrderDetail> getAllOrderDetail() {
        return  trPODao.getAllOrderDetail();
    }

}
