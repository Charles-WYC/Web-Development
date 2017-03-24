package action;

import com.opensymphony.xwork2.ActionContext;

import entity.Order;
import entity.User;
import service.OrderService;

public class CustomerPayOrderAction extends BaseAction{
	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	private int orderID;
	private OrderService orderService;
	
	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	public String execute(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		Order order = orderService.getOrderByID(orderID);
		order.setUser(user);
		boolean isSuccess=orderService.payOrder(order);
		if(isSuccess){
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
		
	}
}
