package com.example.webdevawesomeprojectserverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Restaurant {

  @Id
  private String yelpId;

  @ManyToOne
  @JsonIgnore
  private Restaurateur owner;

  @ManyToMany(mappedBy = "favoredRestaurants")
  @JsonIgnore
  private List<Customer> regularCustomers;

  private String address;
  private String phone;
  private String category;
  private String transactions;
  private String hours;

  public Restaurant() {}

  public Restaurant(String yelpId,
      Restaurateur owner,
      List<Customer> regularCustomers, String address, String phone, String category,
      String transactions, String hours) {
    this.yelpId = yelpId;
    this.owner = owner;
    this.regularCustomers = regularCustomers;
    this.address = address;
    this.phone = phone;
    this.category = category;
    this.transactions = transactions;
    this.hours = hours;
  }

  public String getYelpId() {
    return yelpId;
  }

  public void setYelpId(String yelpId) {
    this.yelpId = yelpId;
  }

  public Restaurateur getOwner() {
    return owner;
  }

  public void setOwner(Restaurateur owner) {
    this.owner = owner;
  }

  public List<Customer> getRegularCustomers() {
    return regularCustomers;
  }

  public void setRegularCustomers(
      List<Customer> regularCustomers) {
    this.regularCustomers = regularCustomers;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getTransactions() {
    return transactions;
  }

  public void setTransactions(String transactions) {
    this.transactions = transactions;
  }

  public String getHours() {
    return hours;
  }

  public void setHours(String hours) {
    this.hours = hours;
  }
}
