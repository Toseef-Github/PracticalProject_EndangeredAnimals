//package com.qa.practicalprojectbackend.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.qa.practicalprojectbackend.entity.Animals;
//
//@Service
//public class AnimalsServiceList implements AnimalsService {
//
//		private List<Animals> animal = new ArrayList<>();
//
//		@Override
//		public Animals getById(int id) {
//			return this.animal.get(id);
//
//		}
//
//		@Override
//		public List<Animals> getAll() {
//			return this.animal;
//		}
//
//		@Override
//		public Animals create(Animals animal) {
//			this.animal.add(animal);
//			return this.animal.get(this.animal.size() - 1);
//
//		}
//
//		@Override
//		public Animals update(int id, String name, String animalGroup, Integer population, String diet, Integer lifespan) {
//			Animals toUpdate = this.animal.get(id);
//			if (name != null)
//				toUpdate.setName(name);
//			if (animalGroup != null)
//				toUpdate.setGroup(animalGroup);
//			if (population != null)
//				toUpdate.setPopulation(population);
//			if (diet != null)
//				toUpdate.setDiet(diet);
//			if (lifespan != null)
//				toUpdate.setLifespan(lifespan);
//			return toUpdate;
//		}
//
//		@Override
//		public void delete(int id) {
//			this.animal.remove(id);
//		}
//
//		@Override
//		public Animals findByName(String name) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//
//}
