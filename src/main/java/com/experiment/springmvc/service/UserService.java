package com.experiment.springmvc.service;

import com.experiment.springmvc.model.User;
import com.experiment.springmvc.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    UserDao userDao;

    public void save(User user){
        userDao.save(user);
    }
    public void update(User user){
        userDao.update(user);
    }
    public void delete(User user){
        userDao.delete(user);
    }
    public User getUser(int id){
        return userDao.getUser(id);
    }
    public List<User> getUsers(){
        return userDao.getUsers();
    }
}
