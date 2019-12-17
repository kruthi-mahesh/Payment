package com.app.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.payment.model.Shop;

@Repository
public interface ShopDao extends JpaRepository<Shop, Integer> {

}
