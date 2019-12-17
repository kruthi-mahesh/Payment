package com.app.payment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.payment.model.Shop;

@Service
public interface ShopService {

	Shop saveShop(Shop shop);
	
	Shop updateShop(Shop shop);
	
	List<Shop> getAllShopList();
	
	Optional<Shop> getShop(Integer shopId);
	
	void deleteShop(Integer shopId);
	

}
