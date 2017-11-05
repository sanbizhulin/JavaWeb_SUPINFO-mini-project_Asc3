package com.supinfo.supcommerce.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.supinfo.supcommerce.dao.ProductDao;
import com.supinfo.supcommerce.entity.Category;
import com.supinfo.supcommerce.entity.Product;

public class JpaProductDao implements ProductDao{

	private EntityManagerFactory myEntityManagerFactory;
	
	public JpaProductDao(EntityManagerFactory entityManagerFactory){
        this.myEntityManagerFactory = entityManagerFactory;
	}
	
	
	@Override
	public Product addProduct(Product product) {
        EntityManager em = this.myEntityManagerFactory.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try{
        	t.begin();
        	em.persist(product);
        	t.commit();
        }catch(Exception e){
        	t.rollback();
        	System.out.println("something went wrong");
        }finally{
        	em.close();
        }
		return product;
	}

	@Override
	public Product retrieveProductById(Long id) {
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
		Product product;
		product = em.find(Product.class, id);
		em.close();
		return product;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> retrieveAllProducts() {
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
		Query query = em.createQuery("SELECT p from Product as p");
        List<Product> products = query.getResultList();
		return products;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> retrieveProductsByCategory(Category category) {
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
		Query query = em.createQuery("SELECT p from Product as p WHERE p.category = :category");
		query.setParameter("category", category);

        List<Product> products = query.getResultList();
		return products;
	}
	

	@Override
	public void removeProduct(Long id) {
		 EntityManager em = myEntityManagerFactory.createEntityManager();
	     EntityTransaction t = em.getTransaction();
	     try{
	      	t.begin();
	       	Product product = em.find(Product.class,id );
	        em.remove(product) ;
	        t.commit();
	     }catch(Exception e){
	      	t.rollback();
	     }finally{
	        em.close();
	     }		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Product> retrieveProductsUnder(float price) {
        EntityManager em = myEntityManagerFactory.createEntityManager();
        List<Product> products;
        try{
            Query query = em.createQuery("SELECT p FROM Product as p where p.price < :price");
            query.setParameter("price", price);
            products =  query.getResultList();
	    }catch( Exception e){
	    	products = null;
    	}finally{
    		em.close();
    	}
        return products;
	}

}
