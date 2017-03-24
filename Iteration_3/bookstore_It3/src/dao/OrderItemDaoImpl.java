package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.OrderItem;
import support.HibernateUtils;

public class OrderItemDaoImpl implements OrderItemDao{

	public void addOrderItem(OrderItem orderItem){
		
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		
		int id = (int)session.save(orderItem);
		orderItem.setOrderItemID(id);
		trans.commit();
		session.close();
		
		return;
	}
}
