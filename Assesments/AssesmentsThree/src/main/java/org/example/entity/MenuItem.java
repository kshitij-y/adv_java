package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private Double price;
    private String category;
    private Boolean available;

    public MenuItem(){}
    public MenuItem(String name, Double price, String category, Boolean available) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.available = available;
    }

    // get set for all var
    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public boolean getAvailable() { return available; }

    public void setPrice(double price) { this.price = price; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + price + " | " + category + " | " + available;
    }


}
