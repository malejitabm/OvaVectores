package edu.self.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.self.model.*;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOUser dao = new DAOUser();
		DTOUser user = new DTOUser(request.getParameter("username"),request.getParameter("email"),request.getParameter("password"));
		if(dao.insert(user)){
			request.getSession().setAttribute("user", user);
			response.sendRedirect("home.jsp");
			return;
		}else{
			response.sendRedirect("register.jsp");
			return;
		}
	}

}
