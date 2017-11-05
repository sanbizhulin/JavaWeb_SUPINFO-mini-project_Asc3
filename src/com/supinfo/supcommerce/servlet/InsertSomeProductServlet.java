package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.supinfo.sun.supcommerce.bo.SupProduct;
//import com.supinfo.sun.supcommerce.doa.SupProductDao;
import com.supinfo.supcommerce.entity.Category;
import com.supinfo.supcommerce.entity.Product;


@WebServlet(urlPatterns="/auth/basicInsert")
public class InsertSomeProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private EntityManagerFactory emf ;
	private EntityManager em  ;
    public InsertSomeProductServlet() {
        super();
        
    }
    
    @SuppressWarnings("unchecked")
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException 
    //doGet function is used for dealing with HTTP GET request
    {
    	emf = Persistence.createEntityManagerFactory("persistenceUnit");
    	em  = emf.createEntityManager();
    	em.getTransaction().begin();
		List<Category> categories =(List<Category>)em.createQuery( "SELECT c FROM Category c").getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		req.setAttribute("categories", categories);
    	req.getRequestDispatcher("/auth/addProduct.jsp").forward(req, resp);
    }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	//doPost function is used for dealing with HTTP Post request
	//that means if in <form> you define a certain attribute of method as "post", it will call this function to deal with the request.		
	{
		emf = Persistence.createEntityManagerFactory("persistenceUnit");
    	em  = emf.createEntityManager();
		Product product = new Product();
		product.setName(req.getParameter("name").toString());
		product.setContent(req.getParameter("content").toString());
		product.setPrice(Float.parseFloat(req.getParameter("price").toString()));
		Category category = em.find(Category.class, Long.parseLong(req.getParameter("category")));
		product.setCategory(category);
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(product);
		t.commit();
		em.close();
		emf.close();
		req.setAttribute("product", product);
		req.getRequestDispatcher("/jsp/showProduct.jsp").forward(req, resp);
	}

}
