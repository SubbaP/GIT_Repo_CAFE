package com.cafex.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * PurchaseItem model Object
 * 
 * 
 */
@Entity
public class PurchaseItem {

	public PurchaseItem() {
	}

	@Id
	@GeneratedValue
	private Long id;

	// Cage item name
	private String name;
	
	private Long orderNum;

	/**
	 * @param name
	 * @param price
	 */
	public PurchaseItem(Long orderNum, String name) {
		this.orderNum = orderNum;
		this.name = name;
	}

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString(java.lang.Object)
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
