package com.app.payment.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.payment.model.Customer;
import com.app.payment.repository.CustomerRepository;

@Service
public class CustomerDAO {
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	public Customer save(Customer cust) {
		return customerRepository.save(cust);
	}
	
	public Page<Customer> findAll(Pageable pageable){
		return customerRepository.findAll(pageable);
	}
	
	public Customer findOne(Long cust) {
		return customerRepository.findById(cust).orElse(null);
	}
	
	public void delete(Customer cust) {
		customerRepository.delete(cust);
	}
	

}
