package com.modul.master.service;

import com.modul.master.model.MstUser;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public MstUser getUserByEmail(String email);
    public void updateUser(MstUser user);
}
