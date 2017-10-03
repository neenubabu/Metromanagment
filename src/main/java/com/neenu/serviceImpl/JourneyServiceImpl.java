package com.neenu.serviceImpl;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.neenu.dataModel.JourneyModel;
import com.neenu.exception.AppException;
import com.neenu.repository.JourneyRepository;
import com.neenu.service.FareService;
import com.neenu.service.JourneyService;
import com.neenu.service.PaymentService;
import com.neenu.transferObjects.CustomerDTO;
import com.neenu.validator.JourneytValidator;
import com.neenu.validator.PaymentValidator;

@Service
public class JourneyServiceImpl implements JourneyService {
	@Autowired
	private FareService fareService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private JourneyRepository journeyRepo;
	@Override
	public CustomerDTO doCheckIn(String cardNumber,String stationCode) throws AppException {
		//retrieve full customer profile rather taking from front end input to avoid data tampering.
		//Customer profiles can be cached on a session based application.
		CustomerDTO customerTO = paymentService.retrieveCustomerInfo(cardNumber);
		// retrieve max rate from fare table
		BigDecimal maxFare =fareService.getMaxFare();

		//validate if max fare is available in the card
		PaymentValidator.checkMinBalanceAvailable(customerTO,maxFare);
		//deduct value
		customerTO = paymentService.deductAmount(cardNumber, maxFare);
		// enter journey in the journey table
		saveJourneyInfo(cardNumber, stationCode);
		return customerTO;
	}


	private void saveJourneyInfo(String cardNumber, String stationCode) throws AppException{
		try{
			JourneyModel journey = new JourneyModel();
			journey.setCardno(cardNumber);
			journey.setOrigin(stationCode);
			Clock clock = Clock.systemDefaultZone();

			Instant instant = clock.instant();
			Date currentDate = Date.from(instant);
			journey.setExecutionTime(currentDate);
			journeyRepo.save(journey);
		}catch(Exception ex){
			throw new AppException("SAVE_JOURNEY_ERROR","Error while saving journey details");
		}
	}


	@Override
	public CustomerDTO doCheckout(String cardNumber,String stationCode) throws AppException {
		CustomerDTO customerTO = null;

		// get last active Journey
		JourneyModel journeyModel = retrieveLastJourneyInfo(cardNumber);
		
		//validate if both checkin and checkout are at same kind of stations
		JourneytValidator.isBothStationSameKind(stationCode,journeyModel.getOrigin());
		//figure out fare
		BigDecimal fareToBededuted = fareService.getFare(journeyModel.getOrigin(),stationCode);
		//remove from DB to avoid huge load of data in db. If pax journey details has to be recorded no need to call this.
		journeyRepo.delete(journeyModel);
		// add  max rate to card and deduct actual fare  value
		customerTO = paymentService.deductAmount(cardNumber, fareToBededuted);


		return customerTO;

	}


	private JourneyModel retrieveLastJourneyInfo(String cardNumber) throws AppException{
		List<JourneyModel> journeyModels = journeyRepo.findByCardNumber(cardNumber);
		if(CollectionUtils.isEmpty(journeyModels)){
			throw new AppException("RETRIVE_JOURNEY_ERROR","Error while retrieving last checkin details. Please contact station master for assistance");
		}
		return journeyModels.get(0);
	}
}
