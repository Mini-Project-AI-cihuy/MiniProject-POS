package com.modul.master.service;

import com.modul.master.model.MstUser;
import com.modul.master.repository.UserDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public MstUser getUserByEmail(String email) {
       List<MstUser> listUser = userDao.getUser();
       for (MstUser curUser: listUser) {
            if (curUser.getMstEmployee().getEmail().equalsIgnoreCase(email)){
                return curUser;
            }
        }
        return null;
    }

    @Transactional(readOnly = false)
    @Override
    public void updateUser(MstUser user) {
        userDao.updateUser(user);
    }


}
