package com.cafex.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cafex.model.PurchaseItem;



/**
 * A crud repository to access PurchaseItems.
 * @see com.cafex.model.PurchaseItem
 */
@Repository
public interface PurchaseItemRepository extends CrudRepository<PurchaseItem, String> {

	/*
	 * @param orderNum
	 * 
	 * @return list of Purchase items
	 */
	List<PurchaseItem> findByOrderNum(Long orderNum);

}
