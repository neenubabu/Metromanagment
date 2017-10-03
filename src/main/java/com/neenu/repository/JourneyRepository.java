package com.neenu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neenu.dataModel.CustomerModel;
import com.neenu.dataModel.JourneyModel;
import com.neenu.dataModel.StationModel;


public interface JourneyRepository extends JpaRepository<JourneyModel, String> {

	@Query("SELECT t FROM JourneyModel t WHERE t.cardno = ?1 order by t.executionTime desc")
	List<JourneyModel> findByCardNumber(String cardNumber);

}
