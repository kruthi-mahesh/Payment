package com.app.payment.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.payment.model.*;
import com.app.payment.dao.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
@RequestMapping("/payment")
public class ShopCustomerController {

	@Autowired
	private ShopCustomerDAO shopCustomerDAO;
	
	@Autowired
	private ShopDAO shopDAO;
	
	@Autowired
	private CustomerDAO customerDAO;
    
    
    @PostMapping("/shops/{shop_id}/customers/{customer_id}")
    public ResponseEntity<ShopCustomer> addShopCustomer(@PathVariable (value = "shop_id") Long shopId, 
    		@PathVariable (value = "customer_id") Long customerId,
            @Valid @RequestBody ShopCustomer shopCustomer) {
    	
    	Shop shop = shopDAO.findOne(shopId);
    	Customer customer = customerDAO.findOne(customerId);
    	ShopCustomer existingShopCustomer = shopCustomerDAO.findByShopIdAndCustomerId(shopId, customerId);
    	if(shop==null || customer == null || existingShopCustomer != null) {
			return ResponseEntity.notFound().build();
		}
    	
    	shopCustomer.setShop(shop);
    	shopCustomer.setCustomer(customer);
    	return ResponseEntity.ok().body(shopCustomerDAO.save(shopCustomer));
  
    }
    
    @PostMapping("/customers/{customer_id}/shops/{shop_id}")
    public ResponseEntity<ShopCustomer> addShop(@PathVariable (value = "shop_id") Long shopId, 
    		@PathVariable (value = "customer_id") Long customerId,
            @Valid @RequestBody Optional<ShopCustomer> shopCustomerDetails) {
    	
    	Shop shop = shopDAO.findOne(shopId);
    	Customer customer = customerDAO.findOne(customerId);
    	ShopCustomer existingShopCustomer = shopCustomerDAO.findByShopIdAndCustomerId(shopId, customerId);
    	if(shop==null || customer == null || existingShopCustomer != null) {
			return ResponseEntity.notFound().build();
		}
    	
    	ShopCustomer shopCustomer = shopCustomerDetails.orElse(new ShopCustomer());
    	shopCustomer.setShop(shop);
    	shopCustomer.setCustomer(customer);
    	shopCustomer.setBalance(0);
    	return ResponseEntity.ok().body(shopCustomerDAO.save(shopCustomer));
  
    }
    
    @GetMapping("/shops/{shop_id}/customers")
    public Page<ShopCustomer> getAllShopCustomersByShopId(@PathVariable (value = "shop_id") Long shopId, 
    		Pageable pageable) {
    	return shopCustomerDAO.findByShopId(shopId, pageable);
	}
    
    @GetMapping("/customers/{customer_id}/shops")
    public Page<ShopCustomer> getAllShopCustomersByCustomerId(@PathVariable (value = "customer_id") Long customerId, 
    		Pageable pageable) {
    	return shopCustomerDAO.findByCustomerId(customerId, pageable);
	}
    
    @GetMapping("/shops/{shop_id}/customers/by/{shop_customer_id}")
    public ShopCustomer getShopCustomerByIdAndShopId(
    		@PathVariable (value = "shop_customer_id") Long id,
    		@PathVariable (value = "shop_id") Long shopId, 
    		Pageable pageable) {
    	return shopCustomerDAO.findByIdAndShopId(id,shopId);
	}
    
    @GetMapping("/customers/{customer_id}/shops/by/{shop_customer_id}")
    public ShopCustomer getShopCustomerByIdAndCustomerId(
    		@PathVariable (value = "shop_customer_id") Long id,
    		@PathVariable (value = "customer_id") Long customerId, 
    		Pageable pageable) {
    	return shopCustomerDAO.findByIdAndCustomerId(id,customerId);
	}
    
    @GetMapping({"/shops/{shop_id}/customers/{customer_id}","/customers/{customer_id}/shops/{shop_id}"})
    public ShopCustomer getShopCustomerByShopIdAndCustomerId(@PathVariable (value = "shop_id") Long shopId, 
    		@PathVariable (value = "customer_id") Long customerId) {
        return shopCustomerDAO.findByShopIdAndCustomerId(shopId, customerId);
    }
    
    @PutMapping("/shops/{shop_id}/customers/{customer_id}")
    public ResponseEntity<ShopCustomer> updateShopCustomerByCustomerId(@PathVariable (value = "shop_id") Long shopId,
                                 @PathVariable (value = "customer_id") Long customerId,
                                 @Valid @RequestBody ShopCustomer shopCustomerDetails) {
        
    	ShopCustomer shopCustomer = shopCustomerDAO.findByShopIdAndCustomerId(shopId, customerId);
    	
    	if(shopCustomer == null) {
			return ResponseEntity.notFound().build();
		}
    	
    	shopCustomer.setBalance(shopCustomerDetails.getBalance());
    	
    	ShopCustomer updatedShopCustomer = shopCustomerDAO.save(shopCustomer);
		return ResponseEntity.ok().body(updatedShopCustomer);	
    
    }
    
    @PutMapping("/shops/{shop_id}/customers/by/{shop_customer_id}")
    public ResponseEntity<ShopCustomer> updateShopCustomerById(@PathVariable (value = "shop_id") Long shopId,
                                 @PathVariable (value = "shop_customer_id") Long id,
                                 @Valid @RequestBody ShopCustomer shopCustomerDetails) {
        
    	ShopCustomer shopCustomer = shopCustomerDAO.findByIdAndShopId(id, shopId);
    	
    	if(shopCustomer == null) {
			return ResponseEntity.notFound().build();
		}
    	
    	shopCustomer.setBalance(shopCustomerDetails.getBalance());
    	
    	ShopCustomer updatedShopCustomer = shopCustomerDAO.save(shopCustomer);
		return ResponseEntity.ok().body(updatedShopCustomer);	
    
    }

    @DeleteMapping({"/shops/{shop_id}/customers/{customer_id}", "/customers/{customer_id}/shops/{shop_id}"})
    public ResponseEntity<?> deleteShopCustomerByCustomerId(@PathVariable (value = "shop_id") Long shopId,
                              @PathVariable (value = "customer_id") Long customerId) {
        
    	ShopCustomer shopCustomer = shopCustomerDAO.findByShopIdAndCustomerId(shopId, customerId);
		if(shopCustomer == null) {
			return ResponseEntity.notFound().build();
		}

		shopCustomerDAO.delete(shopCustomer);
		
		return ResponseEntity.ok().build();
		
	}
    
    @DeleteMapping("/shops/{shop_id}/customers/by/{shop_customer_id}")
    public ResponseEntity<?> deleteShopCustomerByIdAndShopId(@PathVariable (value = "shop_id") Long shopId,
                              @PathVariable (value = "shop_customer_id") Long id) {
        
    	ShopCustomer shopCustomer = shopCustomerDAO.findByIdAndShopId(id, shopId);
		if(shopCustomer == null) {
			return ResponseEntity.notFound().build();
		}

		shopCustomerDAO.delete(shopCustomer);
		
		return ResponseEntity.ok().build();
		
	}
    
    @DeleteMapping("/customers/{customer_id}/shops/by/{shop_customer_id}")
    public ResponseEntity<?> deleteShopCustomerByIdAndCustomerId(@PathVariable (value = "customer_id") Long customerId,
                              @PathVariable (value = "shop_customer_id") Long id) {
        
    	ShopCustomer shopCustomer = shopCustomerDAO.findByIdAndCustomerId(id, customerId);
		if(shopCustomer == null) {
			return ResponseEntity.notFound().build();
		}

		shopCustomerDAO.delete(shopCustomer);
		
		return ResponseEntity.ok().build();
		
	}
    
    @GetMapping("/shop_customers/{shop_customer_id}/shop")
    public ResponseEntity<?> findShopByShopCustomerId(
    		@PathVariable(value = "shop_customer_id") Long id) {
		ShopCustomer shopCustomer =  shopCustomerDAO.findOneById(id);
		if (shopCustomer == null) {
			return ResponseEntity.notFound().build();
		}
		Shop shop = shopCustomer.getShop();
		if (shop == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(shop);
    }
    
    @GetMapping("/shop_customers/{shop_customer_id}/customer")
    public ResponseEntity<?> getCustomerByShopCustomerId(
    		@PathVariable(value = "shop_customer_id") Long id) {
    	
    	ShopCustomer shopCustomer =  shopCustomerDAO.findOneById(id);
		if(shopCustomer == null) {
			return ResponseEntity.notFound().build();
		}
		Customer customer = shopCustomer.getCustomer();
		if(customer == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(customer);
    }
}
