package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username_input");//@@@
		HttpSession session = req.getSession();
		session.setAttribute("username", username);//it's different with @@@， 但是username这个属性在哪啊？
		RequestDispatcher rd =req.getRequestDispatcher("/listProduct");
		rd.forward(req, resp);
		//these two lines means receiving information from client sending these information to another page 
		// rather than dealing with them directly
		// req means request which is used for getting information from client
		//resp means response which is used for sending information to client 
		
		
	}

}
