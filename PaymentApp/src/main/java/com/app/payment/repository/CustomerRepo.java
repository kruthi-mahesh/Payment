package com.app.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.payment.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
