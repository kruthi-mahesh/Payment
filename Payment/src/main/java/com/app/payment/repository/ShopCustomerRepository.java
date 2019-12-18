package com.app.payment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.payment.model.Customer;
import com.app.payment.model.Shop;
import com.app.payment.model.ShopCustomer;

@Repository
public interface ShopCustomerRepository extends JpaRepository<ShopCustomer, Long> {

	Optional<ShopCustomer> findById(Long id);
    Page<ShopCustomer> findByShopId(Long shopId, Pageable pageable);
    Page<ShopCustomer> findByCustomerId(Long customerId, Pageable pageable);
    Optional<ShopCustomer> findByIdAndShopId(Long id, Long shopId);
    Optional<ShopCustomer> findByIdAndCustomerId(Long id, Long customerId);
    Optional<ShopCustomer> findByShopIdAndCustomerId(Long shopId, Long customerId);
}
