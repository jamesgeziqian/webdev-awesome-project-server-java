package com.example.webdevawesomeprojectserverjava.repositories;

import com.example.webdevawesomeprojectserverjava.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
