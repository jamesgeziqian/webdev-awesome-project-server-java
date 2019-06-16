package com.example.webdevawesomeprojectserverjava.repositories;

import com.example.webdevawesomeprojectserverjava.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
