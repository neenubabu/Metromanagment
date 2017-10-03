package com.neenu;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.neenu.exception.AppException;
import com.neenu.service.FareService;
import com.neenu.service.JourneyService;
import com.neenu.service.PaymentService;
import com.neenu.service.StationService;
import com.neenu.transferObjects.CustomerDTO;
import com.neenu.transferObjects.StationDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FareServiceTests {
	
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

	
	@Autowired
	FareService  fareService;
	@Test
	public void contextLoads() {
	}

	
	@Test
	public void testGetFareOfStation() throws AppException {

		BigDecimal decimal= 	fareService.getFare("HB", "EC");

		Assert.assertNotNull(decimal);
		

	}
	
	
	@Test
	public void testGetMaxFare() throws AppException {

		BigDecimal decimal= 	fareService.getMaxFare();
		Map<Double,List<Integer>> mapValue = new TreeMap<Double, List<Integer>>();
		mapValue.values().stream().sorted((l1,l2)->)
		Math.sqrt(a)

		Assert.assertNotNull(decimal);
		

	}
	
	

	
	
	
}
