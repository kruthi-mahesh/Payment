package com.app.payment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.payment.model.*;
import com.app.payment.dao.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/payment")
public class ShopCustomerController {

	@Autowired
	private ShopCustomerDAO shopCustomerDAO;
	
	@Autowired
	private ShopDAO shopDAO;
    
    
    @PostMapping("/shops/{shopId}/customers")
    public ResponseEntity<ShopCustomer> createShopCustomer(@PathVariable (value = "shopId") Long shopId,
                                 @Valid @RequestBody ShopCustomer shopCustomer) {
    	
    	Shop shop = shopDAO.findOne(shopId);
    	
    	if(shop==null) {
			return ResponseEntity.notFound().build();
		}
    	
    	shopCustomer.setShop(shop);
    	return ResponseEntity.ok().body(shopCustomerDAO.save(shopCustomer));
  
    }

    @GetMapping("/shops/{shopId}/customers")
    public Page<ShopCustomer> getAllShopCustomersByShopId(@PathVariable (value = "shopId") Long shopId, 
    													Pageable pageable) {
        return shopCustomerDAO.findByShopId(shopId, pageable);
    }
    
    @GetMapping("/shops/{shopId}/customers/{shopCustomerId}")
    public ShopCustomer getShopCustomerByIdAndShopId(@PathVariable (value = "shopId") Long shopId, 
    		@PathVariable (value = "shopCustomerId") Long shopCustomerId) {
        return shopCustomerDAO.findByIdAndShopId(shopCustomerId, shopId);
    }
    
    @PutMapping("/shops/{shopId}/customers/{shopCustomerId}")
    public ResponseEntity<ShopCustomer> updateShopCustomer(@PathVariable (value = "shopId") Long shopId,
                                 @PathVariable (value = "shopCustomerId") Long shopCustomerId,
                                 @Valid @RequestBody ShopCustomer shopCustomerDetails) {
        
    	Shop shop = shopDAO.findOne(shopId);
    	ShopCustomer shopCustomer = shopCustomerDAO.findOne(shopCustomerId);
    	
    	if(shop == null || shopCustomer == null) {
			return ResponseEntity.notFound().build();
		}
    	
    	shopCustomer.setBalance(shopCustomerDetails.getBalance());
    	shopCustomer.setShop(shop);
    	
    	ShopCustomer updatedShopCustomer = shopCustomerDAO.save(shopCustomer);
		return ResponseEntity.ok().body(updatedShopCustomer);	
    
    }

    @DeleteMapping("/shops/{shopId}/comments/{shopCustomerId}")
    public ResponseEntity<?> deleteShopCustomer(@PathVariable (value = "shopId") Long shopId,
                              @PathVariable (value = "shopCustomerId") Long shopCustomerId) {
        
    	Shop shop=shopDAO.findOne(shopId);
    	ShopCustomer shopCustomer=shopCustomerDAO.findOne(shopCustomerId);
		if(shop == null || shopCustomer == null) {
			return ResponseEntity.notFound().build();
		}
    	
		shopCustomerDAO.delete(shopCustomer);
		
		return ResponseEntity.ok().build();
		
	}
}
