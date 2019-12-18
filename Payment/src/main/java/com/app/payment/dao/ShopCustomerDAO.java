package com.app.payment.dao;

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
	
	
	public ShopCustomer save(ShopCustomer shopCustomer) {
		return shopCustomerRepository.save(shopCustomer);
	}
	
	public Page<ShopCustomer> findAll(Pageable pageable){
		return shopCustomerRepository.findAll(pageable);
	}
	
	public void delete(ShopCustomer shopCustomer) {
		shopCustomerRepository.delete(shopCustomer);
	}
	
	public ShopCustomer findOneById(Long id) {
		return shopCustomerRepository.findById(id).orElse(null);
	}
	
	public Page<ShopCustomer> findByShopId(Long shopId, Pageable pageable) {
		return shopCustomerRepository.findByShopId(shopId, pageable);
	}
	
	public Page<ShopCustomer> findByCustomerId(Long customerId, Pageable pageable) {
		return shopCustomerRepository.findByCustomerId(customerId, pageable);
	}
	
	public ShopCustomer findByIdAndShopId(Long id, Long shopId) {
		return shopCustomerRepository.findByIdAndShopId(id, shopId).orElse(null);
	}
	
	public ShopCustomer findByIdAndCustomerId(Long id, Long customrId) {
		return shopCustomerRepository.findByIdAndCustomerId(id, customrId).orElse(null);
	}
	
	public ShopCustomer findByShopIdAndCustomerId(Long shopId, Long customerId) {
		return shopCustomerRepository.findByShopIdAndCustomerId(shopId, customerId).orElse(null);
	}
}
