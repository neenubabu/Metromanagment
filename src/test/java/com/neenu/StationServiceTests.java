package com.neenu;

import java.math.BigDecimal;
import java.util.List;

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
import com.neenu.service.StationService;
import com.neenu.transferObjects.CustomerDTO;
import com.neenu.transferObjects.StationDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StationServiceTests {
	
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

	
	@Autowired
	StationService  stationService;
	@Test
	public void contextLoads() {
	}

	
	@Test
	public void testGetListOfStation() throws AppException {

		List<StationDTO> staionList= 	stationService.getListOfStation();

		Assert.assertNotNull(staionList);
		

	}
	
	
	@Test
	public void testGetStationData() throws AppException {

		StationDTO stationDTO= 	stationService.getStationData("HB");

		Assert.assertNotNull(stationDTO);
		

	}
	
	

	
	
	
}
