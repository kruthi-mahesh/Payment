package com.app.payment.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.payment.dao.CustomerDAO;
import com.app.payment.model.Customer;

@RestController
@RequestMapping("/payment")
public class CustomerController {
	
	@Autowired
	CustomerDAO customerDAO;

	@PostMapping("/customers")
	public Customer createCustomer(@Valid @RequestBody Customer cust) {
		return customerDAO.save(cust);
	}
	
	@GetMapping("/customers")
	public Page<Customer> getAllCustomers(Pageable pageable){
		return customerDAO.findAll(pageable);
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value="id") Long custId){
		
		Customer cust=customerDAO.findOne(custId);
		
		if(cust==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(cust);
		
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value="id") Long custId,@Valid @RequestBody Customer custDetails){
		
		Customer cust=customerDAO.findOne(custId);
		if(cust==null) {
			return ResponseEntity.notFound().build();
		}
		
		cust.setName(custDetails.getName());
		cust.setEmail(custDetails.getEmail());
		
		Customer updateCustomer=customerDAO.save(cust);
		return ResponseEntity.ok().body(updateCustomer);		
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable(value="id") Long custId){
		
		Customer cust=customerDAO.findOne(custId);
		if(cust==null) {
			return ResponseEntity.notFound().build();
		}
		customerDAO.delete(cust);
		
		return ResponseEntity.ok().build();
		
		
	}

}
