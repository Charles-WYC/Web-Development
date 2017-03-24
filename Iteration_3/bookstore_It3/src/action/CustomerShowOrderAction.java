package action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import entity.User;
import service.OrderService;

public class CustomerShowOrderAction extends BaseAction{
	
	private OrderService orderService;

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public String execute(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		orderService.findOrder(user);
		ServletActionContext.getRequest().setAttribute("orders", user.getOrders());
		return SUCCESS;
	}
}
