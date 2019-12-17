package com.app.payment.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import lombok.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter

@Data
@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
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
	
	@OneToMany(fetch = FetchType.LAZY,
			mappedBy = "customer", 
			cascade = CascadeType.ALL)
	private Set<ShopCustomer> shopCustomers = new HashSet<>();

	public Customer(@NotNull String name, @NotNull String email, @NotNull String password, @NotNull String phone) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}
}
