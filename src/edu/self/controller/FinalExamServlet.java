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

import edu.self.model.DAOCuestionary;
import edu.self.model.DTOOption;
import edu.self.model.DTOQuestion;

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
		DAOCuestionary dao = new DAOCuestionary();
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
		
	}

}
