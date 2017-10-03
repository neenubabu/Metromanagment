package com.neenu.fareStartegy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neenu.dataModel.FareModel;
import com.neenu.enumeration.FareStringEnums;
import com.neenu.exception.AppException;
import com.neenu.repository.FareRepository;
import com.neenu.service.StationService;
import com.neenu.transferObjects.StationDTO;

@Component
public class TubeFareProcessor implements FarePorcessor {
	
	private static final String Z1 = "-Z1";
	@Autowired
	FareRepository FareRepository;
	
	@Autowired
	private StationService stationService;

	Function<String, Integer> toInteger = Integer::valueOf;

	@Override
	public BigDecimal process(String origin, String destination,BigDecimal maxFare)
			throws AppException {
		BigDecimal fareValue = new BigDecimal(0);
		
		StationDTO originModel = stationService.getStationData(origin);
		// getting the zones of origin
		List<String> originZone = Arrays.asList(originModel.getZones().split(","));
		StationDTO destinationModel = stationService.getStationData(destination);
		// getting the zones of destination
		List<String> destZone = Arrays.asList(destinationModel.getZones().split(","));
		List<String> fareStrings = new ArrayList<String>();
		// constructing the  possible farestrings
		originZone.stream().forEach(s -> fareStrings.addAll(constructFareString(s,destZone)));
		//identifying the lowest fare
		Optional<FareModel> fare = FareRepository.findAll(fareStrings).stream().min((a,b)->a.getFare().compareTo(b.getFare()));
		
		if(fare.isPresent()){
			fareValue = fare.get().getFare().subtract(maxFare);
		}

		return fareValue;
	}
	
	private List<String> constructFareString(String origZone, List<String> destZones){
		List<String> fareStrings = new ArrayList<String>();
		for(String destZone:destZones){
			StringBuilder builder = new StringBuilder();
			Integer val = toInteger.apply(destZone) - toInteger.apply(origZone);
			if(val <0){
				val = val*-1;				
			}
			FareStringEnums fareStringEnum = FareStringEnums.getFareStringByZoneNumber(val+1);
			if(fareStringEnum!=null){
				builder.append(fareStringEnum.getCode());
			}
			if(toInteger.apply(destZone).intValue()==1 || toInteger.apply(origZone).intValue()==1 ){
				builder.append(Z1);
			}
			if(builder.length()>0){
				fareStrings.add(builder.toString());
			}
		}
		return fareStrings;
		
	}
	

}
