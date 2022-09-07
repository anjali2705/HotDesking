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
import com.hotDesking.entity.Office;
import com.hotDesking.exception.IdNotFoundException;
import com.hotDesking.repository.CityRepository;
import com.hotDesking.repository.OfficeRepository;

@RestController
public class OfficeController {
	
	@Autowired
	private OfficeRepository officeRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	
	//search office by seat id
	@GetMapping("/city/office/{id}")
	public List<Office> retrieveCityOffice(@PathVariable int id){
		Optional<City> city=cityRepository.findById(id);
		if(!city.isPresent()) {
			throw new IdNotFoundException("Id Not available:"+id);
		}
		return city.get().getOffices();
		
	}
	@PostMapping("/city/office/{id}")
	public Office addOffice(@PathVariable int id,@RequestBody Office office) {
		Optional<City> cityOptional=cityRepository.findById(id);
		
		City city=cityOptional.get();
		
		office.setCity(city);
		
		Office savedOffice=officeRepository.save(office);
		
		return savedOffice;
	}
	
	@PutMapping("/office")
	public void updateCity(@RequestBody Office office) {
		officeRepository.save(office);
	}
	
	
	@DeleteMapping("/office/{id}")
	public void deleteById(@PathVariable int id) {
		officeRepository.deleteById(id);
	}
	
	
	
	
}
