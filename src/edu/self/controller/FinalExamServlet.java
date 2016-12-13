package edu.self.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import edu.self.model.DAOFinalExam;
import edu.self.model.DAOUserCuestionary;
import edu.self.model.DAOUserFinalExam;
import edu.self.model.DTOOption;
import edu.self.model.DTOQuestion;
import edu.self.model.DTOUser;

/**
 * Servlet implementation class FinalExamServlet
 */
@WebServlet("/final")
public class FinalExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pr = response.getWriter();
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		StringBuilder json = new StringBuilder();
		DAOFinalExam dao = new DAOFinalExam();
		ArrayList<DTOQuestion> questions = dao.searchFinalExam(1);
		if(questions != null){
			JSONObject obj = new JSONObject();
			JSONArray questionList = new JSONArray();
			for(DTOQuestion question:questions){
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
		DAOFinalExam dao = new DAOFinalExam();
		DAOCuestionary daoC = new DAOCuestionary();
		int questionsCount = dao.searchFinalExam(1).size();
		PrintWriter pr = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		System.out.println(request.getParameter("answers"));
		try {
			obj = (JSONObject) parser.parse(request.getParameter("answers"));
			System.out.println(obj.toString());
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
					if(daoC.verifyAnswer(Integer.parseInt(o.get("option").toString()),Integer.parseInt(o.get("question").toString()))){
						count++;
					}
				}
				DAOUserFinalExam daouf = new DAOUserFinalExam();
				DTOUser user = (DTOUser) request.getSession().getAttribute("user");
				if(count >= questionsCount){
					daouf.insert(user.getId(), 1, true);
					//Enviar aviso
					pr.write("correct");
				}else{
					daouf.insert(user.getId(), 1, false);
					//Enviar aviso
					pr.write("incorrect");
				}
			}
		}
	}

}
