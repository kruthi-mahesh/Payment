package com.app.payment.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.payment.dao.ShopDao;
import com.app.payment.model.Shop;
import com.app.payment.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;
	
	@Override
	public Shop saveShop(Shop shop) {
		// TODO Auto-generated method stub
		return shopDao.save(shop);
	}

	@Override
	public Shop updateShop(Shop shop) {
		// TODO Auto-generated method stub
		return shopDao.saveAndFlush(shop);
	}

	@Override
	public List<Shop> getAllShopList() {
		// TODO Auto-generated method stub
		return shopDao.findAll();
	}

	@Override
	public Optional<Shop> getShop(Integer shopId) {
		// TODO Auto-generated method stub
		return shopDao.findById(shopId);
	}

	@Override
	public void deleteShop(Integer shopId) {
		// TODO Auto-generated method stub
		shopDao.deleteById(shopId);
	}

}
