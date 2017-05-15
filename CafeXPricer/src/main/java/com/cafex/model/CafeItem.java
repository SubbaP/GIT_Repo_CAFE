package com.cafex.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CafeItem {

	public CafeItem() {
	}

	@Id
	@GeneratedValue
	private Long id;

	// Cafe item name
	private String name;

	// Cafe item price
	private BigDecimal price;

	@Enumerated(EnumType.STRING)
	private ItemType type;

	public CafeItem(String name, BigDecimal price, ItemType itemType) {
		this.name = name;
		this.price = price;
		this.type = itemType;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
