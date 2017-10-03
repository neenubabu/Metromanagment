package com.neenu.validator;

import java.util.function.Predicate;

import com.neenu.exception.AppException;

/**
 * @author Neenu
 *
 */
public class JourneytValidator {
	private static final String BS = "BS";

	
    private static final Predicate<String> isBusJourney = s -> s.equals(BS);

	

	/**
	 * @param value
	 * @return
	 */
	public static boolean isBusJourney(String value) {
		return isBusJourney.test(value);
		
    }



	public static void isBothStationSameKind(String destination, String origin) throws AppException{
		// check if both are busjourneys or both or tube journeys, else throw exception
		if(!isBothBusJourney(destination, origin) && !isBothNotBusJourney(destination, origin)){
			throw new AppException("STATION_MISMATCH", "Error while processing as there is a station type mismatch.Please contact station master.");
		}
	}



	private static boolean isBothNotBusJourney(String destination, String origin) {
		return !isBusJourney(destination) && !isBusJourney(origin);
	}



	private static boolean isBothBusJourney(String destination, String origin) {
		return isBusJourney(destination) && isBusJourney(origin);
	}




}
