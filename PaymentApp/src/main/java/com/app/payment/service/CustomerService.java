package com.app.payment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.payment.model.Customer;

@Service
public interface CustomerService {

	Customer saveCustomer(Customer shop);
	
	List<Customer> saveAllCustomers(List<Customer> customers);
	
	Customer updateCustomer(Customer shop);
	
	List<Customer> getAllCustomerList();
	
	Optional<Customer> getCustomer(Integer customerId);
	
	void deleteCustomer(Integer customerId);
	

}
