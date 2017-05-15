package com.cafex.services;

import java.util.List;


/**
 * @author SubbaP
 * Provides an interface to build an order for the selected cafe items(food, drink etc)
 *
 */
public interface PurchaseItemService {
	
	/**
	 * @param products
	 */
	public Long buildOrder(List<String> purchaseItems);
	
	
	
}
