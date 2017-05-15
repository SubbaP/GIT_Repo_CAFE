package com.cafex.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.cafex.model.CafeItem;
import com.cafex.model.ItemType;
import com.cafex.model.PurchaseItem;
import com.cafex.repositories.CafeItemRepository;
import com.cafex.repositories.PurchaseItemRepository;
import com.cafex.services.BillingService;
import com.cafex.services.BillingServiceImpl;

/**
 * Unit tests of BillingServiceTest.
 * 
 * @See BillingService
 */
public class BillingServiceTest {

	final static Logger LOGGER = Logger.getLogger(BillingServiceTest.class);

	PurchaseItemRepository purchaseItemepository;
	CafeItemRepository cafeItemRepository;

	BillingService billingService;


	/*** create cafeItems ***/
	CafeItem cola = new CafeItem("Cola", BigDecimal.valueOf(0.50).setScale(2, BigDecimal.ROUND_HALF_UP), ItemType.DRINK);
	CafeItem coffee = new CafeItem("Coffee", BigDecimal.valueOf(1.00).setScale(2, BigDecimal.ROUND_HALF_UP), ItemType.DRINK);
	CafeItem cheeseSandwich = new CafeItem("Cheese Sandwich", BigDecimal.valueOf(2.00).setScale(2, BigDecimal.ROUND_HALF_UP),ItemType.COLDFOOD);
	CafeItem steakSandwich = new CafeItem("Steak Sandwich", BigDecimal.valueOf(4.50).setScale(2, BigDecimal.ROUND_HALF_UP),	ItemType.HOTFOOD);

	/**
	 * Before each test is run, a new {@link BillingService} is instantiated with mock repositories.
	 */
	@Before
	public void setUp() {
		purchaseItemepository = mock(PurchaseItemRepository.class);
		cafeItemRepository = mock(CafeItemRepository.class);

		billingService = new BillingServiceImpl(purchaseItemepository, cafeItemRepository);

	}

	/**
	 * Tests if {@link BillingService#getTotalPrice(Long)} retrieves totalPrice
	 */
	@Test
	public void testGetTotalPriceColaAndCoffee() {

		Long orderNum = 100L;
		List<PurchaseItem> purchaseItemList = new ArrayList<>();
		purchaseItemList.add(new PurchaseItem(orderNum,"cola"));
		purchaseItemList.add(new PurchaseItem(orderNum,"coffee"));

		when(purchaseItemepository.findByOrderNum(orderNum)).thenReturn(purchaseItemList);
		when(cafeItemRepository.findByName("cola")).thenReturn(cola);
		when(cafeItemRepository.findByName("coffee")).thenReturn(coffee);

		assertEquals(String.valueOf(billingService.getTotalPrice(orderNum)), "1.50");
	}

	/**
	 * Tests if {@link BillingService#getTotalPrice(Long)} retrieves totalPrice
	 */
	@Test
	public void testGetTotalCheeseAndSteak() {

		Long orderNum = 101L;
		List<PurchaseItem> purchaseItemList = new ArrayList<>();
		purchaseItemList.add(new PurchaseItem(orderNum,"Cheese Sandwich"));
		purchaseItemList.add(new PurchaseItem(orderNum,"Steak Sandwich"));

		when(purchaseItemepository.findByOrderNum(orderNum)).thenReturn(purchaseItemList);
		when(cafeItemRepository.findByName("Cheese Sandwich")).thenReturn(cheeseSandwich);
		when(cafeItemRepository.findByName("Steak Sandwich")).thenReturn(steakSandwich);

		assertEquals(String.valueOf(billingService.getTotalPrice(orderNum)), "6.50");
	}
	

	/**
	 * Tests if {@link BillingService#getTotalPrice(Long)} retrieves totalPrice
	 */
	@Test
	public void testGetTotalOfAll() {

		Long orderNum = 101L;
		List<PurchaseItem> purchaseItemList = new ArrayList<>();
		purchaseItemList.add(new PurchaseItem(orderNum,"cola"));
		purchaseItemList.add(new PurchaseItem(orderNum,"coffee"));
		purchaseItemList.add(new PurchaseItem(orderNum,"Cheese Sandwich"));
		purchaseItemList.add(new PurchaseItem(orderNum,"Steak Sandwich"));

		when(purchaseItemepository.findByOrderNum(orderNum)).thenReturn(purchaseItemList);
		when(cafeItemRepository.findByName("Cheese Sandwich")).thenReturn(cheeseSandwich);
		when(cafeItemRepository.findByName("Steak Sandwich")).thenReturn(steakSandwich);
		when(cafeItemRepository.findByName("cola")).thenReturn(cola);
		when(cafeItemRepository.findByName("coffee")).thenReturn(coffee);

		assertEquals(String.valueOf(billingService.getTotalPrice(orderNum)), "8.00");
	}
	
	/**
	 * Tests if {@link BillingService#getTotalPrice(Long)} retrieves totalPrice
	 */
	@Test
	public void testGetTotalOfAllWithWrongValue() {

		Long orderNum = 101L;
		List<PurchaseItem> purchaseItemList = new ArrayList<>();
		purchaseItemList.add(new PurchaseItem(orderNum,"cola"));
		purchaseItemList.add(new PurchaseItem(orderNum,"coffee"));
		purchaseItemList.add(new PurchaseItem(orderNum,"Cheese Sandwich"));
		purchaseItemList.add(new PurchaseItem(orderNum,"Steak Sandwich"));

		when(purchaseItemepository.findByOrderNum(orderNum)).thenReturn(purchaseItemList);
		when(cafeItemRepository.findByName("Cheese Sandwich")).thenReturn(cheeseSandwich);
		when(cafeItemRepository.findByName("Steak Sandwich")).thenReturn(steakSandwich);
		when(cafeItemRepository.findByName("cola")).thenReturn(cola);
		when(cafeItemRepository.findByName("coffee")).thenReturn(coffee);

		assertNotEquals(String.valueOf(billingService.getTotalPrice(orderNum)), "7.00");
	}
	
}
