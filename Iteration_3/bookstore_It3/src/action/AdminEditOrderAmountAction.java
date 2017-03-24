package action;

import entity.Order;
import service.OrderService;

public class AdminEditOrderAmountAction extends BaseAction{
	private int orderID;
	private float newAmount;
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
		orderService.editAmount(order, newAmount);
		return SUCCESS;
	}
	public float getNewAmount() {
		return newAmount;
	}
	public void setNewAmount(float newAmount) {
		this.newAmount = newAmount;
	}
}
