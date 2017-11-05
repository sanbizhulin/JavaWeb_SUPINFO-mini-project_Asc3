package com.supinfo.supcommerce.servlet;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.supinfo.sun.supcommerce.bo.SupProduct;
//import com.supinfo.sun.supcommerce.doa.SupProductDao;
import com.supinfo.supcommerce.entity.Product;

@WebServlet(urlPatterns="/showProduct")
public class ShowProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Product product = em.find(Product.class, Long.parseLong(id));
		em.getTransaction().commit();
		em.close();
		emf.close();
		req.setAttribute("product", product);
		req.getRequestDispatcher("/jsp/showProduct.jsp").forward(req, resp);
		
	}

}
