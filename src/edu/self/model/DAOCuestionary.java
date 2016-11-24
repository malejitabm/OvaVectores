package edu.self.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;

public class DAOCuestionary {
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public DTOCuestionary searchCuestionary(int idSubTopic){
		DTOCuestionary survey = null;
		ArrayList<DTOQuestion> questions;
		ArrayList<DTOOption> options;
		ResultSet resultSet1,resultSet2;
		
		try{
			ps = Connection.getConnection().prepareStatement("select * from Cuestionario where subtema = ?");
			ps.setInt(1, idSubTopic);
			rs = ps.executeQuery();
			while(rs.next()){
				//Surveys
				questions = new ArrayList<DTOQuestion>();
				ps = Connection.getConnection().prepareStatement("select * from Pregunta where cuestionario = ?");
				ps.setInt(1, rs.getInt("id"));
				resultSet1 = ps.executeQuery();
				while(resultSet1.next()){
					options = new ArrayList<DTOOption>();
					//Questions
					ps = Connection.getConnection().prepareStatement("select * from Opcion where pregunta = ?");
					ps.setInt(1, resultSet1.getInt("id"));
					resultSet2 = ps.executeQuery();
					while(resultSet2.next()){
						options.add(new DTOOption(resultSet2.getInt("id"),resultSet2.getString("descripcion"),resultSet2.getInt("pregunta")));
					}
					questions.add(new DTOQuestion(resultSet1.getInt("id"),resultSet1.getString("descripcion"),resultSet1.getInt("cuestionario"),options));
				}
				survey = new DTOCuestionary(rs.getInt("id"),rs.getString("nombre"),rs.getString("descripcion"),rs.getInt("subtema"),questions);
			}
		}catch(SQLException e){
			System.err.println("Can't execute the search query: "+e);
		}
		Connection.closeConnection();
		return survey;
	}
}
