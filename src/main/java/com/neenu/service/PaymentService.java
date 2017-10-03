package com.neenu.service;


import java.math.BigDecimal;

import com.neenu.exception.AppException;
import com.neenu.transferObjects.CustomerDTO;


public interface PaymentService {
	
	
	/**
	 * @param cardNumber
	 * @return
	 * @throws AppException
	 */
	CustomerDTO retrieveCustomerInfo(String cardNumber) throws AppException;


	/**
	 * @param id
	 * @param value
	 * @return
	 * @throws AppException
	 */
	CustomerDTO deductAmount(String id, BigDecimal value) throws AppException;

	/**
	 * @param id
	 * @param value
	 * @return
	 * @throws AppException
	 */
	CustomerDTO topupCard(String id, BigDecimal value) throws AppException;


	

}
