package com.app.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.payment.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}