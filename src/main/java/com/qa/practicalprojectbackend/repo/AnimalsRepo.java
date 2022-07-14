package com.qa.practicalprojectbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.practicalprojectbackend.entity.Animals;

@Repository
public interface AnimalsRepo extends JpaRepository<Animals, Integer> {

	Animals findByNameStartingWithIgnoreCase(String name);
}


