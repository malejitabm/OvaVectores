package edu.self.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import edu.self.model.DAOUser;
import edu.self.model.DTOUser;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pr = response.getWriter();
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		StringBuilder json = new StringBuilder();
		DAOUser dao = new DAOUser();
		ArrayList<DTOUser> users = dao.searchUsers(2);
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();
		for(DTOUser user:users){
			JSONObject o = new JSONObject();
			o.put("id", user.getId());
			o.put("name", user.getName());
			o.put("type", user.getType());
			array.add(o);
		}
		obj.put("users", array);
		json.append(obj);
		pr.write(json.toString());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
