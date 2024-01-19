package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.User;

public class UserDaoImpl implements UserDao {

	@Override
	public int insert(User user) {
		
		//=====================================
		// insert data to db
		int rowAffected = 0;
		Connection connection = null;
		String sql = "insert into user (firstname,lastname,email,password,city) values (?,?,?,?,?)";
		
		try {
			connection = DBConnnection.getConnection();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getFirstname());
			statement.setString(2, user.getLastname());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getCity());
			
			rowAffected = statement.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();	
		}
		//=====================================
		
		return rowAffected;
	}

}
