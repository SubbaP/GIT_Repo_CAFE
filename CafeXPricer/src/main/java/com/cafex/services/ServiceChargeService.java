package com.cafex.services;

import java.math.BigDecimal;

/**
 * @author SubbaP
 * Provides an interface to calculate the total price of purchased cafe items.
 *
 */
public interface ServiceChargeService {

	/**
	 * @param orderNum 
	 * @return value service charge
	 */
	public BigDecimal calulateServiceCharge(Long orderNum);

	

}
