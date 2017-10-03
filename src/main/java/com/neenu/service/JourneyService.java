package com.neenu.service;

import com.neenu.exception.AppException;
import com.neenu.transferObjects.CustomerDTO;




public interface JourneyService {

	CustomerDTO doCheckIn(String cardNumber,String stationCode) throws AppException;

	CustomerDTO doCheckout(String cardNumber,String stationCode) throws AppException;
	
	
	
}
