package com.app.payment.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.payment.model.Customer;
import com.app.payment.repository.CustomerRepository;

@Service
public class CustomerDAO {
	
	@Autowired
	CustomerRepository customerRepository;
	
	/*to save an customer*/
	
	public Customer save(Customer emp) {
		return customerRepository.save(emp);
	}
	
	
	/* search all customers*/
	
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	
	
	/*get an customer by id*/
	public Customer findOne(Long empid) {
		return customerRepository.findById(empid).orElse(null);
	}
	
	
	/*delete an customer*/
	
	public void delete(Customer emp) {
		customerRepository.delete(emp);
	}
	

}
