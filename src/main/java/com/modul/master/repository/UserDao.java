package com.modul.master.repository;

import com.modul.master.model.MstUser;

import java.util.List;

public interface UserDao {
    public List<MstUser> getUser();
    public void updateUser(MstUser user);
}
