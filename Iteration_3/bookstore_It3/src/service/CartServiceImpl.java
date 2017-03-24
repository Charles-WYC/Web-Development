package service;

import java.util.List;
import java.util.Set;

import dao.CartDao;
import dao.CartItemDao;
import dao.UserDao;
import entity.Book;
import entity.Cart;
import entity.CartItem;
import entity.User;

public class CartServiceImpl implements CartService{
	private CartItemService cartItemService;
	private CartDao cartDao;
	
	public void addBookIntoCart(User user, Book book, int number){
		cartDao.getCart(user);
		Cart cart=user.getCart();
		Set<CartItem> cartItems = cart.getCartItems();
		System.out.println(cartItems);
		boolean isExist = false;
		System.out.println(book);
		CartItem tempItem = null;
		for(CartItem cartItem : cartItems)
		{
			if(cartItem.getBook().getBookID() == book.getBookID()){
				isExist = true;
				tempItem = cartItem;
			}
		}
		if(isExist)
		{
			System.out.println("a");
			cartItemService.updateCartItem(tempItem, number);
		}
		else
		{
			System.out.println("b");
			System.out.println(cart);
			cartItemService.addCartItem(cart, book, number);
		}
		return;
	}

	public Cart addCart(Cart cart){
		cart = cartDao.addCart(cart);
		return cart;
	}
	public void getCart(User user){
		cartDao.getCart(user);
		return;
	}
	public CartDao getCartDao() {
		return cartDao;
	}
	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	public CartItemService getCartItemService() {
		return cartItemService;
	}

	public void setCartItemService(CartItemService cartItemService) {
		this.cartItemService = cartItemService;
	}
}
