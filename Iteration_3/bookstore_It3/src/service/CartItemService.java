package service;

import entity.Book;
import entity.Cart;
import entity.CartItem;

public interface CartItemService {
	public CartItem findCartItemByID(int cartItemID);
	public void addCartItem(Cart cart, Book book, int number);
	public void updateCartItem(CartItem cartItem, int number);
	public void deleteCartItem(CartItem cartItem);
}
