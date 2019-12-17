package com.app.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.payment.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
