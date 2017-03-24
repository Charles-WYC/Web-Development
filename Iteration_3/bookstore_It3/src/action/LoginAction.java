package action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import entity.User;
import service.UserService;


public class LoginAction extends BaseAction implements ModelDriven<User>{
	private User user;
	private UserService userService;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public User getModel(){
		return user;
	}
	
	public String execute(){
		user = userService.login(user);
		if(user == null)
		{
			return ERROR;
		}
		else
		{
			ActionContext.getContext().getSession().put("user", user);
			return SUCCESS;
		}
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
