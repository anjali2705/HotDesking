package com.hotDesking.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cityId;
	private Integer isActive;
	private String cityName;
	private String country;
	private String pincode;
	private String stateName;
	
	@OneToMany(mappedBy = "city")
	private List<Office> offices;
	
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public City(Integer cityId, Integer isActive, String cityName, String country, String pincode, String stateName) {
		super();
		this.cityId = cityId;
		this.isActive = isActive;
		this.cityName = cityName;
		this.country = country;
		this.pincode = pincode;
		this.stateName = stateName;
	}

	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public List<Office> getOffices() {
		return offices;
	}
	
	public void setOffices(List<Office> offices) {
		this.offices = offices;
	}
	
	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", isActive=" + isActive + ", cityName=" + cityName + ", country=" + country
				+ ", pincode=" + pincode + ", stateName=" + stateName + "]";
	}

	
	
	
}
