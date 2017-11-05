package com.supinfo.supcommerce.servlet;

import java.io.IOException;
//import java.util.List;
import javax.persistence.EntityManager;//Use Java Persistence API to persist data
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.supcommerce.entity.Category;

@WebServlet(urlPatterns="/auth/addCategory")
public class AddCategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	//final means can't be changed anymore."final" makes a valuable as a const
	private EntityManagerFactory emf;
	private EntityManager em;
	@Override
	public void init() throws ServletException {
		 emf = Persistence.createEntityManagerFactory("persistenceUnit");
	}
	
	@Override
	public void destroy() {
		emf.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Category category = new Category();
		category.setName(req.getParameter("name"));
		em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(category);//persist means saving.
		t.commit();
		em.close();
		resp.sendRedirect(req.getContextPath()+"/listProduct");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.getRequestDispatcher("/auth/addCategory.jsp").forward(req, resp);
	}
}
