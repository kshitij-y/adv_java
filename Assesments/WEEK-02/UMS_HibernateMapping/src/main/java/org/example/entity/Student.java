package org.example.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idcard_id", unique = true)
    private IDCard idcard;

    @ManyToMany
    @JoinTable(name = "student_course")
    private List<Course> courses = new ArrayList<>();


    public Student(){}

    public Student(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public IDCard getIdcard() {
        return idcard;
    }

    public void setIdcard(IDCard idcard) {
        this.idcard = idcard;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
