package com.example.webdevawesomeprojectserverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
@Entity
public class Customer extends User {


   @ManyToMany
   @JsonIgnore
   @JoinTable(name="FAVORITE_RESTAURANT_TABLE",
           joinColumns=@JoinColumn(name="restaurant_id"),
           inverseJoinColumns=@JoinColumn(name= "user_id"))
   List<Restaurant> favoredRestaurants;

   public List<Restaurant> getFavoredRestaurants() {
      return favoredRestaurants;
   }

   public void setFavoredRestaurants(List<Restaurant> favoredRestaurants) {
      this.favoredRestaurants = favoredRestaurants;
   }

   public Customer(){
      super();
   }
   public Customer(List<Restaurant> favoredRestaurants) {
      super();
      this.favoredRestaurants = favoredRestaurants;
   }
   public Customer(String password, String email, Integer phone, List<User> followers, List<User> following) {
      super(password, email, phone, followers, following);
   }
   public Customer(String password, String email, Integer phone, List<User> followers, List<User> following, List<Restaurant> favoredRestaurants) {
      super(password, email, phone, followers, following);
      this.favoredRestaurants = favoredRestaurants;
   }
   public void addFavoriteRestaurant(Restaurant restaurant){
      this.favoredRestaurants.add(restaurant);
      if(!restaurant.favoringCustomers.contains(this)){
         restaurant.favoringCustomers.add(this);
      }
   }
}
