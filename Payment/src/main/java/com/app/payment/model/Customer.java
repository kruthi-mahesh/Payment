package com.app.payment.model;

import javax.persistence.*;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;

@Getter
@Setter
@Entity
@Table(name="customers")
@EntityListeners(AuditingEntityListener.class)

public class Customer {
	
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
	
}
