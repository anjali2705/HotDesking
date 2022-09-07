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
import com.hotDesking.entity.Floor;
import com.hotDesking.exception.IdNotFoundException;
import com.hotDesking.repository.BuildingRepository;
import com.hotDesking.repository.FloorRepository;

@RestController
public class FloorController {
	
	@Autowired
	private FloorRepository floorRepository;
	
	@Autowired
	private BuildingRepository buildingRepository;
	
	
	//search floor by building id
	@GetMapping("/building/floor/{id}")
	public List<Floor> retrieveOfficeBuilding(@PathVariable int id){
		Optional<Building> building=buildingRepository.findById(id);
		if(!building.isPresent()) {
			throw new IdNotFoundException("Id Not available:"+id);
		}
		
		return building.get().getFloors();
		
	}
	
	@PostMapping("/building/floor/{id}")
	public Floor addFloor(@PathVariable int id,@RequestBody Floor floor) {
		Optional<Building> buildingOptional=buildingRepository.findById(id);
		
		Building building=buildingOptional.get();
		
		floor.setBuilding(building);
		
		Floor savedFloor=floorRepository.save(floor);
		
		return savedFloor;
	}
	
	@PutMapping("/floor")
	public void updateFloor(@RequestBody Floor floor) {
		floorRepository.save(floor);
	}
	
	
	@DeleteMapping("/floor/{id}")
	public void deleteById(@PathVariable int id) {
		floorRepository.deleteById(id);
	}
	
	
	
	
}
