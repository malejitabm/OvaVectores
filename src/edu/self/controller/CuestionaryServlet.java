package edu.self.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import edu.self.model.DAOCuestionary;
import edu.self.model.DAOUserCuestionary;
import edu.self.model.DTOCuestionary;
import edu.self.model.DTOOption;
import edu.self.model.DTOQuestion;
import edu.self.model.DTOUser;

/**
 * Servlet implementation class CuestionaryServlet
 */
@WebServlet("/cuestionary")
public class CuestionaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pr = response.getWriter();
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		StringBuilder json = new StringBuilder();
		DAOCuestionary dao = new DAOCuestionary();
		DTOCuestionary cuestionary = dao.searchCuestionary(Integer.parseInt(request.getParameter("subtopic")));
		if(cuestionary != null){
			JSONObject obj = new JSONObject();
			obj.put("id", cuestionary.getId());
			obj.put("name", cuestionary.getName());
			obj.put("description",cuestionary.getDescription());
			obj.put("subtopic", cuestionary.getSubTopic());
			JSONArray questionList = new JSONArray();
			for(DTOQuestion question:cuestionary.getQuestions()){
				JSONObject q = new JSONObject();
				q.put("id", question.getId());
				q.put("description", question.getDescription());
				q.put("cuestionary", question.getCuestionary());
				JSONArray optionList = new JSONArray();
				for(DTOOption option:question.getOptions()){
					JSONObject o = new JSONObject();
					o.put("id", option.getId());
					o.put("description", option.getDescription());
					o.put("question",option.getQuestion());
					optionList.add(o);
				}
				q.put("options", optionList);
				questionList.add(q);
			}
			obj.put("questions", questionList);
			json.append(obj);
		}
		
		pr.write(json.toString());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = 0;
		DAOCuestionary dao = new DAOCuestionary();
		int questionsCount = dao.getQuestions(Integer.parseInt(request.getParameter("cuestionary")));
		Map<String,String[]> requestMap = request.getParameterMap();
		if((requestMap.size()-1) < questionsCount){
			//Enviar respuesta
		}else{
			for(Map.Entry<String, String[]> entry : requestMap.entrySet()){
				//Option : entry.getValue()[0]
				//Question : entry.getKey()
				if(!entry.getKey().equals("cuestionary")){
					if(dao.verifyAnswer(Integer.parseInt(entry.getValue()[0]),Integer.parseInt(entry.getKey()))){
						count++;
					}
				}
			}
			DAOUserCuestionary daouc = new DAOUserCuestionary();
			DTOUser user = (DTOUser) request.getSession().getAttribute("user");
			if(count >= questionsCount){
				daouc.insert(user.getId(), Integer.parseInt(request.getParameter("cuestionary")), true);
				System.out.println("Aprobado");
				
			}else{
				daouc.insert(user.getId(), Integer.parseInt(request.getParameter("cuestionary")), false);
				System.out.println("No Aprobado");
			}
		}
	}

}
