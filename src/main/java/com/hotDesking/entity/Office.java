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
public class Office {
	@Id
	@GeneratedValue
	private Integer officeId;
	private Integer isActive;
	private String officeName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private City city;
	

	
	@OneToMany(mappedBy = "office")
	private List<Building> buildings;
	
	public List<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
	}

	public Office() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Office(Integer officeId, Integer isActive, String officeName, City city) {
		super();
		this.officeId = officeId;
		this.isActive = isActive;
		this.officeName = officeName;
		this.city = city;
	}

	public Integer getOfficeId() {
		return officeId;
	}
	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Office [officeId=" + officeId + ", isActive=" + isActive + ", officeName=" + officeName + "]";
	}
	
	
}
