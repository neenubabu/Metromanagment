package com.neenu.fareStartegy;

import com.neenu.exception.AppException;

/**
 * @author Neenu
 *
 */
public interface IFareStategy  
{
	/**
	 * @param isBusJourney
	 * @return
	 * @throws AppException
	 * get corresponding fare processor
	 */
	public FarePorcessor getFareProcessor (boolean isBusJourney) throws AppException;

}
