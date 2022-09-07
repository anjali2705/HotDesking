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

import com.hotDesking.entity.Floor;
import com.hotDesking.entity.Seat;
import com.hotDesking.exception.IdNotFoundException;
import com.hotDesking.repository.FloorRepository;
import com.hotDesking.repository.SeatRepository;

@RestController
public class SeatController {
	
	@Autowired
	private FloorRepository floorRepository;
	
	@Autowired
	private SeatRepository seatRepository;
	
	
	//search seat by floor id
	@GetMapping("/floor/seat/{id}")
	public List<Seat> retrieveFloorSeat(@PathVariable int id){
		Optional<Floor> floor=floorRepository.findById(id);
		if(!floor.isPresent()) {
			throw new IdNotFoundException("Id Not available:"+id);
		}
		return floor.get().getSeats();
		
	}
	@PostMapping("/floor/seat/{id}")
	public Seat addSeat(@PathVariable int id,@RequestBody Seat seat) {
		Optional<Floor> floorOptional=floorRepository.findById(id);
		
		Floor floor=floorOptional.get();
		
		seat.setFloor(floor);
		
		Seat savedSeat=seatRepository.save(seat);
		
		return savedSeat;
	}
	
	@PutMapping("/seat")
	public void updateSeat(@RequestBody Seat seat) {
		seatRepository.save(seat);
	}
	
	
	@DeleteMapping("/seat/{id}")
	public void deleteById(@PathVariable int id) {
		seatRepository.deleteById(id);
	}
	
	
	
	
}
