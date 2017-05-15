/**
 * 
 */
package com.cafex.model;

/**
 * Enumeration to hold service charge percentage.
 * @author SubbaP
 *
 */
public enum ServiceChargeEnum {
	
	HOTFOOD(20), COLDFOOD(10), DRINK(0);

	private Integer serviceCharge;

	private ServiceChargeEnum(Integer percentage) {
		this.serviceCharge = percentage;
	}
	
	
	
	public Integer getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(Integer serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	
}
