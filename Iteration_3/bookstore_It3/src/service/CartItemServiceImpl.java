package service;

import dao.CartItemDao;
import entity.Book;
import entity.Cart;
import entity.CartItem;

public class CartItemServiceImpl implements CartItemService{
	private CartItemDao cartItemDao;
	public void addCartItem(Cart cart, Book book, int number){
		
		CartItem cartItem = new CartItem(cart, book, number, number*book.getPrice());
		cartItemDao.addCartItem(cartItem);
		
		return;
	}
	public CartItemDao getCartItemDao() {
		return cartItemDao;
	}
	public void setCartItemDao(CartItemDao cartItemDao) {
		this.cartItemDao = cartItemDao;
	}
	public void updateCartItem(CartItem cartItem, int number){

		cartItem.setNumber(number+cartItem.getNumber());
		cartItem.setTotal_price(cartItem.getNumber()*cartItem.getBook().getPrice());
		
		cartItemDao.updateCartItem(cartItem);
		
		return;
	}
	public void deleteCartItem(CartItem cartItem){
		cartItemDao.deleteCartItem(cartItem);
		return;
	}
	public CartItem findCartItemByID(int cartItemID){
		return cartItemDao.findCartItemByID(cartItemID);
	}
}
