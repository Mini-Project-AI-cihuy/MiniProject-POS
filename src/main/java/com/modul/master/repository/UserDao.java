package com.modul.master.repository;

import com.modul.master.model.MstUser;

import java.util.List;

public interface UserDao {
    public void save(MstUser user);
    public void delete(MstUser user);
    public MstUser getUserId(int id);
    public List<MstUser> getUser();
    public void updateUser(MstUser user);
}
