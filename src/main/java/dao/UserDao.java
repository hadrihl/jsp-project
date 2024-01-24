package dao;

import java.util.List;

import entity.User;

public interface UserDao {
	public boolean insert(User user);
	
	public boolean login(User user);
	
	public boolean insertToken(String email, String token);
	
	public List<User> getUsersByKeyword(String keyword);
}
