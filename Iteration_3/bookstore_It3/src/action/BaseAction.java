package action;

import java.lang.reflect.Method;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport{
	private String action = "index";

	public static final String ERROR = "error";
	public static final String CUSTOMERSUCCESS = "CustomerSuccess";
	public static final String ADMINSUCCESS = "AdminSuccess";
	public static final String SUCCESS ="success";
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	public String execute(){
		try{
			return this.executeMethod(this.getAction());
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
	}

	@SuppressWarnings("rawtypes")
	private String executeMethod(String method) throws Exception{
		Class[] c = null;
		Method m = this.getClass().getMethod(method, c);
		Object[] o = null;
		String result = (String) m.invoke(this, o);
		return result;
	}
}
