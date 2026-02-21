package org.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private int id;

    private String name;

    /*@OneToMany(
            mappedBy = "department",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )*/
    //private List<Employee> employees = new ArrayList<>();

    public Department(){}

    public Department(String name){
        this.name = name;
    }

    /*public List<Employee> getEmployees(){
        return employees;
    }*/
    public String getName(){return this.name;}


}
