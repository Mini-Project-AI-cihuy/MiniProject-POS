package com.modul.master.repository;

import com.modul.master.model.MstRole;

import java.util.List;

public interface RoleDao  {
    public void save(MstRole role);
    public void update(MstRole role);
    public void delete(MstRole role);
    public MstRole getRole(int id);
    public List<MstRole> getRoles();
}
