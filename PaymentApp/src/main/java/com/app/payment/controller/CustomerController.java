package com.app.payment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.payment.model.Customer;
import com.app.payment.service.CustomerService;

@RequestMapping("customer")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/save")
	public Customer save(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@PutMapping("/update")
	public Customer update(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
	
	@GetMapping("/all")
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomerList();
	}
	
	@GetMapping("/by/{customerId}")
	public Optional<Customer> getCustomer(@PathVariable(name = "customerId")Integer customerId) {
		return customerService.getCustomer(customerId);
	}
	
	@DeleteMapping("/delete/{customerId}")
	public void deleteCustomer(@PathVariable(name = "customerId") Integer customerId) {
		customerService.deleteCustomer(customerId);
	}

}
