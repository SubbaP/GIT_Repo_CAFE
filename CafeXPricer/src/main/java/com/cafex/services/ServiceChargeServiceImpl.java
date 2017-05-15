package com.cafex.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cafex.model.CafeItem;
import com.cafex.model.PurchaseItem;
import com.cafex.model.ServiceChargeEnum;
import com.cafex.repositories.CafeItemRepository;
import com.cafex.repositories.PurchaseItemRepository;

/**
 * @author SubbaP 
 * A Billing service implementation of {@link ServiceChargeService}.
 *
 */
@Service
public class ServiceChargeServiceImpl implements ServiceChargeService {

	PurchaseItemRepository purchaseItemRepository;
	CafeItemRepository cafeItemRepository;
	BillingService billingService;
	
	public ServiceChargeServiceImpl(PurchaseItemRepository purchaseItemRepository,CafeItemRepository cafeItemRepository,BillingService billingService) {
		this.purchaseItemRepository = purchaseItemRepository;
		this.cafeItemRepository = cafeItemRepository;
		this.billingService = billingService;
		
	}

	/* (non-Javadoc)
	 * @see com.cafex.services.ServiceChargeService#calulateServiceCharge(java.lang.Long)
	 */
	@Override
	public BigDecimal calulateServiceCharge(Long orderNum) {

		BigDecimal serviceChargeValue = new BigDecimal(0);

		List<PurchaseItem> purchaseItems = purchaseItemRepository.findByOrderNum(orderNum);

		BigDecimal totalPrice = billingService.getTotalPrice(orderNum);

		Integer percentage = calculateServiceChargePercentage(purchaseItems);

		if (percentage != null) {
			serviceChargeValue = totalPrice.multiply(new BigDecimal(percentage)).divide(BigDecimal.valueOf(100));
		}

		return serviceChargeValue.setScale(2, BigDecimal.ROUND_HALF_UP);
	}


	/**
	 * @param purchaseItems
	 * @return service charge percentage.
	 */
	private Integer calculateServiceChargePercentage(List<PurchaseItem> purchaseItems) {
		Integer serviceChargePercentage = null;
		for (PurchaseItem purchaseItem : purchaseItems) {
			CafeItem cafeItem = cafeItemRepository.findByName(purchaseItem.getName());
			if (cafeItem.getType().name().equals(ServiceChargeEnum.HOTFOOD.name())) {
				return ServiceChargeEnum.HOTFOOD.getServiceCharge();
			} else if (cafeItem.getType().name().equals(ServiceChargeEnum.COLDFOOD.name())) {
				serviceChargePercentage = ServiceChargeEnum.COLDFOOD.getServiceCharge();
			}

		}
		return serviceChargePercentage;

	}
}
