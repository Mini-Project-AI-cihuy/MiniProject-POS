package com.modul.master.service;


import com.modul.master.model.MstCategory;
import com.modul.master.model.MstUser;
import com.modul.master.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserEmployeeService {

    @Autowired
    UserDao userDao;


    public void save(MstUser user) {
        userDao.save(user);
    }

    public void update(MstUser user) {
        userDao.updateUser(user);
    }


    public void delete(MstUser user) {
        userDao.delete(user);
    }


    public MstUser getUserId(int id) {
        return userDao.getUserId(id);
    }

    public List<MstUser> getUserList() {
        return userDao.getUser();
    }

}
