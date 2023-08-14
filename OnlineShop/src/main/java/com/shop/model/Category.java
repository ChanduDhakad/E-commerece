package com.shop.model;

import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryID;

	private String name;
//
//	@OneToMany
//	private SubCategory subCategory;

}
