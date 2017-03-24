package dao;

import entity.Book;
import entity.Cart;
import entity.CartItem;

public interface CartItemDao {
	public void addCartItem(CartItem cartItem);
	public void updateCartItem(CartItem cartItem);
	public void deleteCartItem(CartItem cartItem);
	public CartItem findCartItemByID(int cartItemID);
}
