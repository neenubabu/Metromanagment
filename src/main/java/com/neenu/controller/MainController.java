package com.neenu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neenu.constants.RestUrlConstants;
import com.neenu.constants.TemplateNameConstants;
import com.neenu.exception.AppException;
import com.neenu.service.JourneyService;
import com.neenu.service.PaymentService;
import com.neenu.service.StationService;
import com.neenu.transferObjects.CustomerDTO;
import com.neenu.transferObjects.JourneyDTO;
import com.neenu.transferObjects.MainDTO;

/**
 * @author Neenu
 *
 */
@Controller
public class MainController {


	private static final String DATA = "data";

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private JourneyService journeyService;
	
	@Autowired
	private StationService stationService;
	
    Logger log = LoggerFactory.getLogger(this.getClass());
     
    
    /**
     * @param model
     * @return
     * method to redirect to welcome page
     */
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String loadWelcome(Model model) {
    	
        setModelAttribute(null,new CustomerDTO(),null, model);
        return TemplateNameConstants.INDEX;
    }
 
    /**
     * @param mainDto
     * @param model
     * @return
     * 
     * Method to indetify the customer
     */
    @RequestMapping(value=RestUrlConstants.IDENTIFY_CUSTOMER, method=RequestMethod.POST)
    public String customerForm(@ModelAttribute MainDTO mainDto,Model model) {
    	 String returnTemplate = TemplateNameConstants.INDEX;
    	 String info= null;
    	 CustomerDTO customer = mainDto.getCustomerDto();
    	 try {
    		 	 info = String.format("Customer Submission: id = %s, firstname = %s, lastname = %s", 
        			 customer.getId(), customer.getFirstName(), customer.getLastName());
    		 	log.info(info);
    		 	customer = paymentService.retrieveCustomerInfo(customer.getId());


    		 	returnTemplate = TemplateNameConstants.CUST_DASHBOARD;
			} catch (AppException e) {
				mainDto.setErrorMessage(e.getCustomMessage());
			}
         setModelAttribute(mainDto,customer,new JourneyDTO(), model);

        return returnTemplate;
    }

	
    
    
    /**
     * @param mainDTO
     * @param model
     * @return
     * 
     * method to topup the card
     */
    @RequestMapping(value=RestUrlConstants.USER_ACTION, method=RequestMethod.POST, params={RestUrlConstants.TOPUP_CARD})
    public String topupCard(@ModelAttribute MainDTO mainDTO,Model model) {
    	 String returnTemplate = TemplateNameConstants.CUST_DASHBOARD;
    	 CustomerDTO customer = mainDTO.getCustomerDto();
    	 try {
    		 	String info = String.format("details for topup selected : id = %s", 
        			 customer.getId(), customer.getTopUp());
    		 	log.info(info);
    		 	customer = paymentService.topupCard(customer.getId(),customer.getTopUp());
    		 	returnTemplate = TemplateNameConstants.CUST_DASHBOARD;
    		 	mainDTO.setSuccessMessage("Payment SuccessFul");
			} catch (AppException e) {
				mainDTO.setErrorMessage(e.getCustomMessage());
			}
         setModelAttribute(mainDTO,customer,new JourneyDTO(), model);

        return returnTemplate;
    }
 
    
    /**
     * @param dto
     * @param model
     * @return
     * 
     * method to checkin
     */
    @RequestMapping(value=RestUrlConstants.USER_ACTION, method=RequestMethod.POST,params={RestUrlConstants.CHECK_IN})
    public String checkIn(@ModelAttribute MainDTO dto,Model model) {
    	 String returnTemplate = TemplateNameConstants.CUST_DASHBOARD;
    	 JourneyDTO journey = dto.getJourneyDto();
    	 
    	 try {
    		 	String info = String.format("details for checkin selected :  from %s station", 
    		 			journey.getOrigin());
    		 	log.info(info);
    		 	dto.setCustomerDto(journeyService.doCheckIn(dto.getCustomerDto().getId(),journey.getOrigin()));
    		 	dto.setSuccessMessage("Check in successful");
    		 	
			} catch (AppException e) {
				dto.setErrorMessage(e.getCustomMessage());

			}
         setModelAttribute(dto,dto.getCustomerDto(),new JourneyDTO(), model);

        return returnTemplate;
    }
    
    
    /**
     * @param dto
     * @param model
     * @return
     * 
     * Method to check out
     */
    @RequestMapping(value=RestUrlConstants.USER_ACTION, method=RequestMethod.POST,params={RestUrlConstants.CHECK_OUT})
    public String checkOut(@ModelAttribute MainDTO dto,Model model) {
    	 String returnTemplate = TemplateNameConstants.CUST_DASHBOARD;
    	 JourneyDTO journey = dto.getJourneyDto();
    	 
    	 try {
    		 	String info = String.format("details for checkin selected :  from %s station", 
    		 			journey.getOrigin());
    		 	log.info(info);
    		 	dto.setCustomerDto(journeyService.doCheckout(dto.getCustomerDto().getId(),journey.getDestination()));
    		 	dto.setSuccessMessage("Check out successful");
    		 	
			} catch (AppException e) {
				dto.setErrorMessage(e.getCustomMessage());

			}
         setModelAttribute(dto,dto.getCustomerDto(),new JourneyDTO(), model);

        return returnTemplate;
    }
    
    private void setModelAttribute(MainDTO mainDTO,CustomerDTO customer, JourneyDTO journeyDTO,Model model) {
    	if(mainDTO==null){
    		mainDTO = new MainDTO();
    	}
    	mainDTO.setCustomerDto(customer);
    	mainDTO.setJourneyDto(journeyDTO);
		model.addAttribute(DATA, mainDTO);

         
	}
 


}
