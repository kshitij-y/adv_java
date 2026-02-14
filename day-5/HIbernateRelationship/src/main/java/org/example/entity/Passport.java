package org.example.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "passport")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passportId;

    @Column(nullable = false, unique = true)
    private String passportNumber;

    @Column(nullable = false)
    private String country;

    private LocalDate issueDate;
    private LocalDate expiryDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false, unique = true)
    private Person person;

    public Passport() {}

    public Passport(String passportNumber,
                    String country,
                    LocalDate issueDate,
                    LocalDate expiryDate) {
        this.passportNumber = passportNumber;
        this.country = country;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
