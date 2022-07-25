package com.qa.practicalprojectbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.practicalprojectbackend.entity.Animals;
import com.qa.practicalprojectbackend.repo.AnimalsRepo;

@Service
@Primary
public class AnimalsServiceDB implements AnimalsService {

	@Autowired
	private AnimalsRepo repo;

	@Override
	public Animals getById(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public List<Animals> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Animals create(Animals animal) {
		return this.repo.save(animal);
	}

	@Override
	public Animals update(int id, String name, String animalGroup, Integer population, String diet, Integer lifespan) {
		Animals toUpdate = this.getById(id);
		if (name != null)
			toUpdate.setName(name);
		if (animalGroup != null)
			toUpdate.setGroup(animalGroup);
		if (population != null)
			toUpdate.setPopulation(population);
		if (diet != null)
			toUpdate.setDiet(diet);
		if (lifespan != null)
			toUpdate.setLifespan(lifespan);
		return this.repo.save(toUpdate);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
	}

	@Override
	public List<Animals> findByName(String name) {
		// TODO Auto-generated method stub
		return this.repo.findByNameStartingWithIgnoreCase(name);
	}
	
}
