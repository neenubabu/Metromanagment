package com.neenu;

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
import com.neenu.transferObjects.CustomerDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JourneyServiceTests {
	
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

	
	@Autowired
	JourneyService  journeyService;
	@Test
	public void contextLoads() {
	}

	
	@Test
	public void testCheckIn() throws AppException {

		CustomerDTO customerDTO= 	journeyService.doCheckIn("1234", "HB");
		Assert.assertNotNull(customerDTO);
		

	}
	
	@Test
	public void testCheckOutWithCheckin() throws AppException {
		CustomerDTO customerDTO= 	journeyService.doCheckIn("1234", "HB");

		
		customerDTO= 	journeyService.doCheckout("1234", "EC");
		Assert.assertNotNull(customerDTO);
		

	}
	
	@Test
	public void testCheckOutWithOutCheckin() throws AppException {

		expectedException.expect(AppException.class);
		
		CustomerDTO customerDTO= 	journeyService.doCheckout("1234", "EC");
        Assert.assertNotNull(customerDTO);


		

	}

}
