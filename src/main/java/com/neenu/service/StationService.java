package com.neenu.service;

import java.util.List;

import com.neenu.exception.AppException;
import com.neenu.transferObjects.StationDTO;




public interface StationService {

	List<StationDTO>  getListOfStation() ;

	StationDTO getStationData(String stationCode) throws AppException;

	
	
	
}
