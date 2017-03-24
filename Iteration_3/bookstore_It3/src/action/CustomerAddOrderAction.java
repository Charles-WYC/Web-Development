package action;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import entity.CartItem;
import entity.Order;
import entity.OrderItem;
import entity.User;
import service.CartItemService;
import service.OrderItemService;
import service.OrderService;

public class CustomerAddOrderAction extends BaseAction{
	private int items[];
	private CartItemService cartItemService;
	private OrderService orderService;
	private OrderItemService orderItemService;
	
	public int[] getItems() {
		return items;
	}

	public OrderItemService getOrderItemService() {
		return orderItemService;
	}

	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}

	public void setItems(int items[]) {
		this.items = items;
	}
	
	public String execute(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		Order order=orderService.createOrder();
		order.setUser(user);
		Set<OrderItem> orderItems = new HashSet<OrderItem>();
		float sum = 0;
		for(int i=0; i<items.length; i++){
			CartItem cartItem = cartItemService.findCartItemByID(items[i]);
			OrderItem orderItem = new OrderItem(cartItem.getNumber(), order, cartItem.getBook(), cartItem.getTotal_price());
			orderItemService.addOrderItem(orderItem);
			orderItems.add(orderItem);
			sum+=cartItem.getTotal_price();
			cartItemService.deleteCartItem(cartItem);
		}
		order.setAmount(sum);
		order.setOrderItems(orderItems);
		orderService.updateOrder(order);
		
		ServletActionContext.getRequest().setAttribute("order", order);
		return SUCCESS;
	}

	public CartItemService getCartItemService() {
		return cartItemService;
	}

	public void setCartItemService(CartItemService cartItemService) {
		this.cartItemService = cartItemService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
}
