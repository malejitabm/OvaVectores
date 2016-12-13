package edu.self.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class VideoLoaderServlet
 */
@WebServlet("/videoloader")
public class VideoLoaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pr = response.getWriter();
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		StringBuilder json = new StringBuilder();
		JSONObject obj = new JSONObject();
		if(Integer.parseInt(request.getParameter("videoId")) == 1){
			obj.put("title", "Inicialización");
			obj.put("url", "https://www.youtube.com/embed/14J8DrGUYR0?controls=1");
		}else if(Integer.parseInt(request.getParameter("videoId")) == 2){
			obj.put("title", "Recorrido");
			obj.put("url", "https://www.youtube.com/embed/UwB1qjBDMXU?controls=1");
		}else if(Integer.parseInt(request.getParameter("videoId")) == 3){
			obj.put("title", "Asignación");
			obj.put("url", "https://www.youtube.com/embed/5hgk7J94XkM?controls=1");
		}else if(Integer.parseInt(request.getParameter("videoId")) == 4){
			obj.put("title", "Busqueda de Elementos");
			obj.put("url", "https://www.youtube.com/embed/WKqu85T_D8Y?controls=1");
		}else{
			obj.put("title", "Algoritmos de Ordenamiento");
			obj.put("url","https://www.youtube.com/embed/rF-OUqm7z9c?controls=1");
		}
		json.append(obj);
		pr.write(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
