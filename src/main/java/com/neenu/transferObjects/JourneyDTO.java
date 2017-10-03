package com.neenu.transferObjects;

import com.neenu.enumeration.JourneyOperation;



/**
 * @author NEENU
 *
 */
public class JourneyDTO  {
	 
    private String origin;
    private String destination;
    private JourneyOperation operation;
 


	public String getOrigin() {
		return origin;
	}




	public void setOrigin(String origin) {
		this.origin = origin;
	}




	public String getDestination() {
		return destination;
	}




	public void setDestination(String destination) {
		this.destination = destination;
	}




	public JourneyOperation getOperation() {
		return operation;
	}




	public void setOperation(JourneyOperation operation) {
		this.operation = operation;
	}




	






}