package com.supinfo.supcommerce.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity//it is used to declare a class as a ¡°JPA Entity¡±
@Table(name="categories")//define the name of  the table to which the class is mapped 
public class Category implements Serializable{//Serializable is an interface

	private static final long serialVersionUID = 1L;
	@Id//set on the property or on the getter representing the primary key within the database
	@GeneratedValue(strategy=GenerationType.AUTO)//to define how to generate the key with the annotation 
	private Long id;
	private String name;
	@OneToMany
	private List<Product> product;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
}
