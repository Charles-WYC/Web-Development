package action;

import com.opensymphony.xwork2.ActionContext;

import entity.CartItem;
import entity.User;
import service.CartItemService;
import service.CartService;

public class CustomerEditBookNumberInCartAction extends BaseAction{
	private int cartItemID;
	private int degree;
	private int type;
	private CartItemService cartItemService;
	private CartService cartService;
	
	public String execute(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		cartService.getCart(user);
		
		if(type==0)
		{
			for(CartItem cartItem : user.getCart().getCartItems()){
				if(cartItem.getCartItemID() == cartItemID)
				{
					cartItemService.deleteCartItem(cartItem);
					break;
				}
			}
		}
		else if(type == 1)
		{
			for(CartItem cartItem : user.getCart().getCartItems()){
				if(cartItem.getCartItemID() == cartItemID)
				{
					cartItemService.updateCartItem(cartItem,degree);
					break;
				}
			}
		}
		else
		{
			CartItem tempItem = null;
			for(CartItem cartItem : user.getCart().getCartItems()){
				if(cartItem.getCartItemID() == cartItemID)
				{
					tempItem = cartItem;
					break;
				}
			}
			if(tempItem.getNumber()> degree)
			{
				cartItemService.updateCartItem(tempItem, 0-degree);
			}
			else
			{
				cartItemService.deleteCartItem(tempItem);
			}
		}
		return SUCCESS;
	}

	public CartItemService getCartItemService() {
		return cartItemService;
	}

	public void setCartItemService(CartItemService cartItemService) {
		this.cartItemService = cartItemService;
	}

	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCartItemID() {
		return cartItemID;
	}

	public void setCartItemID(int cartItemID) {
		this.cartItemID = cartItemID;
	}
}
