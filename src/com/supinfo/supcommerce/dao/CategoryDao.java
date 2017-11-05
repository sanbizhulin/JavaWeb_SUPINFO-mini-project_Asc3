package com.supinfo.supcommerce.dao;

import java.util.List;

import com.supinfo.supcommerce.entity.Category;;

public interface CategoryDao {

    public Category addCategory(Category category);	
    
    public Category retrieveCategoryById(Long id);	

    public List<Category> retrieveAllCategories();
    
    public void updateCategory(Category category);
    
    public void removeCategory(Long id);
}
