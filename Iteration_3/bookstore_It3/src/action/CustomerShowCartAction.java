package action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import dao.CartDao;
import entity.User;
import service.CartService;

public class CustomerShowCartAction extends BaseAction{
	private CartService cartService;
	
	public String execute(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		cartService.getCart(user);
		ServletActionContext.getRequest().setAttribute("cartItems", user.getCart().getCartItems());
		return SUCCESS;
	}

	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
}
