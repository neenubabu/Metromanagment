package com.neenu.serviceImpl;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neenu.exception.AppException;
import com.neenu.fareStartegy.FarePorcessor;
import com.neenu.fareStartegy.IFareStategy;
import com.neenu.repository.FareRepository;
import com.neenu.service.FareService;
import com.neenu.validator.JourneytValidator;

@Service
public class FareServiceImpl implements FareService {
	

	@Autowired
	private FareRepository fareRepo;
	
	
	@Autowired
	private IFareStategy fareStategy;

	
	
	private static BigDecimal maxFare = null;




	/* (non-Javadoc)
	 * @see com.neenu.service.FareService#getMaxFare()
	 */
	@Override
	@PostConstruct
	public BigDecimal getMaxFare() throws AppException {
		if(maxFare==null){
			maxFare =fareRepo.getMaxFare();
		}
		return maxFare;
	}

	/* (non-Javadoc)
	 * @see com.neenu.service.FareService#getFare(java.lang.String, java.lang.String)
	 */
	@Override
	public BigDecimal getFare(String origin, String destination)
			throws AppException {
		BigDecimal fareValue = new BigDecimal(0);
		// get fare processor from fare strategy
		FarePorcessor farePorcessor = fareStategy.getFareProcessor(JourneytValidator.isBusJourney(origin));
		fareValue =farePorcessor.process(origin, destination, maxFare);
		return fareValue;
					
	}
	
	  
	


}
