package com.qa.practicalprojectbackend.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.practicalprojectbackend.entity.Animals;

@SpringBootTest
@AutoConfigureMockMvc // sets up the testing class
@Sql(scripts = { "classpath:animals-schema.sql",
		"classpath:animals-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class AnimalsControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Animals testAnimal = new Animals("Penguin", "Bird", 200000, "Carnivore", 15);
		String testAnimalAsJSON = this.mapper.writeValueAsString(testAnimal);
		RequestBuilder req = post("/createAnimal").content(testAnimalAsJSON).contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = status().is(201);
		Animals createdAnimal = new Animals(2, "Penguin", "Bird", 200000, "Carnivore", 15);
		String createdAnimalAsJSON = this.mapper.writeValueAsString(createdAnimal);
		ResultMatcher checkBody = content().json(createdAnimalAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testRead() throws Exception {
		List<Animals> animal = List.of(new Animals(1, "Lion", "Mammal", 20000, "Carnivore", 13));
		this.mvc.perform(get("/getAnimal")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(animal)));
	}

	@Test
	void testUpdate() throws Exception {
		Animals updated = new Animals(1, "Cheetah", "Mammal", 7100, "Carnivor", 12);
		this.mvc.perform(patch("/updateDino/1?name=Cheetah&animalGroup=Mammal&population=7100&diet=Carnivore&lifespan=12")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(updated)));
	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/removeAnimal/1")).andExpect(status().isNoContent());
	}
}