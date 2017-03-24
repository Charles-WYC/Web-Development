package entity;

import java.util.List;
import java.util.Set;

public class Cart {
	private int cartID;
	private int userID;
	private Set<CartItem> cartItems;
	
	public Cart(){
		
	}
	public Cart(int userID){
		this.setUserID(userID);
	}
	public Cart(int userID, Set<CartItem> cartItems){
		this.setUserID(userID);
		this.setCartItems(cartItems);
	}

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public Set<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
}
