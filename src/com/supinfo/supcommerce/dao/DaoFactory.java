package com.supinfo.supcommerce.dao;

import com.supinfo.supcommerce.dao.jpa.JpaCategoryDao;
import com.supinfo.supcommerce.dao.jpa.JpaProductDao;
import com.supinfo.supcommerce.util.PersistenceManager;

public class DaoFactory {

	private DaoFactory(){
	}
	
	
	public static ProductDao retrieveProductDao() {
		JpaProductDao productDao = new JpaProductDao(PersistenceManager.retrieveEntityManagerFactory());
	    return productDao;
   }

	public static CategoryDao retrieveCategoryDao() {
		JpaCategoryDao categoryDao = new JpaCategoryDao(PersistenceManager.retrieveEntityManagerFactory());
	    return categoryDao;
   }
	
}
