package action;

import service.OrderService;

public class AdminDeleteOrderAction extends BaseAction{
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
		orderService.deleteOrderByID(orderID);
		return SUCCESS;
	}
}
