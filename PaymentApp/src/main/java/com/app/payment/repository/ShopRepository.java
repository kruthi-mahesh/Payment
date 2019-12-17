package com.app.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.payment.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Integer>{
}
