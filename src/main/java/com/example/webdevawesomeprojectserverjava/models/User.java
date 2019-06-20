package com.example.webdevawesomeprojectserverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    public User( String password, String email, Integer phone, List<User> followers, List<User> following) {
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.followers = followers;
        this.following = following;
    }


    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;
    String password;
    String email;
    Integer phone;

    @JsonIgnore
    @ManyToMany(mappedBy = "following")
    List<User> followers;



    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "FOLLOW_TABLE",
            joinColumns = @JoinColumn(name = "follower_id"),
            inverseJoinColumns = @JoinColumn(name="following_id"))
    List<User> following;

    public void addFollower(User user){
        followers.add(user);
        if(!user.following.contains(this)){
            user.following.add(this);
        }
    }
    public void addFollowing(User user){
        following.add(user);
        if(!user.followers.contains(this)){
            user.followers.add(this);
        }
    }
}
