package service;

import java.util.Date;
import java.util.List;

import entity.Order;
import entity.User;

public interface OrderService {
	public void findOrder(User user);
	public Order createOrder();
	public void updateOrder(Order order);
	public boolean payOrder(Order order);
	public Order getOrderByID(int orderID);
	public void confirmOrder(Order order);
	public List<Order> findAllOrder();
	public void deleteOrderByID(int orderID);
	public void deliverOrder(Order order);
	public void editAmount(Order order, float newAmount);
	public List<Order> findOrderOnCondition(int userID, int bookID, String Bdate, String Edate, String category);
}
