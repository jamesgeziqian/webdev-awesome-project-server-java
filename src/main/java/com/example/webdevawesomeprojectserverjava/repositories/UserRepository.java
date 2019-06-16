package com.example.webdevawesomeprojectserverjava.repositories;

import com.example.webdevawesomeprojectserverjava.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
