package com.hotDesking.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SeatType {
	@Id
	@GeneratedValue
	private Integer seatTypeId;
	private String seatCode;
	private String seatName;
	
	
	
	public SeatType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SeatType(Integer seatTypeId, String seatCode, String seatName) {
		super();
		this.seatTypeId = seatTypeId;
		this.seatCode = seatCode;
		this.seatName = seatName;
	}
	public Integer getSeatTypeId() {
		return seatTypeId;
	}
	public void setSeatTypeId(Integer seatTypeId) {
		this.seatTypeId = seatTypeId;
	}
	public String getSeatCode() {
		return seatCode;
	}
	public void setSeatCode(String seatCode) {
		this.seatCode = seatCode;
	}
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
}
