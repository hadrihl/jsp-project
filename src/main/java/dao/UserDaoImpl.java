package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import com.mysql.cj.protocol.Resultset;

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
				String sql2 = "insert into user (firstname,lastname,email,password,company,city,country,token) values (?,?,?,?,?,?,?,?)";
				
				statement = connection.prepareStatement(sql2);
				statement.setString(1, user.getFirstname());
				statement.setString(2, user.getLastname());
				statement.setString(3, user.getEmail());
				statement.setString(4, user.getPassword());
				statement.setString(5, user.getCompany());
				statement.setString(6, user.getCity());
				statement.setString(7, user.getCountry());
				
				String token = TokenGenerator.generateToken();
				statement.setString(8, token);
				
				int rowAffected = statement.executeUpdate();
				System.err.println("insert: " + rowAffected);
				
				try {
					// send confirmation email
					String url = "http://localhost:8080/jsp-project/verify?token=" + token;
					EmailSender.sendEmail(user.getEmail(), "JSP-Project: Confirmation Email", "Click \"" + url + "\" to verify.");
				
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
		String sql = "UPDATE user SET token=? WHERE email=?";
		
		
		try {
			connection = DBConnnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, token);
			statement.setString(2, email);
			
			int rowAffected = statement.executeUpdate();
			return true;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean verifyToken(String token) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "SELECT email FROM user WHERE user.token = ?";
		
		try {
			connection = DBConnnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, token);
			
			ResultSet resultSet = statement.executeQuery();	
			
			return resultSet.next();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public String getEmailByToken(String token) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "SELECT email FROM user WHERE user.token = ?";
		ResultSet resultSet = null;
		
		try {
			connection = DBConnnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, token);
			
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				return resultSet.getString("email");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
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
	
	public Long getUserIdByEmail(String email) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "SELECT * FROM user WHERE user.email = ?";
		
		try {
			connection = DBConnnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			
			ResultSet resultSet = statement.executeQuery();		
			
			if(resultSet.next()) {
				return resultSet.getLong("id");
			} else {
				System.err.println("issue with sql.");
			}
		
			return 0L;
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public User getUserById(String id) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "SELECT * FROM user WHERE user.id = ?";
		
		try {
			connection = DBConnnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getLong("id")); 
				user.setFirstname(resultSet.getString("firstname"));
				user.setLastname(resultSet.getString("lastname"));
				user.setCompany(resultSet.getString("company"));
				user.setCity(resultSet.getString("city"));
				user.setCountry(resultSet.getString("country"));
				
				resultSet.close();
				statement.close();
				connection.close();
				return user;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean updateUserProfile(String firstname, String lastname, String company, String city, String country, String id) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "UPDATE user SET firstname=?, lastname=?, company=?, city=?, country=? WHERE id=?";
		
		try {
			connection = DBConnnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, firstname);
			statement.setString(2, lastname);
			statement.setString(3, company);
			statement.setString(4, city);
			statement.setString(5, country);
			statement.setString(6, id);
			
			int rowAffected = statement.executeUpdate();
			
			if(rowAffected == 1) {
				return true;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public User getUserByEmail(String email) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "SELECT * FROM user WHERE user.email = ?";
		
		try {
			connection = DBConnnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet resultSet = null;
			
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getLong("id"));
				user.setEmail(resultSet.getString("email"));
				return user;
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean forgotPassword(String email) {

		User user = getUserByEmail(email);
		
		if(user == null) {
			return false;
		} else {
			System.err.println("uid" + user.getId());
			//generate token
			String token = TokenGenerator.generateToken();
			insertToken(user.getEmail(), token);
			
			try {
				// send email
				String url = "http://localhost:8080/jsp-project/resetpassword?token=" + token;
				EmailSender.sendEmail(user.getEmail(), "JSP-Project: Reset Password", "Click \"" + url + "\" to reset your password.");
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
			return true;
		}
	}
	
	public void resetPassword(String email, String password) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "UPDATE user SET password = ? WHERE email = ?";
		
		try {
			connection = DBConnnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, password);
			statement.setString(2, email);
			
			statement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
