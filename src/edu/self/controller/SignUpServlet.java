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
		if(validateFields(request.getParameter("id"),request.getParameter("name"),request.getParameter("password1"),request.getParameter("password2")) && validatePassword(request.getParameter("password1"),request.getParameter("password2"))){
			DTOUser user = new DTOUser(request.getParameter("id"),request.getParameter("name"),request.getParameter("password1"),2);
			if(dao.insert(user)){
				request.getSession().setAttribute("user", user);
				response.sendRedirect("home.jsp");
				return;
			}else{
				response.sendRedirect("register.jsp");
				return;
			}
		}else{
			response.sendRedirect("register.jsp");
			return;
		}
		
	}
	private boolean validateFields(String id,String name,String password1,String password2){
		return (!id.equals("") && !name.equals("") && !password1.equals("") && !password2.equals(""));
	}
	private boolean validatePassword(String password1,String password2){
		return (password1.equals(password2));
	}

}
