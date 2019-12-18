package com.app.payment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.payment.model.ShopCustomer;

@Repository
public interface ShopCustomerRepository extends JpaRepository<ShopCustomer, Long> {

    Page<ShopCustomer> findByShopId(Long shopId, Pageable pageable);
    Optional<ShopCustomer> findByIdAndShopId(Long id, Long shopId);

}
