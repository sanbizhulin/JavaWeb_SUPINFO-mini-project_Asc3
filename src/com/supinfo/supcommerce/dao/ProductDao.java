package com.supinfo.supcommerce.dao;

import java.util.List;

import com.supinfo.supcommerce.entity.Category;
import com.supinfo.supcommerce.entity.Product;

public interface ProductDao {

    public Product addProduct(Product product);	
    
    public Product retrieveProductById(Long id);	

    public List<Product> retrieveAllProducts();
    
    public void removeProduct(Long id);
	
    public List<Product> retrieveProductsUnder(float price);

    public List<Product> retrieveProductsByCategory(Category category);

    
}
