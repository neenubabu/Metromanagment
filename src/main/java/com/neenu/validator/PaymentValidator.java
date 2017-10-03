package com.neenu.validator;

import java.math.BigDecimal;
import java.util.function.Predicate;

import com.neenu.exception.AppException;
import com.neenu.transferObjects.CustomerDTO;

public class PaymentValidator {
	
	
    private static final Predicate<BigDecimal> negativeCheck = s -> s.signum() == -1;

	
	/**
	 * @param value
	 * @throws AppException
	 */
	public static void validateAmount(BigDecimal value) throws AppException {

		if(negativeCheck.test(value)){
			throw new AppException("INVALID_AMOUNT", "Please enter valid amount for payment");
			
		}

    }


	/**
	 * @param customerTO
	 * @param maxFare
	 * @throws AppException
	 */
	public static void checkMinBalanceAvailable(CustomerDTO customerTO,
			BigDecimal maxFare) throws AppException {

		if(customerTO.getValue().compareTo(maxFare)<0){
			throw new AppException("INSUFFICIENT_AMOUNT", "Please recharge your card");

		}
	}

}
