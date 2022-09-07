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

import com.hotDesking.entity.Building;
import com.hotDesking.entity.Office;
import com.hotDesking.exception.IdNotFoundException;
import com.hotDesking.repository.BuildingRepository;
import com.hotDesking.repository.OfficeRepository;

@RestController
public class BuildingController {
	
	@Autowired
	private OfficeRepository officeRepository;
	
	@Autowired
	private BuildingRepository buildingRepository;
	
	
	//search building by office id
	@GetMapping("/office/building/{id}")
	public List<Building> retrieveOfficeBuilding(@PathVariable int id){
		Optional<Office> office=officeRepository.findById(id);
		if(!office.isPresent()) {
			throw new IdNotFoundException("Id Not available:"+id);
		}
		return office.get().getBuildings();
		
	}
	@PostMapping("/office/building/{id}")
	public Building addBuilding(@PathVariable int id,@RequestBody Building building) {
		Optional<Office> officeOptional=officeRepository.findById(id);
		
		Office office=officeOptional.get();
		
		building.setOffice(office);
		
		Building savedBuilding=buildingRepository.save(building);
		
		return savedBuilding;
	}
	
	@PutMapping("/building")
	public void updateBuilding(@RequestBody Building building) {
		buildingRepository.save(building);
	}
	
	
	@DeleteMapping("/building/{id}")
	public void deleteById(@PathVariable int id) {
		buildingRepository.deleteById(id);
	}
	
	
	
	
}
