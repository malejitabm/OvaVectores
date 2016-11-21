package edu.self.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		String filename;
		if(Integer.parseInt(request.getParameter("videoId")) == 1){
			filename = "video/Inicializacion.mp4";
		}else if(Integer.parseInt(request.getParameter("videoId")) == 2){
			filename = "video/Recorrido.mp4";
		}else if(Integer.parseInt(request.getParameter("videoId")) == 3){
			filename = "video/Asignacion.mp4";
		}else if(Integer.parseInt(request.getParameter("videoId")) == 4){
			filename = "video/Busqueda.mp4";
		}else{
			filename = "video/Ordenamiento.mp4";
		}
		pr.write(filename);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
