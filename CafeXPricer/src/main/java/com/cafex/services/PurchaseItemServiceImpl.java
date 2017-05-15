package com.cafex.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cafex.model.PurchaseItem;
import com.cafex.repositories.PurchaseItemRepository;

/**
 * @author SubbaP 
 * A Purchase item service implementation of {@link PurchaseItemService}.
 *
 */
@Service
public class PurchaseItemServiceImpl implements PurchaseItemService {

	final static Logger LOGGER = Logger.getLogger(PurchaseItemServiceImpl.class);

	private static final AtomicLong sequence = new AtomicLong(System.currentTimeMillis() / 1000);

	/**
	 * Repository to save
	 */
	PurchaseItemRepository purchaseItemRepository;

	public PurchaseItemServiceImpl(PurchaseItemRepository purchaseItemRepository) {
		this.purchaseItemRepository = purchaseItemRepository;
	}

	
	/* (non-Javadoc)
	 * @see com.cafex.services.PurchaseItemService#buildOrder(java.util.List)
	 */
	public Long buildOrder(List<String> cafeItems) {

		Set<String> mySet = new HashSet<>(cafeItems);

		Long orderNum = getOrderNum();

		List<PurchaseItem> purchaseItemList = mySet.stream().map(e -> new PurchaseItem(orderNum, e))
				.collect(Collectors.toList());

		System.out.println(" Build a list of products :" + purchaseItemList);

		Iterable<PurchaseItem> purchaseItems = purchaseItemRepository.save(purchaseItemList);

		System.out.println(" after save :" + purchaseItems);

		return orderNum;

	}

	private static long getOrderNum() {
		return sequence.incrementAndGet();
	}

}
