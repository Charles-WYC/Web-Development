package action;

import com.opensymphony.xwork2.ActionContext;

public class LogoutAction extends BaseAction{

	public String execute(){
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}
}
