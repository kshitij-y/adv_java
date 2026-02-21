package org.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "customers",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<Orders> orders = new ArrayList<>();

    public Customers(){}
    public Customers(String name, String email){
        this.name = name;
        this.email = email;
    }

    public void addOrder(Orders order){
        orders.add(order);
        order.setCustomers(this);
    }

    public String getName(){return this.name;}
    public List<Orders> getOrders(){return this.orders; }
    public String getEmail(){return this.email; }


}
