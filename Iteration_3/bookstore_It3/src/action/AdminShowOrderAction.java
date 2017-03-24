package action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import entity.Order;
import service.OrderService;

public class AdminShowOrderAction extends BaseAction{
	private OrderService orderService;

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public String execute(){
		List<Order> orders = orderService.findAllOrder();
		ServletActionContext.getRequest().setAttribute("orders", orders);
		return SUCCESS;
	}
}
