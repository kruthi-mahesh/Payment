package com.app.payment.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.*;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = "shopCustomers")
@Entity
@Table(name="customers")
@EntityListeners(AuditingEntityListener.class)

public class Customer implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	@NotNull
	@Size(min = 3, max = 50)
	private String name;
	@Column(name = "email", unique=true)
	@NotNull
	@Size(min = 5, max = 30)
	private String email;
	
	@OneToMany(mappedBy = "customer", 
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	@JsonIgnoreProperties("customer")
	private Set<ShopCustomer> shopCustomers = new HashSet<>();

	public Customer(@NotNull @Size(min = 3, max = 50) String name, 
			@NotNull @Size(min = 5, max = 30) String email) {
		super();
		this.name = name;
		this.email = email;
		
	}

	@Override
	public String toString() {
		return "Customer {" + "id = " + id + "name = " + name + "email = " + email + "}";
	}
	
}
