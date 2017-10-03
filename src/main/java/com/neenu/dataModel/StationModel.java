package com.neenu.dataModel;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STATIONMODEL")
public class StationModel {
	
	
	@Id
	@GeneratedValue
	@Column(name = "STATION_CODE", nullable = false)
	private String stationCode;
	
	@Column(name = "STATION_NAME", nullable = false)
	private String stationName;
	
	@Column(name = "ZONES", nullable = false)
	private String zones;
	
	@Column(name = "STATION_TYPE", nullable = false)
	private String stationType;

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}



	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getZones() {
		return zones;
	}

	public void setZones(String zones) {
		this.zones = zones;
	}

	public String getStationType() {
		return stationType;
	}

	public void setStationType(String stationType) {
		this.stationType = stationType;
	}
	


	

}
