package org.example.entity;


import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customers;

    public Orders(){}
    public Orders(String name, Double amount){
        this.productName = name;
        this.amount = amount;
    }
    public void setCustomers(Customers customers){
        this.customers = customers;
    }

    public String getProductName(){return this.productName; }
    public Double getAmount(){return this.amount; }
}
