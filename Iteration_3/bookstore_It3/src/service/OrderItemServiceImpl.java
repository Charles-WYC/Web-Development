package service;

import dao.OrderItemDao;
import entity.OrderItem;

public class OrderItemServiceImpl implements OrderItemService{

	private OrderItemDao orderItemDao;
	
	public void addOrderItem(OrderItem orderItem){
		orderItemDao.addOrderItem(orderItem);
		return;
	}

	public OrderItemDao getOrderItemDao() {
		return orderItemDao;
	}

	public void setOrderItemDao(OrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}
}
