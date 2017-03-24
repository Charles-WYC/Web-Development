package dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Cart;
import entity.CartItem;
import entity.User;
import support.HibernateUtils;

public class CartDaoImpl implements CartDao{
	
	public void getCart(User user){
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();

		String hql = "from Cart where userID = ?";
		Query query = session.createQuery(hql);
		query.setInteger(0, user.getUserID());
		
		List<Cart> carts = query.list();

		user.setCart(carts.get(0));
		if(user.getCart().getCartItems() == null){
			
		}
		trans.commit();
		session.close();
		
		return;
	}
	public Cart addCart(Cart cart){
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		int id = (int) session.save(cart);
		
		cart.setCartID(id);

		trans.commit();
		session.close();
		
		return cart;
	}
}
