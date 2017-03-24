package dao;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Cart;
import entity.CartItem;
import entity.Order;
import entity.OrderItem;
import entity.User;
import support.HibernateUtils;

public class OrderDaoImpl implements OrderDao{

	public void findOrder(User user){

		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();

		String hql = "from Order where userID = ?";
		Query query = session.createQuery(hql);
		query.setInteger(0, user.getUserID());
		
		Set<Order> orders = new HashSet(query.list());
		for(Order order : orders){
			order.setUser(user);
		}
		user.setOrders(orders);

		trans.commit();
		session.close();
		
		return;
	}
	public List<Order> findAllOrder(){


		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();

		String hql = "from Order";
		Query query = session.createQuery(hql);
		
		List<Order> orders = query.list();

		trans.commit();
		session.close();
		
		return orders;
	}

	public void deleteOrderByID(int orderID){

		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		Order order = (Order) session.get(Order.class, orderID);
		session.delete(order);
		
		trans.commit();
		session.close();
		
		return;
	}
	public void addOrder(Order order){
		
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		int id = (int)session.save(order);
		order.setOrderID(id);
		System.out.println(id);
		trans.commit();
		session.close();
		
		return;
		
	}
	public void updateOrder(Order order){

		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		session.update(order);
		trans.commit();
		session.close();
		
		return;
	}
	public Order getOrderByID(int orderID){

		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();

		String hql = "from Order where orderID = ?";
		Query query = session.createQuery(hql);
		query.setInteger(0, orderID);
		
		List<Order> orders = query.list();

		trans.commit();
		session.close();
		
		return orders.get(0);
	}
	public List<Order> findOrderOnCondition(int userID, String Bdate, String Edate){


		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();

		String hql = "from Order where 1 = 1";
		if(userID != 0){
			hql = hql + "and userID = ?";
		}
		if(Bdate != null){
			hql = hql + "and date >= ?";
		}
		if(Edate != null){
			hql = hql + "and date <= ?";
		}
		Query query = session.createQuery(hql);
		int i = 0;
		if(userID != 0){
			query.setInteger(i, userID);
			i++;
		}
		if(Bdate != null){
			query.setString(i, Bdate);
			i++;
		}
		if(Edate != null){
			query.setString(i, Edate);
			i++;
		}
		
		List<Order> orders = query.list();
		for(Order order : orders){
			System.out.println(order.getDate());
		}
		trans.commit();
		session.close();
		
		return orders;
	}
}
