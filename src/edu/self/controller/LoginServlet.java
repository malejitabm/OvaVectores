package edu.self.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		String id = request.getParameter("username");
		String password = request.getParameter("password");
		DAOUser dao = new DAOUser();
		
		PrintWriter pr = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		if(validateFields(id,password)){
			DTOUser user = dao.search(id, password);
			if(user != null){
				request.getSession().setAttribute("user", user);
				if(user.getType() == 1){
					pr.write("admin-home.jsp");
				}else{
					pr.write("home.jsp");
				}
			}else{
				pr.write("n");
			}
		}else{
			pr.write("blank");
		}
		
	}
	private boolean validateFields(String username,String password){
		return (!username.equals("") && !password.equals(""));
	}

}
