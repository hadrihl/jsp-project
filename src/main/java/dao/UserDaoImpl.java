package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import entity.User;
import utility.EmailSender;
import utility.TokenGenerator;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean insert(User user) {
	
		Connection connection = null;
		PreparedStatement statement = null;
		
		String sql = "SELECT email from user WHERE email = ?";
		
		try {
			connection = DBConnnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, user.getEmail());
			
			ResultSet resultSet = statement.executeQuery();
			
			// if email not exists, insert user information into database
			if(!resultSet.next()) {
				String sql2 = "insert into user (firstname,lastname,email,password,city, token) values (?,?,?,?,?,?)";
				
				statement = connection.prepareStatement(sql2);
				statement.setString(1, user.getFirstname());
				statement.setString(2, user.getLastname());
				statement.setString(3, user.getEmail());
				statement.setString(4, user.getPassword());
				statement.setString(5, user.getCity());
				
				String token = TokenGenerator.generateToken();
				statement.setString(6, token);
				
				int rowAffected = statement.executeUpdate();
				System.err.println("insert: " + rowAffected);
				
				try {
					// send confirmation email
					EmailSender.sendEmail(user.getEmail(), "JSP-Project: Confirmation Email", "your token = " + token);
				
				} catch (MessagingException e) {
					e.printStackTrace();
				}
				
				return true;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return false; // email not exist
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

	@Override
	public boolean insertToken(String email, String token) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "UPDATE user SET token = ? WHERE email = ?";
		
		
		try {
			connection = DBConnnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, token);
			statement.setString(2, email);
			
			System.err.println("query: " + statement.toString()); 
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}

	public List<User> getUsersByKeyword(String keyword) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		List<User> users = new ArrayList<User>();
		
		String sql = "SELECT * FROM user WHERE user.firstname = ? OR "
				+ "user.lastname = ? OR "
				+ "user.email = ? OR "
				+ "user.city = ?";
		
		try {
			connection = DBConnnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, keyword);
			statement.setString(2, keyword);
			statement.setString(3, keyword);
			statement.setString(4, keyword);
			
			ResultSet resultSet = statement.executeQuery();
			
			
			while(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getLong("id"));
				user.setFirstname(resultSet.getString("firstname"));
				user.setLastname(resultSet.getString("lastname"));
				user.setEmail(resultSet.getString("email"));
				user.setCity(resultSet.getString("city"));
				users.add(user);
			}
			
			resultSet.close();
			statement.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return users;
	}
}
