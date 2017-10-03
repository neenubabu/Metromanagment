package com.neenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neenu.dataModel.CustomerModel;


public interface CustomerRepository extends JpaRepository<CustomerModel, String> {



	
	
}
