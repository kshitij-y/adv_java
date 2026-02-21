package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id", nullable = false)
    private Department department;

    public Employee(){}

    public Employee(String name){
        this.name = name;
    }

    public void setDepartment(Department department){
        this.department = department;
    }

    public Department getDepartment(){return this.department; }

    public String getName(){return this.name; }
}
