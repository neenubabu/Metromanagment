package com.neenu.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.neenu.dataModel.StationModel;
import com.neenu.exception.AppException;
import com.neenu.repository.StationRepository;
import com.neenu.service.StationService;
import com.neenu.transferObjects.StationDTO;

@Service
public class StationServiceImpl implements StationService {
	 @Autowired
	private StationRepository stationRepo;

	static  List<StationDTO> stations = new ArrayList<StationDTO>();
	
	@Override
	public List<StationDTO>  getListOfStation()  {
		
		if(!CollectionUtils.isEmpty(stations)){
			stations = new ArrayList<StationDTO>();
			stationRepo.findAll().stream().forEach(s->stations.add(transformStationObject(s)));
		}
		return stations;
	}
	

	private StationDTO transformStationObject(StationModel model){
		StationDTO dto = new StationDTO();
		BeanUtils.copyProperties(model, dto);
		return dto;
	}
	
	@Override
	public StationDTO  getStationData(String stationCode) throws AppException {
		
		StationDTO stationDTO = null;
		try{
			StationModel stationModel = stationRepo.findOne(stationCode);
			if(stationModel!=null){
				stationDTO = transformStationObject(stationModel);
			}
		}catch(Exception exception){
			throw new AppException("STATION_FETCH_ERROR","Error while fetching station data");
		}
		return stationDTO;
	}

}
