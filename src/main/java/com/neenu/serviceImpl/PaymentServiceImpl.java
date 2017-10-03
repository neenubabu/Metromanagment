package com.neenu.serviceImpl;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neenu.dataModel.CustomerModel;
import com.neenu.exception.AppException;
import com.neenu.repository.CustomerRepository;
import com.neenu.service.PaymentService;
import com.neenu.transferObjects.CustomerDTO;
import com.neenu.validator.PaymentValidator;

@Service
public class PaymentServiceImpl implements PaymentService {


	@Autowired
	private CustomerRepository customerRepository;

	/* (non-Javadoc)
	 * @see com.neenu.service.PaymentService#retrieveCustomerInfo(java.lang.String)
	 */
	@Override
	public CustomerDTO retrieveCustomerInfo(String cardNumber)
			throws AppException {
		CustomerDTO  customerTO = null;
		CustomerModel customerModel = customerRepository.findOne(cardNumber.trim());
		if(customerModel!=null){
			customerTO = new CustomerDTO();
			BeanUtils.copyProperties(customerModel, customerTO);
		}else{
			throw new AppException("USER_NOT_FOUND", "Card details not available. Please enter valid card number");
		}
		return  customerTO;
	}

	/* (non-Javadoc)
	 * @see com.neenu.service.PaymentService#topupCard(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public CustomerDTO topupCard(String id, BigDecimal value) throws AppException {
		CustomerDTO customerTO = null;
		// validate the amount entered for payment
		PaymentValidator.validateAmount(value);
		customerTO = updateBalanceInCard(id, value, customerTO);
		return  customerTO;

	}

	/* (non-Javadoc)
	 * @see com.neenu.service.PaymentService#deductAmount(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public CustomerDTO deductAmount(String id, BigDecimal value) throws AppException {
		CustomerDTO customerTO = null;
		// send negative value to deduct from the balance
		customerTO = updateBalanceInCard(id, value.negate(), customerTO);
		return  customerTO;

	}

	/**
	 * @param id
	 * @param value
	 * @param customerTO
	 * @return
	 * @throws AppException
	 */
	private CustomerDTO updateBalanceInCard(String id, BigDecimal value,
			CustomerDTO customerTO) throws AppException {
		try{
			//vaildate negative value
			CustomerModel customerModel = customerRepository.findOne(id.trim());
			if(customerModel!=null){
				customerModel.setValue(customerModel.getValue().add(value));
				customerRepository.save(customerModel);
				customerTO = new CustomerDTO();
				BeanUtils.copyProperties(customerModel, customerTO);
			}
		}catch(Exception ex){
			throw new AppException("PAYMENT_ERROR", "Error while payment : "+ex.getMessage(),ex);
		}
		return customerTO;
	}







}
