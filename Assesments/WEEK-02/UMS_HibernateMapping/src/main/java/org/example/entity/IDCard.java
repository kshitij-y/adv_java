package org.example.entity;

import javax.persistence.*;

@Entity
public class IDCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cardNumber;

    @OneToOne(mappedBy = "idcard")
    private Student student;

    public IDCard(){}

    public IDCard(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
