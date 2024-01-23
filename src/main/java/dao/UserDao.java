package dao;

import entity.User;

public interface UserDao {
	public int insert(User user);
	public boolean login(User user);
}
