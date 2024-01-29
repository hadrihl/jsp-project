package dao;

import java.util.List;

import entity.User;

public interface UserDao {
	public boolean insert(User user);
	
	public boolean login(User user);
	
	public boolean insertToken(String email, String token);
	
	public boolean verifyToken(String token);
	
	public String getEmailByToken(String token);
	
	public List<User> getUsersByKeyword(String keyword);
	
	public Long getUserIdByEmail(String email);
	
	public User getUserById(String uid);
	
	public boolean updateUserProfile(String firstname, String lastname, String city, String id);
	
	public boolean forgotPassword(String email);
	
	public User getUserByEmail(String email);
	
	public void resetPassword(String email, String password);
}