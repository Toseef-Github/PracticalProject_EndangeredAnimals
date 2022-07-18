package com.qa.practicalprojectbackend.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.practicalprojectbackend.entity.Animals;
import com.qa.practicalprojectbackend.service.AnimalsService;

@CrossOrigin
@RestController
public class AnimalsController {
	
	@Autowired
	private AnimalsService service; // dependency


	@GetMapping("/getAnimal/{id}")
	public Animals getById(@PathVariable int id) {
		return this.service.getById(id);
	}

	@GetMapping("/getAnimals")
	public List<Animals> getAll() {
		return this.service.getAll();
	}

	@GetMapping("/getAnimalByName/{name}")
	public Animals getAnimalByName(@PathVariable String name) {
		return this.service.findByName(name);
	}

	@PostMapping("/createAnimal")
	public ResponseEntity<Animals> create(@RequestBody Animals animal) {
		System.out.println("Created: " + animal);
		Animals created = this.service.create(animal);

		return new ResponseEntity<Animals>(created, HttpStatus.CREATED);
	}

	@PatchMapping("/updateAnimal/{id}")
	public Animals update(@PathVariable("id") int id, @PathParam("name") String name,
			@PathParam("animalGroup") String animalGroup, @PathParam("population") Integer population, @PathParam("diet") String diet, @PathParam("lifespan") Integer lifespan) {
		return this.service.update(id, name, animalGroup, population, diet, lifespan);
	}

	// id = 4494
	@DeleteMapping("/removeAnimal/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		this.service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
