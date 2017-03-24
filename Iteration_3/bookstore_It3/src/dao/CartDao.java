package dao;

import java.util.List;

import entity.Cart;
import entity.CartItem;
import entity.User;

public interface CartDao {
	public void getCart(User user);
	public Cart addCart(Cart cart);
}
