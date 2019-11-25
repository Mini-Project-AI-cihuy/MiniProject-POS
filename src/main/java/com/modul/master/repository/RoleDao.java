package com.modul.master.repository;

import com.modul.master.model.Role;

import java.util.List;

public interface RoleDao {

    public Role getRoleById(int id_role);
    public List<Role> getAllRole();
}
