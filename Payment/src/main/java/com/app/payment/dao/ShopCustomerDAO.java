package com.app.payment.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.payment.model.ShopCustomer;
import com.app.payment.repository.ShopCustomerRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ShopCustomerDAO {

	@Autowired
	ShopCustomerRepository shopCustomerRepository;
	
	
	public ShopCustomer save(ShopCustomer emp) {
		return shopCustomerRepository.save(emp);
	}
	
	
	public List<ShopCustomer> findAll(Pageable pageable){
		return shopCustomerRepository.findAll();
	}
	
	public ShopCustomer findOne(Long shopCustomerId) {
		return shopCustomerRepository.findById(shopCustomerId).orElse(null);
	}
	
	public void delete(ShopCustomer shopCustomer) {
		shopCustomerRepository.delete(shopCustomer);
	}
	
	public Page<ShopCustomer> findByShopId(Long shopId, Pageable pageable) {
		return shopCustomerRepository.findByShopId(shopId, pageable);
	}
	
	public ShopCustomer findByIdAndShopId(Long id, Long shopId) {
		return shopCustomerRepository.findByIdAndShopId(id, shopId).orElse(null);
	}
}
