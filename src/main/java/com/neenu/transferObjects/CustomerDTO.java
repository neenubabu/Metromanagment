package com.neenu.transferObjects;

import java.math.BigDecimal;


public class CustomerDTO  {
	 
    private String id;
    private String firstName;
    private String lastName;
    private BigDecimal value;
    private BigDecimal topUp;
 


 
    public String getId() {
		return id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public void setId(String id) {
		this.id = id;
	}



	public BigDecimal getTopUp() {
		return topUp;
	}



	public void setTopUp(BigDecimal topUp) {
		this.topUp = topUp;
	}
 
	
    
}