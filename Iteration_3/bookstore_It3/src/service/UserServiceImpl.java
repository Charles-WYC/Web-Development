package service;

import java.util.List;

import dao.UserDao;
import dao.UserDetailDao;
import entity.Cart;
import entity.User;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	private CartService cartService;
	private UserDetailDao userDetailDao;
	public UserDao getUserDao(){
		return userDao;
	}
	
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	public User login(User user){
		User midUser = userDao.FindUserByName(user.getUsername());
		if(midUser == null || !midUser.getPassword().equals(user.getPassword()))
		{
			return null;
		}
		return midUser;	
	}
	public void updateUser(User user){
		userDao.updateUser(user);
		return;
	}
	
	public User addUser(User user){
		User tempUser = userDao.FindUserByName(user.getUsername());
		if(tempUser == null){
			userDao.addUser(user);
			Cart cart = new Cart(user.getUserID());
			cart = cartService.addCart(cart);
			user.setCart(cart);
			user.getUserDetail().setUserID(user.getUserID());
			userDetailDao.addUserDetail(user.getUserDetail());
			return user;
		}
		return null;
	}
	public void deleteUserByID(int userID){
		userDao.deleteUserByID(userID);
		return;
	}

	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	public List<User> findAllCustomer(){
		return userDao.findAllCustomer();
	}

	public UserDetailDao getUserDetailDao() {
		return userDetailDao;
	}

	public void setUserDetailDao(UserDetailDao userDetailDao) {
		this.userDetailDao = userDetailDao;
	}
}
