package com.cafex.services;

import java.util.List;

import com.cafex.model.CafeItem;
import com.cafex.repositories.CafeItemRepository;

/**
 * @author SubbaP 
 * A CafeItem service implementation of {@link CafeItemService}.
 *
 */
public class CafeItemServiceImpl implements CafeItemService{

	
	CafeItemRepository cafeItemRepository;
	
	@Override
	public void loadCafeItems(List<CafeItem> cafeItems) {

		cafeItemRepository.save(cafeItems);
		
	}

}
