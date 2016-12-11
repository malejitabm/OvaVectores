package edu.self.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOFinalExam {
	private PreparedStatement ps;
	private ResultSet rs;
	
	public ArrayList<DTOQuestion> searchFinalExam(int idFinalExam){
		ArrayList<DTOQuestion> questions = null;
		ArrayList<DTOOption> options;
		ResultSet resultSet1;
		try{
			ps = Connection.getConnection().prepareStatement("select * from Pregunta where evaluacionfinal = ?");
			ps.setInt(1, idFinalExam);
			rs = ps.executeQuery();
			questions = new ArrayList<DTOQuestion>();
			while(rs.next()){
				options = new ArrayList<DTOOption>();
				ps = Connection.getConnection().prepareStatement("select * from Opcion where pregunta = ?");
				ps.setInt(1, rs.getInt("id"));
				resultSet1 = ps.executeQuery();
				while(resultSet1.next()){
					options.add(new DTOOption(resultSet1.getInt("id"),resultSet1.getString("descripcion"),resultSet1.getInt("pregunta")));
				}
				questions.add(new DTOQuestion(rs.getInt("id"),rs.getString("descripcion"),rs.getInt("cuestionario"),options));
			}
		}catch(SQLException e){
			System.err.println("Can't execute the search query: "+e);
		}
		Connection.closeConnection();
		return questions;
	}
}
