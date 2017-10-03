package com.neenu.transferObjects;

import java.util.List;

public class MainDTO {
	
	private String errorMessage;
	private String successMessage;
	private CustomerDTO customerDto;
	private JourneyDTO journeyDto;


	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public CustomerDTO getCustomerDto() {
		return customerDto;
	}

	public void setCustomerDto(CustomerDTO customerDto) {
		this.customerDto = customerDto;
	}

	public JourneyDTO getJourneyDto() {
		return journeyDto;
	}

	public void setJourneyDto(JourneyDTO journeyDto) {
		this.journeyDto = journeyDto;
	}

	
	
	
	
	

}
