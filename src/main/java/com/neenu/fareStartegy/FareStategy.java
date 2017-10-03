package com.neenu.fareStartegy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Neenu
 *
 */
@Component
public class FareStategy  implements  IFareStategy,ApplicationContextAware{

	private ApplicationContext applicationContext ;

	
	/* (non-Javadoc)
	 * @see com.neenu.fareStartegy.IFareStategy#getFareProcessor(boolean)
	 */
	@Override
	public FarePorcessor getFareProcessor (boolean isBusJourney) {
        if (isBusJourney) {
            return applicationContext.getBean(BusFareProcessor.class);
        } else {
            return applicationContext.getBean(TubeFareProcessor.class);
        }
    }
	@Override
	public void setApplicationContext(
			ApplicationContext arg0)
					throws BeansException {
		this.applicationContext = arg0;		
	}
}
