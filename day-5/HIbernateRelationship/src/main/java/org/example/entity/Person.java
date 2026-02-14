package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private int age;

    @OneToOne(mappedBy = "person",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Passport passport;

    public Person() {}

    public Person(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // IMPORTANT: maintain both sides
    public void setPassport(Passport passport) {
        this.passport = passport;
        if (passport != null) {
            passport.setPerson(this);
        }
    }

    public Passport getPassport() {
        return passport;
    }

    public Long getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }
}
