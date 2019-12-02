package com.modul.master.model;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@Entity
@Table(name = "pos_employee_outlet")
public class EmployeeOutlet {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "outlet_id")
    private int outletId;

    @ManyToOne(targetEntity = MstOutlet.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "outlet_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MstOutlet mstOutlet;


    @OneToOne(cascade = CascadeType.ALL, targetEntity = MstEmployee.class)
    @JoinColumn(name = "employee_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MstEmployee mstEmployee;



    public EmployeeOutlet() {
    }

    public EmployeeOutlet(int employeeId, int outletId, MstOutlet mstOutlet, MstEmployee mstEmployee) {
        this.employeeId = employeeId;
        this.outletId = outletId;
        this.mstOutlet = mstOutlet;
        this.mstEmployee = mstEmployee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getOutletId() {
        return outletId;
    }

    public void setOutletId(int outletId) {
        this.outletId = outletId;
    }

    public MstOutlet getMstOutlet() {
        return mstOutlet;
    }

    public void setMstOutlet(MstOutlet mstOutlet) {
        this.mstOutlet = mstOutlet;
    }

    public MstEmployee getMstEmployee() {
        return mstEmployee;
    }

    public void setMstEmployee(MstEmployee mstEmployee) {
        this.mstEmployee = mstEmployee;
    }

    @Override
    public String toString() {
        return "EmployeeOutlet{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", outletId=" + outletId +
                ", mstOutlet=" + mstOutlet +
                ", mstEmployee=" + mstEmployee +
                '}';
    }
}