package com.app.payment.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.payment.model.Shop;
import com.app.payment.repository.ShopRepository;

@Service
public class ShopDAO {
	
	@Autowired
	ShopRepository shopRepository;
	
	/*to save a shop*/
	
	public Shop save(Shop emp) {
		return shopRepository.save(emp);
	}
	
	
	/* search all shops*/
	
	public List<Shop> findAll(){
		return shopRepository.findAll();
	}
	
	
	/*get a shop by id*/
	public Shop findOne(Long shopId) {
		return shopRepository.findById(shopId).orElse(null);
	}
	
	
	/*delete a shop*/
	
	public void delete(Shop shop) {
		shopRepository.delete(shop);
	}
	

}
