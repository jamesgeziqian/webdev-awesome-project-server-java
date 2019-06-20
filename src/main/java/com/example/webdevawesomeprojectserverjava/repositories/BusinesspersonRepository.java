package com.example.webdevawesomeprojectserverjava.repositories;

import com.example.webdevawesomeprojectserverjava.models.Businessperson;
import org.springframework.data.repository.CrudRepository;

public interface BusinesspersonRepository extends CrudRepository<Businessperson, Integer> {
}
