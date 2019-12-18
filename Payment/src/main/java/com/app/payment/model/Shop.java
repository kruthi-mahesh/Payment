package com.app.payment.model;

import java.io.Serializable;
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
@Entity
@EqualsAndHashCode(exclude = "shopCustomers")
@Table(name="shops")
@EntityListeners(AuditingEntityListener.class)

public class Shop implements Serializable{
	
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
	
	@OneToMany(mappedBy = "shop",cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties("shop")
	private Set<ShopCustomer> shopCustomers;

	public Shop(@NotNull @Size(min = 3, max = 50) String name, @NotNull @Size(min = 5, max = 30) String email,
			ShopCustomer... shopCustomers) {
		super();
		this.name = name;
		this.email = email;
		
		for (ShopCustomer shopCustomer : shopCustomers) 
			shopCustomer.setShop(this);
		this.shopCustomers = Stream.of(shopCustomers).collect(Collectors.toSet());
	}
}
