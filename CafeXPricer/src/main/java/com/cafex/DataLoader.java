package com.cafex;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.cafex.model.CafeItem;
import com.cafex.model.ItemType;
import com.cafex.repositories.CafeItemRepository;



/**
 * Loads data required by {@link DemoRunner}.
 *
 * Data only loaded if "demo" is one of the active profiles.
 *
 * 
 */
@Component
@Profile("demo")
@Order(value = 1)
public class DataLoader {
  private static final Logger LOG = LoggerFactory.getLogger(DataLoader.class);
  private CafeItemRepository cafeItemRepository;

 

  
  public DataLoader(CafeItemRepository productRepository) {
    this.cafeItemRepository = productRepository;
  }

  @PostConstruct
  public void init() {
    LOG.info("Inserting Cafe items");
    List<CafeItem> cafeItems = new ArrayList<>();
    
    

    /*** create cafeItems ***/
    cafeItems.add(new CafeItem("Cola",BigDecimal.valueOf(0.50).setScale(2, BigDecimal.ROUND_HALF_UP), ItemType.DRINK));
    cafeItems.add(new CafeItem("Coffee",BigDecimal.valueOf(1.00).setScale(2, BigDecimal.ROUND_HALF_UP), ItemType.DRINK));
    cafeItems.add(new CafeItem("Cheese Sandwich",BigDecimal.valueOf(2.00).setScale(2, BigDecimal.ROUND_HALF_UP), ItemType.COLDFOOD));
    cafeItems.add(new CafeItem("Steak Sandwich",BigDecimal.valueOf(4.50).setScale(2, BigDecimal.ROUND_HALF_UP), ItemType.HOTFOOD));
	

	cafeItemRepository.save(cafeItems);
    
    
    LOG.info("Inserted Cafe items");
  }

}
