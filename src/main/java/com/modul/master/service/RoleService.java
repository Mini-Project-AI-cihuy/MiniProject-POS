package com.modul.master.service;

import com.modul.master.model.MstRole;
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

    public void save(MstRole role) {
        roleDao.save(role);
    }

    public void update(MstRole role) {
        roleDao.update(role);
    }


    public void delete(MstRole role) {
        roleDao.delete(role);
    }


    public MstRole getRoleId(int id) {
        return roleDao.getRole(id);
    }


    public List<MstRole> getAllRole() {
        return roleDao.getRoles();
    }
}
