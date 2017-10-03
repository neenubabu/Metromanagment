package com.neenu.dataModel;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FAREMODEL")
public class FareModel {


	@Id
	@GeneratedValue
	@Column(name = "FARECODE", nullable = false)
	private String fareCode;
	
	@Column(name = "FARE", nullable = false)
	private BigDecimal fare;

	public String getFareCode() {
		return fareCode;
	}

	public void setFareCode(String fareCode) {
		this.fareCode = fareCode;
	}

	public BigDecimal getFare() {
		return fare;
	}

	public void setFare(BigDecimal fare) {
		this.fare = fare;
	}
	




	

}
