package com.cafex;

import java.math.BigDecimal;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cafex.services.BillingService;
import com.cafex.services.PurchaseItemService;
import com.cafex.services.ServiceChargeService;

/**
 * Application with start point.
 */

@SpringBootApplication
public class AppRunner {

	@Autowired
	private PurchaseItemService purchageItemService;

	@Autowired
	private BillingService billingService;

	@Autowired
	private ServiceChargeService serviceChargeService;

	private static final Logger LOG = LoggerFactory.getLogger(AppRunner.class);

	/**
	 * AppRunner of Main method.
	 */
	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(AppRunner.class, args);
		AppRunner appRunner = ctx.getBean(AppRunner.class);
		appRunner.start(args);
	}

	private void start(String[] args) {

		Long orderNum = purchageItemService.buildOrder(Arrays.asList(args));
		LOG.info("======== Summary of Cafe service Price information start =========" + orderNum);

		// Compute the total price for the selected cafe items.
		BigDecimal totalPrice = billingService.getTotalPrice(orderNum);

		// printout total price
		StringBuilder subTotalOutput = new StringBuilder();
		subTotalOutput.append("Total bill : ");
		subTotalOutput.append(totalPrice);

		System.out.println(subTotalOutput.toString());
		
		StringBuilder serviceChargeSB = new StringBuilder();
		serviceChargeSB.append("Service charge on the bill : ");

		// Compute service charge
		BigDecimal serviceChargeValue = serviceChargeService.calulateServiceCharge(orderNum);

		serviceChargeSB.append(serviceChargeValue);

		System.out.println(serviceChargeSB.toString());
		
		LOG.info("======== Summary of Cafe Price information end =========");

	}

}
