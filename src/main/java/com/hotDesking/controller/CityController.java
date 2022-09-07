package com.hotDesking.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotDesking.entity.City;
import com.hotDesking.exception.IdNotFoundException;
import com.hotDesking.repository.CityRepository;

@RestController
public class CityController {
	
	@Autowired
	private CityRepository cityRepository;
	
	
	@GetMapping("/city/all")
	public List<City> retrieveAllCities(){
		return cityRepository.findAll();
	}
	
	//search city by id
	@GetMapping("/city/{id}")
	 public Optional<City> retrieveOneCity(@PathVariable int id){
		
		 	Optional<City> city=cityRepository.findById(id);
		
		 	if(!city.isPresent()) {
				throw new IdNotFoundException("Id Not available:"+id);
			}
		 	return city; 		 
	 }
	
	@PutMapping("/city")
	public void updateCity(@RequestBody City city) {
		cityRepository.save(city);
	}
	
	@PostMapping("/city/add")
	public City addCity(@RequestBody City city) {
		City savedCity=cityRepository.save(city);
		return savedCity;
	}
	@DeleteMapping("/city/{id}")
	public void deleteCity(@PathVariable int id) {
		cityRepository.deleteById(id);
	}
	
	
	
}
