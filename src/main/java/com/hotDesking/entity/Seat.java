package com.hotDesking.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Seat {
	@Id
	@GeneratedValue
	private Integer seatId;
	private Integer isActive;
	private Integer cubiclePosition;
	private String qrNumber;
	private Integer seatNumber;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Floor floor;
	
	private Integer seatTypeId;
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Seat(Integer seatId, Integer isActive, Integer cubiclePosition, String qrNumber, Integer seatNumber,
			Floor floor, Integer seatTypeId) {
		super();
		this.seatId = seatId;
		this.isActive = isActive;
		this.cubiclePosition = cubiclePosition;
		this.qrNumber = qrNumber;
		this.seatNumber = seatNumber;
		this.floor = floor;
		this.seatTypeId = seatTypeId;
	}
	public Integer getSeatId() {
		return seatId;
	}
	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public Integer getCubiclePosition() {
		return cubiclePosition;
	}
	public void setCubiclePosition(Integer cubiclePosition) {
		this.cubiclePosition = cubiclePosition;
	}
	public String getQrNumber() {
		return qrNumber;
	}
	public void setQrNumber(String qrNumber) {
		this.qrNumber = qrNumber;
	}
	public Integer getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}
	public Floor getFloor() {
		return floor;
	}
	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	public Integer getSeatTypeId() {
		return seatTypeId;
	}
	public void setSeatTypeId(Integer seatTypeId) {
		this.seatTypeId = seatTypeId;
	}
			
}
