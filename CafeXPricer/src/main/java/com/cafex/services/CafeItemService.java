package com.cafex.services;

import java.util.List;

import com.cafex.model.CafeItem;

/**
 * @author SubbaP
 * Provides an interface to load cafe service items(food, drink etc)
 *
 */
public interface CafeItemService {

	/*
	 *   
	 * @param load list of cafe items
	 */
	public void loadCafeItems(List<CafeItem> cafeItems);

}
