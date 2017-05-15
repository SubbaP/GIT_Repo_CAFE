package com.cafex.services;

import java.math.BigDecimal;

/**
 * @author SubbaP
 * Provides an interface to calculate the total price of purchased cafe items.
 *
 */
public interface BillingService {

	/**
	 * @param orderNum unique order number for given purchased items
	 * @return total price for the purchased items.
	 */
	public BigDecimal getTotalPrice(Long orderNum);

	

}
