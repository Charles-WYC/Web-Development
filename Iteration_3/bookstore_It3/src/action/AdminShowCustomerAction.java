package action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import entity.User;
import service.UserService;

public class AdminShowCustomerAction extends BaseAction{
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String execute(){
		List<User> users = userService.findAllCustomer();
		ServletActionContext.getRequest().setAttribute("users", users);
		return SUCCESS;
	}
}
