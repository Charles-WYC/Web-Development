package dao;

import java.util.List;

import entity.User;

public interface UserDao {
	public User FindUserByName(String username);
	public void updateUser(User user);
	public User addUser(User user);
	public List<User> findAllCustomer();
	public void deleteUserByID(int userID);
}
