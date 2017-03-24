package action;

import entity.Order;
import service.OrderService;

public class AdminDeliverOrderAction extends BaseAction{
	private int orderID;
	private OrderService orderService;
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public String execute(){
		Order order = orderService.getOrderByID(orderID);
		orderService.deliverOrder(order);
		return SUCCESS;
	}
}
