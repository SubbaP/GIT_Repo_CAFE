package com.cafex.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cafex.model.CafeItem;

/**
 * A crud repository to access cafe items.
 * 
 * @see com.cafex.model.CafeItem
 */
@Repository
public interface CafeItemRepository extends CrudRepository<CafeItem, String> {

	public CafeItem findByName(String name);

}
