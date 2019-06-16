package com.example.webdevawesomeprojectserverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Customer extends User {

  @ManyToMany(mappedBy = "regularCustomers")
  @JoinTable(name = "FAVORITES",
      joinColumns = @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID"),
      inverseJoinColumns = @JoinColumn(name = "RESTAURANT_ID", referencedColumnName = "ID"))
  @JsonIgnore
  private List<Restaurant> favoredRestaurants;

  public Customer() {
    super();
  }

  public Customer(String username, String password, List<Restaurant> favoredRestaurants) {
    super(username, password);
    this.favoredRestaurants = favoredRestaurants;
  }

  public List<Restaurant> getFavoredRestaurants() {
    return favoredRestaurants;
  }

  public void setFavoredRestaurants(
      List<Restaurant> favoredRestaurants) {
    this.favoredRestaurants = favoredRestaurants;
  }
}
