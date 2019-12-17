package com.app.payment.model;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;

@Getter
@Setter

@Data
@Entity
@Table(name = "shops")
public class Shop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	@NotNull
	@Size(min = 3, max = 50)
	private String name;
	@Column(name = "email", unique=true)
	@NotNull
	@Size(min = 5, max = 30)
	private String email;
	@Column(name = "password")
	@NotNull
	@Size(min = 4, max = 20)
	private String password;
	@Column(name = "phone", unique=true)
	@NotNull
	@Size(min = 10, max = 15)
	private String phone;
	
	@OneToMany(mappedBy = "shop", 
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	private Set<ShopCustomer> shopCustomers;

	public Shop(@NotNull String shopName, @NotNull String email, @NotNull String password, @NotNull String phone,
			ShopCustomer... shopCustomers) {
		super();
		this.name = shopName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		for (ShopCustomer shopCustomer : shopCustomers) 
			shopCustomer.setShop(this);
		this.shopCustomers = Stream.of(shopCustomers).collect(Collectors.toSet());
	}
	
	
}
