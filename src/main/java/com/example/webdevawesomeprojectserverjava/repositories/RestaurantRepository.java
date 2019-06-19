package com.example.webdevawesomeprojectserverjava.repositories;

import com.example.webdevawesomeprojectserverjava.models.Restaurant;
import org.springframework.data.repository.*;

public interface RestaurantRepository extends CrudRepository<Restaurant, String> {
}
