package com.supinfo.supcommerce.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.supinfo.supcommerce.dao.CategoryDao;
import com.supinfo.supcommerce.entity.Category;

public class JpaCategoryDao implements CategoryDao{

	private EntityManagerFactory myEntityManagerFactory;
	
	public JpaCategoryDao(EntityManagerFactory entityManagerFactory){
        this.myEntityManagerFactory = entityManagerFactory;
	}
	
	@Override
	public Category addCategory(Category category) {
        EntityManager em = this.myEntityManagerFactory.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try{
        	t.begin();
        	em.persist(category);
        	t.commit();
        }catch(Exception e){
        	t.rollback();
        	System.out.println("something went wrong");
        }finally{
        	em.close();
        }
		return category;
	}

	@Override
	public Category retrieveCategoryById(Long id) {
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
		Category category;
		Query query = em.createQuery("SELECT c FROM Category AS c LEFT JOIN FETCH c.products WHERE c.id = :id");
		query.setParameter("id", id);
		category = (Category) query.getSingleResult();
		em.close();
		return category;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> retrieveAllCategories() {
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
		Query query = em.createQuery("SELECT c from Category as c");
        List<Category> categories = query.getResultList();
		return categories;
	}

	@Override
	public void removeCategory(Long id) {
		 EntityManager em = myEntityManagerFactory.createEntityManager();
	     EntityTransaction t = em.getTransaction();
	     try{
	      	t.begin();
	      	Category category = em.find(Category.class,id );
	        em.remove(category) ;
	        t.commit();
	     }catch(Exception e){
	      	t.rollback();
	     }finally{
	        em.close();
	     }		
	}

	@Override
	public void updateCategory(Category category) {
		 EntityManager em = myEntityManagerFactory.createEntityManager();
	     EntityTransaction t = em.getTransaction();
	     try{
	      	t.begin();
	        em.merge(category) ;
	        t.commit();
	     }catch(Exception e){
	      	t.rollback();
	     }finally{
	        em.close();
	     }			
	}
}
