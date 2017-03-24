package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.BookDao;
import dao.OrderDao;
import entity.Order;
import entity.OrderItem;
import entity.User;

public class OrderServiceImpl implements OrderService{
	private OrderDao orderDao;
	private BookDao bookDao;
	
	public void findOrder(User user){
		orderDao.findOrder(user);
		return;
	}
	public Order createOrder(){
		Order order = new Order();
        orderDao.addOrder(order);
        return order;
	}

	public Order getOrderByID(int orderID){
		return orderDao.getOrderByID(orderID);
	}
	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	public void updateOrder(Order order){
		orderDao.updateOrder(order);
		return;
	}
	public List<Order> findAllOrder(){
		return orderDao.findAllOrder();
	}

	public void deleteOrderByID(int orderID){
		orderDao.deleteOrderByID(orderID);
		return;
	}
	public void deliverOrder(Order order){
		order.setStatus("unconfirm");
		orderDao.updateOrder(order);
		return;
	}
	public void editAmount(Order order, float newAmount){
		order.setAmount(newAmount);
		orderDao.updateOrder(order);
		return;
	}
	public boolean payOrder(Order order){
		for(OrderItem orderItem : order.getOrderItems())
		{
			if(orderItem.getNumber()>orderItem.getBook().getQuantity())
			{
				return false;
			}
		}

		for(OrderItem orderItem : order.getOrderItems())
		{
			orderItem.getBook().setQuantity(orderItem.getBook().getQuantity()-orderItem.getNumber());
			bookDao.updateBook(orderItem.getBook());
		}
		
		order.setStatus("undelivery");
		orderDao.updateOrder(order);
		return true;
	}
	public BookDao getBookDao() {
		return bookDao;
	}
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	public void confirmOrder(Order order){
		order.setStatus("done");
		orderDao.updateOrder(order);
		return;
	}
	public List<Order> findOrderOnCondition(int userID, int bookID, String Bdate, String Edate, String category){
		List<Order> orders = orderDao.findOrderOnCondition(userID, Bdate, Edate);
		System.out.println("s");
		System.out.println(orders.size());
		if(bookID != 0){
			System.out.println("ss");
			List<Order> midOrders = new ArrayList();
			for(Order order : orders){
				System.out.println("aa");
				boolean isMeet = false;
				for(OrderItem orderItem : order.getOrderItems()){
					if(orderItem.getBook().getBookID() == bookID){
						System.out.println(order.getOrderID());
						System.out.println(orderItem.getBook().getBook_name());
						isMeet = true;
						break;
					}
				}
				if(isMeet){
					midOrders.add(order);
				}
			}
			orders =  midOrders;
		}
		if(!category.equals("")){
			List<Order> midOrders = new ArrayList();
			for(Order order : orders){
				boolean isMeet = false;
				for(OrderItem orderItem : order.getOrderItems()){
					if(orderItem.getBook().getCategory().equals(category)){
						System.out.println(order.getOrderID());
						System.out.println(orderItem.getBook().getBook_name());
						System.out.println(orderItem.getBook().getCategory());
						isMeet = true;
						break;
					}
				}
				if(isMeet){
					System.out.println(order.getOrderID());
					System.out.println("xx");
					midOrders.add(order);
				}
			}
			orders =  midOrders;
		}
		return orders;
	}
}
