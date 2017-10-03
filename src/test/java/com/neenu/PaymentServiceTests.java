package com.neenu;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.neenu.exception.AppException;
import com.neenu.service.JourneyService;
import com.neenu.service.PaymentService;
import com.neenu.transferObjects.CustomerDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentServiceTests {
	
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

	
	@Autowired
	PaymentService  paymentService;
	@Test
	public void contextLoads() {
	}

	
	@Test
	public void testDeductAmount() throws AppException {

		CustomerDTO customerDTO= 	paymentService.deductAmount("1234",BigDecimal.valueOf(3));

		Assert.assertNotNull(customerDTO);
		

	}
	
	
	@Test
	public void testRetreiveCustomerInfo() throws AppException {

		CustomerDTO customerDTO= 	paymentService.retrieveCustomerInfo("1234");

		Assert.assertNotNull(customerDTO);
		

	}
	
	@Test
	public void testTopupCard() throws AppException {

		CustomerDTO customerDTO= 	paymentService.topupCard("1234",BigDecimal.valueOf(20));

		Assert.assertNotNull(customerDTO);
		

	}
	
	
	
}
