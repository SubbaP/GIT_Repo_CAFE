package com.cafex.services;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cafex.model.PurchaseItem;
import com.cafex.repositories.CafeItemRepository;
import com.cafex.repositories.PurchaseItemRepository;

/**
 * @author SubbaP 
 * A Billing service implementation of {@link BillingService}.
 *
 */
@Service
public class BillingServiceImpl implements BillingService {

	final static Logger LOGGER = Logger.getLogger(BillingServiceImpl.class);

	PurchaseItemRepository purchaseItemRepository;
	CafeItemRepository cafeItemRepository;

	public BillingServiceImpl(PurchaseItemRepository purchaseItemRepository, CafeItemRepository cafeItemRepository) {
		this.purchaseItemRepository = purchaseItemRepository;
		this.cafeItemRepository = cafeItemRepository;
	}

	private double getCafeItemPrice(String itemName) {
		return cafeItemRepository.findByName(itemName).getPrice().doubleValue();
	}

	@Override
	public BigDecimal getTotalPrice(Long orderNum) {

		List<PurchaseItem> purchaseItems = purchaseItemRepository.findByOrderNum(orderNum);

		LOGGER.debug("BillingServiceImpl purchage items : " + purchaseItems);
		double subTotal = purchaseItems.stream().mapToDouble(purchaseItem -> getCafeItemPrice(purchaseItem.getName()))
				.sum();

		BigDecimal subTotlValue = new BigDecimal(subTotal).setScale(2, BigDecimal.ROUND_HALF_UP);

		return subTotlValue;

	}

}
