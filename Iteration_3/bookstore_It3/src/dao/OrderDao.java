package dao;

import java.util.Date;
import java.util.List;

import entity.Order;
import entity.User;

public interface OrderDao {
	public void findOrder(User user);
	public void addOrder(Order order);
	public void updateOrder(Order order);
	public Order getOrderByID(int orderID);
	public List<Order> findAllOrder();
	public void deleteOrderByID(int orderID);
	public List<Order> findOrderOnCondition(int userID, String Bdate, String Edate);
}
