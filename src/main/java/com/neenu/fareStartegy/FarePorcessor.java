package com.neenu.fareStartegy;

import java.math.BigDecimal;

import com.neenu.exception.AppException;

public interface FarePorcessor {
	
	BigDecimal process(String origin,String destination,BigDecimal maxFare) throws AppException;
	


}
