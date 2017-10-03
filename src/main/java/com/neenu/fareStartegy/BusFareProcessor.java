package com.neenu.fareStartegy;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neenu.dataModel.FareModel;
import com.neenu.exception.AppException;
import com.neenu.repository.FareRepository;

/**
 * @author Neenu
 *
 */
@Component
public class BusFareProcessor implements FarePorcessor {
	
	private static final String BS = "BS";
	@Autowired
	FareRepository FareRepository;

	/* (non-Javadoc)
	 * @see com.neenu.fareStartegy.FarePorcessor#process(java.lang.String, java.lang.String, java.math.BigDecimal)
	 * method to calculate fare for bus journeys
	 */
	@Override
	public BigDecimal process(String origin, String destination,BigDecimal maxFare)
			throws AppException {
		// fetching fare for bus route
		FareModel fare = FareRepository.findOne(BS);
		return fare.getFare().subtract(maxFare);
	}

}
