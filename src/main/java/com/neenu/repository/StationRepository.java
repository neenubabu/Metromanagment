package com.neenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neenu.dataModel.StationModel;


public interface StationRepository extends JpaRepository<StationModel, String> {

	@Query("SELECT t FROM StationModel t where t.stationCode = ?1 ")
	StationModel getStationByStationCode(String stationCode);

}
