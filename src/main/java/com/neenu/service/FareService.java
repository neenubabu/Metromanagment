package com.neenu.service;

import java.math.BigDecimal;

import com.neenu.exception.AppException;
import com.neenu.transferObjects.CustomerDTO;




public interface FareService {

	BigDecimal getMaxFare() throws AppException;

	BigDecimal getFare(String origin, String stationCode) throws AppException;

	
	
	\
}
