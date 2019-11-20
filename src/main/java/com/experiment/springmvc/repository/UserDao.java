package com.experiment.springmvc.repository;

import com.experiment.springmvc.model.User;

import java.util.List;


public interface UserDao {

    public void save(User user);
    public void update(User user);
    public void delete(User user);
    public User getUser(int id);
    public List<User> getUsers();

}
