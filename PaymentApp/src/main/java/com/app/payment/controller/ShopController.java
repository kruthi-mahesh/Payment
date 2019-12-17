package com.app.payment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.payment.model.Shop;
import com.app.payment.service.ShopService;

@RequestMapping("shop")
@RestController
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	@PostMapping("/save")
	public Shop save(@RequestBody Shop shop) {
		return shopService.saveShop(shop);
	}
	
	@PutMapping("/update")
	public Shop update(@RequestBody Shop shop) {
		return shopService.updateShop(shop);
	}
	
	@GetMapping("/all")
	public List<Shop> getAllShop() {
		return shopService.getAllShopList();
	}
	
	@GetMapping("/by/{shopId}")
	public Optional<Shop> getShop(@PathVariable(name = "shopId")Integer shopId) {
		return shopService.getShop(shopId);
	}
	
	@DeleteMapping("/delete/{shopId}")
	public void deleteShop(@PathVariable(name = "shopId") Integer shopId) {
		shopService.deleteShop(shopId);
	}

}
