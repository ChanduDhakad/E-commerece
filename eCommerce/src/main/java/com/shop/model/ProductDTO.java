package com.shop.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productDtoId;

	private Integer seller_ProductId;
	private String ProductDtoName;
	private Integer price;
	private String Category;
	private Integer Quantity;

}