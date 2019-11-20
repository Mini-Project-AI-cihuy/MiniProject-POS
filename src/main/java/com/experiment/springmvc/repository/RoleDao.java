package com.experiment.springmvc.repository;

import com.experiment.springmvc.model.Role;

import java.util.List;

public interface RoleDao {

    public Role getRoleById(int id_role);
    public List<Role> getAllRole();
}
