package com.app.payment.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="shop_customers")
@EntityListeners(AuditingEntityListener.class)

public class ShopCustomer implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shop_id", nullable = false)
    @JsonIgnore
	private Shop shop;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
	private Customer customer;
    
    private Integer balance;


	public ShopCustomer(Integer balance) {
		super();
		this.balance = balance;
	}
	
	public ShopCustomer(Customer customer, Integer balance) {
		super();
		this.customer = customer;
		this.balance = balance;
	}
	
	public ShopCustomer(Shop shop, Customer customer, Integer balance) {
		super();
		this.shop = shop;
		this.customer = customer;
		this.balance = balance;
	}
    
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ShopCustomer)) return false;
		ShopCustomer that = (ShopCustomer) o;
		return Objects.equals(shop.getName(), that.shop.getName()) && 
				Objects.equals(customer.getName(), that.customer.getName()) && 
				Objects.equals(balance, that.balance);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(shop.getName(), customer.getName(), balance);
	}

    
}
