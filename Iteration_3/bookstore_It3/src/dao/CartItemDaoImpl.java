package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Book;
import entity.Cart;
import entity.CartItem;
import support.HibernateUtils;

public class CartItemDaoImpl implements CartItemDao{

	public void addCartItem(CartItem cartItem)
	{
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		System.out.println(cartItem.getCart());
		int id = (int) session.save(cartItem);
		
		trans.commit();
		session.close();
		return;
	}
	public void updateCartItem(CartItem cartItem){

		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		session.update(cartItem);
		
		trans.commit();
		session.close();
		return;
	}
	public void deleteCartItem(CartItem cartItem)
	{
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		session.delete(cartItem);
		
		trans.commit();
		session.close();
		return;
	}
	public CartItem findCartItemByID(int cartItemID){

		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		CartItem cartItem=(CartItem) session.get(CartItem.class, cartItemID);

		trans.commit();
		session.close();
		
		return cartItem;
	}
}
