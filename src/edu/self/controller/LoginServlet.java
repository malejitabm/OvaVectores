package edu.self.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.self.model.*;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		DAOUser dao = new DAOUser();
		DTOUser user = dao.search(id, password);
		if(user != null){
			request.getSession().setAttribute("user", user);
			response.sendRedirect("home.jsp");
			return;
		}else{
			/*
			response.setContentType("text/html");
		    request.setAttribute("access", false);
		    request.getRequestDispatcher("/index.jsp").forward(request, response);
		    */
			response.sendRedirect("index.jsp");
			return;
		}
	}

}
