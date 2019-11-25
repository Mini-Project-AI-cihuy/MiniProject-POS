package com.modul.master.service;

import com.modul.master.model.Role;
import com.modul.master.repository.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService {
    @Autowired
    RoleDao roleDao;

    public Role getRoleById(int id_role){
        return roleDao.getRoleById(id_role);
    }
    public List<Role> getAllRole(){
        return roleDao.getAllRole();
    }
}
