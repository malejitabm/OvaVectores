package edu.self.model;
import java.sql.*;
public class DAOUser {
	private PreparedStatement ps;
	private ResultSet rs;
	
	public boolean insert(DTOUser user){
		try{
			ps = Connection.getConnection().prepareStatement("insert into User values(?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			int result = ps.executeUpdate();
			if(result >= 1){
				Connection.closeConnection();
				return true;
			}
		}catch(SQLException e){
			System.err.println("Can't execute the insert query: "+e);
		}
		Connection.closeConnection();
		return false;
	}
	
	public DTOUser search(String username,String password){
		DTOUser user = null;
		try{
			ps = Connection.getConnection().prepareStatement("select * from User");
			rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getString("username").equals(username) && rs.getString("password").equals(password)){
					user = new DTOUser(rs.getString("username"),rs.getString("email"),rs.getString("password"));
				}
			}
		}catch(SQLException e){
			System.err.println("Can't execute the search query: "+e);
		}
		Connection.closeConnection();
		return user;
	}
}
