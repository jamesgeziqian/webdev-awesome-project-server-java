package com.example.webdevawesomeprojectserverjava.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
@Entity
public class Businessperson extends User{
    public Businessperson(String password, String email, Integer phone, List<User> followers, List<User> following, List<Restaurant> ownedRestaurants) {
        super(password, email, phone, followers, following);
        this.ownedRestaurants = ownedRestaurants;
    }

    public Businessperson(String password, String email, Integer phone, List<User> followers, List<User> following) {
        super(password, email, phone, followers, following);
    }

    public Businessperson(List<Restaurant> ownedRestaurants) {
        super();
        this.ownedRestaurants = ownedRestaurants;
    }
    public Businessperson() {
        super();
    }

    public List<Restaurant> getOwnedRestaurants() {
        return ownedRestaurants;
    }

    public void setOwnedRestaurants(List<Restaurant> ownedRestaurants) {
        this.ownedRestaurants = ownedRestaurants;
    }

    public void claimOwn(Restaurant restaurant){
        if(!this.ownedRestaurants.contains(restaurant)){
            ownedRestaurants.add(restaurant);
        }
        if(restaurant.getOwner()!=this){
            restaurant.setOwner(this);
        }
    }
    @OneToMany(mappedBy = "owner")
    List<Restaurant> ownedRestaurants;

}
