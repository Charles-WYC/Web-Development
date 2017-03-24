package action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import entity.Order;
import entity.OrderItem;
import service.OrderService;

public class AdminShowSaleroomAction extends BaseAction{
	private int userID = 0;
	private int bookID = 0;
	private String Byear;
	private String Bmonth;
	private String Bday;
	private String Eyear;
	private String Emonth;
	private String Eday;
	private String category;
	private OrderService orderService;
	
	public String execute(){
		try{
			String Bdate = null;
			String Edate = null;
			if((!Byear.equals(""))&&(!Bmonth.equals(""))&&(!Bday.equals(""))){
				Bdate = Byear+"-"+Bmonth+"-"+Bday;
			}
			if((!Eyear.equals(""))&&(!Emonth.equals(""))&&(!Eday.equals(""))){
				Edate = Eyear+"-"+Emonth+"-"+Eday;
			}
			System.out.println(Bdate);
			System.out.println(Edate);
			List<Order> orders = orderService.findOrderOnCondition(userID, bookID, Bdate, Edate, category);
			System.out.println(orders.size());
		
			int total_sale_volume = 0;
			float total_amount =0;
			for(Order order : orders){
				total_amount+=order.getAmount();
				for(OrderItem orderItem : order.getOrderItems()){
					total_sale_volume +=orderItem.getNumber();
				}
			}
			
			ServletActionContext.getRequest().setAttribute("orders", orders);
			ServletActionContext.getRequest().setAttribute("total_amount", total_amount);
			ServletActionContext.getRequest().setAttribute("total_sale_volume", total_sale_volume);
			ServletActionContext.getRequest().setAttribute("preBYear", Byear);
			ServletActionContext.getRequest().setAttribute("preBMonth", Bmonth);
			ServletActionContext.getRequest().setAttribute("preBDay", Bday);
			ServletActionContext.getRequest().setAttribute("preEYear", Eyear);
			ServletActionContext.getRequest().setAttribute("preEMonth", Emonth);
			ServletActionContext.getRequest().setAttribute("preEDay", Eday);
			
		}catch(Exception e){
        System.out.println(e.toString());
		}
		return SUCCESS;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getByear() {
		return Byear;
	}
	public void setByear(String byear) {
		Byear = byear;
	}
	public String getBmonth() {
		return Bmonth;
	}
	public void setBmonth(String bmonth) {
		Bmonth = bmonth;
	}
	public String getBday() {
		return Bday;
	}
	public void setBday(String bday) {
		Bday = bday;
	}
	public String getEyear() {
		return Eyear;
	}
	public void setEyear(String eyear) {
		Eyear = eyear;
	}
	public String getEmonth() {
		return Emonth;
	}
	public void setEmonth(String emonth) {
		Emonth = emonth;
	}
	public String getEday() {
		return Eday;
	}
	public void setEday(String eday) {
		Eday = eday;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
}
