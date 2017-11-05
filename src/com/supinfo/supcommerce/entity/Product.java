package com.supinfo.supcommerce.entity;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity//it is used to declare a class as a ¡°JPA Entity¡±
@Table(name="products")//define the name of  the table to which the class is mapped 
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
//Serializable is an interface

	@Id//set on the property or on the getter representing the primary key within the database
	@GeneratedValue(strategy=GenerationType.AUTO)//to define how to generate the key with the annotation 
	private Long id;
	private String name;
	private String content;
	private float price;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="category_fk")
	private Category category;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
