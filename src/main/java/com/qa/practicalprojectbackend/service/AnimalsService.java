package com.qa.practicalprojectbackend.service;

import java.util.List;

import com.qa.practicalprojectbackend.entity.Animals;

public interface AnimalsService {

	Animals getById(int id);

	List<Animals> getAll();

	List<Animals> findByName(String name);

	Animals create(Animals animal);

	Animals update(int id, String name, String animalGroup, Integer population, String diet, Integer lifespan);

	void delete(int id);
}
