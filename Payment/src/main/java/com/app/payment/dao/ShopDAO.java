package com.app.payment.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.payment.model.Shop;
import com.app.payment.repository.ShopRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ShopDAO {
	
	@Autowired
	ShopRepository shopRepository;
	
	
	public Shop save(Shop emp) {
		return shopRepository.save(emp);
	}
	
	public Page<Shop> findAll(Pageable pageable){
		return shopRepository.findAll(pageable);
	}
	
	public Shop findOne(Long shopId) {
		return shopRepository.findById(shopId).orElse(null);
	}
	
	public void delete(Shop shop) {
		shopRepository.delete(shop);
	}
	

}
