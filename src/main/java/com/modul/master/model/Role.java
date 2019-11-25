package com.modul.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

    @Id
    @Column(name="id_role")
    private int id_role;
    @Column(name="role_type")
    private String role_type;

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public String getRole_type() {
        return role_type;
    }

    public void setRole_type(String role_type) {
        this.role_type = role_type;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id_role=" + id_role +
                ", role_type='" + role_type + '\'' +
                '}';
    }
}
