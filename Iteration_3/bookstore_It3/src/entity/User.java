package entity;

import java.util.List;
import java.util.Set;

public class User {
	private String username;
	private String password;
	private String mail_address;
	private int userID;
	private String identity;
	private UserDetail userDetail;
	private Cart cart;
	private Set<Order> orders;
	
	public User(){
	}

	public User(String username,String password, String mail_address, int userID, String identity){
	   this.username = username;
	   this.password = password;
	   this.mail_address = mail_address;
	   this.userID = userID;
	   this.identity = identity;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail_address() {
		return mail_address;
	}
	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public UserDetail getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
