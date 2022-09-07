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
public class Building {
	@Id
	@GeneratedValue
	private Integer buildingId;
	private Integer isActive;
	private String buildingName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Office office;
	
	@OneToMany(mappedBy = "building")
	private List<Floor> floors;
	

	public Building() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Building(Integer buildingId, Integer isActive, String buildingName, Office office) {
		super();
		this.buildingId = buildingId;
		this.isActive = isActive;
		this.buildingName = buildingName;
		this.office = office;
	}


	public Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public List<Floor> getFloors() {
		return floors;
	}
	
	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}
	@Override
	public String toString() {
		return "Building [buildingId=" + buildingId + ", isActive=" + isActive + ", buildingName=" + buildingName + "]";
	}
	
	
	
}
