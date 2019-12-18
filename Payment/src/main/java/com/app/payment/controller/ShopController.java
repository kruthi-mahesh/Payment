package com.app.payment.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.payment.dao.*;
import com.app.payment.model.Shop;

@RestController
@RequestMapping("/payment")
public class ShopController {
	
	@Autowired
	ShopDAO shopDAO;
	
	@Autowired
	ShopCustomerDAO shopCustomerDAO;

	@PostMapping("/shops")
	public Shop createShop(@Valid @RequestBody Shop shop) {
		return shopDAO.save(shop);
	}
	
	@GetMapping("/shops")
	public Page<Shop> getAllShops(Pageable pageable){
		return shopDAO.findAll(pageable);
	}
	
	@GetMapping("/shops/{id}")
	public ResponseEntity<Shop> getShopById(@PathVariable(value="id") Long shopId){
		
		Shop shop=shopDAO.findOne(shopId);
		
		if(shop == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(shop);
		
	}
	
	@PutMapping("/shops/{id}")
	public ResponseEntity<Shop> updateShop(@PathVariable(value="id") Long shopId,@Valid @RequestBody Shop shopDetails){
		
		Shop shop = shopDAO.findOne(shopId);
		if(shop == null) {
			return ResponseEntity.notFound().build();
		}
		
		shop.setName(shopDetails.getName());
		shop.setEmail(shopDetails.getEmail());
		
		Shop updatedShop = shopDAO.save(shop);
		return ResponseEntity.ok().body(updatedShop);		
	}
	
	@DeleteMapping("/shops/{id}")
	public ResponseEntity<Shop> deleteShop(@PathVariable(value="id") Long shopId){
		
		Shop shop=shopDAO.findOne(shopId);
		if(shop == null) {
			return ResponseEntity.notFound().build();
		}
		shopDAO.delete(shop);
		
		return ResponseEntity.ok().build();
		
		
	}

}
