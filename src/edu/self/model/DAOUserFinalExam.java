package edu.self.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DAOUserFinalExam {
	private PreparedStatement ps;
	
	public boolean insert(String id,int finalExam,boolean success){
		try{
			ps = Connection.getConnection().prepareStatement("insert into UsuarioEvaluacion values(?,?,?,?)");
			ps.setString(1, id);
			ps.setInt(2, finalExam);
			ps.setBoolean(3, success);
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			ps.setString(4, timeStamp);
			int result = ps.executeUpdate();
			if(result >= 1){
				Connection.closeConnection();
				return true;
			}
		}catch(SQLException e){
			System.err.println("Can't execute the search query: "+e);
		}
		Connection.closeConnection();
		return false;
	}
}
