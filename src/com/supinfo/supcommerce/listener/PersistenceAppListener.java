package com.supinfo.supcommerce.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.supinfo.supcommerce.util.PersistenceManager;

@WebListener
public class PersistenceAppListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
        PersistenceManager.closeEntityManagerFactory();		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
	
	}

}
