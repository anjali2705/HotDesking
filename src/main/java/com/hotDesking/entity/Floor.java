package com.hotDesking.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Floor {
	
	@Id
	@GeneratedValue
	private Integer floorId;
	private Integer isActive;
	private String floorName;
	private String floorPlan;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Building building;
	
	@OneToMany(mappedBy="floor")
	private List<Seat> seats;
	
	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public Floor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Floor(Integer floorId, Integer isActive, String floorName, String floorPlan, Building building) {
		super();
		this.floorId = floorId;
		this.isActive = isActive;
		this.floorName = floorName;
		this.floorPlan = floorPlan;
		this.building = building;
	}

	public Integer getFloorId() {
		return floorId;
	}
	public void setFloorId(Integer floorId) {
		this.floorId = floorId;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public String getFloorName() {
		return floorName;
	}
	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}
	public String getFloorPlan() {
		return floorPlan;
	}
	public void setFloorPlan(String floorPlan) {
		this.floorPlan = floorPlan;
	}
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
	}

	@Override
	public String toString() {
		return "Floor [floorId=" + floorId + ", isActive=" + isActive + ", floorName=" + floorName + ", floorPlan="
				+ floorPlan + "]";
	}
	
		
}
