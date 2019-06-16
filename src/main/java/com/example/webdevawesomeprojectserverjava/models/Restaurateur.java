package com.example.webdevawesomeprojectserverjava.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class Restaurateur extends User {

  @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
  private List<Restaurant> ownedRestaurants;

  public Restaurateur() {
    this.ownedRestaurants = null;
  }

  public Restaurateur(String username, String password, List<Restaurant> ownedRestaurants) {
    super(username, password);
    this.ownedRestaurants = ownedRestaurants;
  }

  public List<Restaurant> getOwnedRestaurants() {
    return ownedRestaurants;
  }

  public void setOwnedRestaurants(
      List<Restaurant> ownedRestaurants) {
    this.ownedRestaurants = ownedRestaurants;
  }
}
