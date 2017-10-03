package com.neenu.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neenu.dataModel.FareModel;


public interface FareRepository extends JpaRepository<FareModel, String> {

	@Query("SELECT max(t.fare) FROM FareModel t ")
	BigDecimal getMaxFare();
	
	
	

}
