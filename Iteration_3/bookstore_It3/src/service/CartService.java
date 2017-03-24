package service;

import entity.Book;
import entity.Cart;
import entity.User;

public interface CartService {
	public void addBookIntoCart(User user, Book book, int number);
	public void getCart(User user);
	public Cart addCart(Cart cart);
}
