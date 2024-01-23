package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

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
	
	
	public boolean login(User user) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "SELECT password FROM user WHERE email = ?";
		
		// check if email exists
		try {
			connection = DBConnnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, user.getEmail());
			
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				String storedPassword = resultSet.getString("password");
				return user.getPassword().matches(storedPassword);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(statement != null) {
					statement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}

}
