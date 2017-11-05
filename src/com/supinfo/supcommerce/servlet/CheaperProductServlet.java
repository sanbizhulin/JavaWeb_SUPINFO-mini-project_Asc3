package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcommerce.entity.Product;

@WebServlet(urlPatterns="/cheap")
public class CheaperProductServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction t =em.getTransaction();
		t.begin();
		Query q = em.createQuery("SELECT p FROM Product p WHERE p.price<100");
		List<Product> supProducts =(List<Product>)q.getResultList();
		t.commit();
		em.close();
		emf.close();
		req.setAttribute("products", supProducts);
		req.getRequestDispatcher("/jsp/listProduct.jsp").forward(req, resp);
	}

}
