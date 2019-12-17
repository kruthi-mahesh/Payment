package com.app.payment.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class ShopCustomer implements Serializable{
	
	@Id @ManyToOne @JoinColumn
	private Shop shop;
	
	@Id @ManyToOne @JoinColumn
	private Customer customer;
	
	private Integer currentBalance;
	private Boolean eligibleForDebt;
	private Integer debtThreshold;
	
	public ShopCustomer(Customer customer, Integer currentBalance, Boolean eligibleForDebt, Integer debtThreshold) {
		super();
		this.customer = customer;
		this.currentBalance = currentBalance;
		this.eligibleForDebt = eligibleForDebt;
		this.debtThreshold = debtThreshold;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ShopCustomer)) return false;
		ShopCustomer that = (ShopCustomer) o;
		return Objects.equals(shop.getName(), that.shop.getName()) && 
				Objects.equals(customer.getName(), that.customer.getName()) &&
				Objects.equals(currentBalance, that.currentBalance) &&
				Objects.equals(eligibleForDebt, that.eligibleForDebt) &&
				Objects.equals(debtThreshold, that.debtThreshold);

	}
	
	@Override
	public int hashCode() {
		return Objects.hash(shop.getName(), customer.getName(), currentBalance, eligibleForDebt, debtThreshold);
	}
	
}
