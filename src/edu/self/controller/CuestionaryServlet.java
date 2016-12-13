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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
		
		PrintWriter pr = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(request.getParameter("answers"));
		} catch (ParseException e) {
			System.out.println("Can't parse the JSON String: "+e);
		}
		if(obj != null){
			JSONArray  options = (JSONArray) obj.get("options");
			if(options.size() < questionsCount){
				//Enviar aviso
				pr.write("blank");
			}else{
				for(int i = 0;i<options.size();i++){
					JSONObject o = (JSONObject) options.get(i);
					if(dao.verifyAnswer(Integer.parseInt(o.get("option").toString()),Integer.parseInt(o.get("question").toString()))){
						count++;
					}
				}
				DAOUserCuestionary daouc = new DAOUserCuestionary();
				DTOUser user = (DTOUser) request.getSession().getAttribute("user");
				if(count >= questionsCount){
					daouc.insert(user.getId(), Integer.parseInt(request.getParameter("cuestionary")), true);
					//Enviar aviso
					pr.write("correct");
				}else{
					daouc.insert(user.getId(), Integer.parseInt(request.getParameter("cuestionary")), false);
					//Enviar aviso
					pr.write("incorrect");
				}
			}
			
		}
		
	}

}
