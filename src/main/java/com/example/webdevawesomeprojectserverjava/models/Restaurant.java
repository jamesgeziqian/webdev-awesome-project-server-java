package com.example.webdevawesomeprojectserverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
@Entity
public class Restaurant {
    @Id
    String restaurantId;

    public Restaurant(String restaurantId, Businessperson owner, List<Customer> favoringCustomers) {
        this.restaurantId = restaurantId;
        this.owner = owner;
//        this.favoringCustomers = favoringCustomers;
    }

    @ManyToOne
    @JsonIgnore
    Businessperson owner;

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Businessperson getOwner() {
        return owner;
    }

    public Restaurant() {
    }

    public void setOwner(Businessperson owner) {
        this.owner = owner;
        if(!owner.getOwnedRestaurants().contains(this)){
            owner.getOwnedRestaurants().add(this);
        }
    }

    public List<Customer> getFavoringCustomers() {
        return favoringCustomers;
    }

    public void setFavoringCustomers(List<Customer> favoringCustomers) {
        this.favoringCustomers = favoringCustomers;
    }


    @JsonIgnore
    @ManyToMany(mappedBy = "favoredRestaurants")
    List<Customer> favoringCustomers;

    public void addFavoringCustomer(Customer customer){
        this.favoringCustomers.add(customer);
        if(!customer.getFavoredRestaurants().contains(this)){
            customer.getFavoredRestaurants().add(this);
        }
    }
}
