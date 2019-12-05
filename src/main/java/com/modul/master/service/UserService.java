package com.modul.master.service;

import com.modul.master.model.MstUser;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public MstUser getUserByEmail(String email);
    public void updateUser(MstUser user);
    public void saveUser(MstUser user);
    public void getUser(int id);
    public void deleteUser(MstUser user);
}
