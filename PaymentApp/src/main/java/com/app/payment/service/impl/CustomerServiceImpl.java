package com.app.payment.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.payment.dao.CustomerDao;
import com.app.payment.model.Customer;
import com.app.payment.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.save(customer);
	}
	
	@Override
	public List<Customer> saveAllCustomers(List<Customer> customers) {
		return customerDao.saveAll(customers);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.saveAndFlush(customer);
	}

	@Override
	public List<Customer> getAllCustomerList() {
		// TODO Auto-generated method stub
		return customerDao.findAll();
	}

	@Override
	public Optional<Customer> getCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		return customerDao.findById(customerId);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		customerDao.deleteById(customerId);
	}

}
