package service;

import java.util.List;

import entity.User;

public interface UserService {
	public User login(User user);
	public void updateUser(User user);
	public User addUser(User user);
	public List<User> findAllCustomer();
	public void deleteUserByID(int userID);
}
