package com.example.webdevawesomeprojectserverjava.repositories;

import com.example.webdevawesomeprojectserverjava.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

}
