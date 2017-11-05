package com.supinfo.supcommerce.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class PersistenceManager {
	
	private static EntityManagerFactory myEntityManagerFactory;
	
    public static EntityManagerFactory retrieveEntityManagerFactory(){
    	myEntityManagerFactory = Persistence.createEntityManagerFactory("supcommerce-PU");
		return myEntityManagerFactory;
    	
    }
    public static void closeEntityManagerFactory(){
    	myEntityManagerFactory.close();
    }
    
}
