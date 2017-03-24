package action;

import com.opensymphony.xwork2.ActionContext;

import entity.Order;
import entity.User;
import service.OrderService;

public class CustomerConfirmOrderAction extends BaseAction{

	private int orderID;
	private OrderService orderService;
	
	public int getOrderID() {
		return orderID;
	}
	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	public String execute(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		Order order = orderService.getOrderByID(orderID);
		order.setUser(user);
		orderService.confirmOrder(order);
		return SUCCESS;
	}
}
