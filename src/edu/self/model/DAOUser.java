package edu.self.model;
import java.sql.*;
public class DAOUser {
	private PreparedStatement ps;
	private ResultSet rs;
	
	public boolean insert(DTOUser user){
		try{
			ps = Connection.getConnection().prepareStatement("insert into Usuario values(?,?,?,?)");
			ps.setString(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getType());
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
	
	public DTOUser search(String id,String password){
		DTOUser user = null;
		try{
			ps = Connection.getConnection().prepareStatement("select * from Usuario");
			rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getString("id").equals(id) && rs.getString("contrasena").equals(password)){
					user = new DTOUser(rs.getString("id"),rs.getString("nombre"),rs.getString("contrasena"),rs.getInt("tipo"));
				}
			}
		}catch(SQLException e){
			System.err.println("Can't execute the search query: "+e);
		}
		Connection.closeConnection();
		return user;
	}
}
