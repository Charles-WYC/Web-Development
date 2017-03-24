package bean;

import java.sql.Date;
import java.util.ArrayList;

public class IndentBean extends Base{
	private int indentID;
	private ArrayList<IndentItem> indentItems;
	private Date time;
	private String status;
	private float amount;
	private int userID;
	
	public IndentBean(int indentID, String status, float amount, Date time)
	{
		this.indentID = indentID;
		this.amount = amount;
		this.status = status;
		this.time =time;
		this.indentItems= new ArrayList();
	}
	
	public IndentBean(int indentID, String status, float amount, Date time, int userID)
	{
		this.indentID = indentID;
		this.amount = amount;
		this.status = status;
		this.time =time;
		this.indentItems= new ArrayList();
	}
	
	public IndentBean(int indentID)
	{
		this.indentID = indentID;
		this.indentItems = new ArrayList();
	}
	public void payIndent()
	{
		  findAllItem();
		  String sql ="update book set sales_volume=sales_volume+? where bookID = ?";
	      try{
			  for(int i =0; i<indentItems.size();i++)
			  {
				createStatement(sql);
				stmt.setInt(1, indentItems.get(i).getNumber());
				stmt.setInt(2, indentItems.get(i).getBookID());
				executeUpdate();
			  }
		      sql = "update indent set status = 'undelivery' where indentID = ?";
	         createStatement(sql);
	         stmt.setInt(1, indentID);
	         executeUpdate();
	      }catch(Exception e){
	         System.out.println(e.toString());
	      }
	      return ;
		
	}
	public void confirmIndent()
	{
	      String sql = "update indent set status = 'done' where indentID = ?";
	      try{
	         createStatement(sql);
	         stmt.setInt(1, indentID);
	         executeUpdate();
	      }catch(Exception e){
	         System.out.println(e.toString());
	      }
	      return ;
		
	}
	public void deliveryIndent()
	{
	      String sql = "update indent set status = 'unconfirm' where indentID = ?";
	      try{
	         createStatement(sql);
	         stmt.setInt(1, indentID);
	         executeUpdate();
	      }catch(Exception e){
	         System.out.println(e.toString());
	      }
	      return ;
		
	}
	public void addItemIntoShipment(int bookID, int number)
	{
	      String sql = "insert into shipment value(?,?,?)";
	      try{
	         createStatement(sql);
	         stmt.setInt(1, bookID);
	         stmt.setInt(2, indentID);
	         stmt.setInt(3, number);
	         executeUpdate();
	      }catch(Exception e){
	         System.out.println(e.toString());
	      }
	      return ;
	}
	public void deleteIndent()
	{
	      String sql = "delete from indent where indentID = ?";
	      try{
	         createStatement(sql);
	         stmt.setInt(1, indentID);
	         executeUpdate();
	      }catch(Exception e){
	         System.out.println(e.toString());
	      }
	      return ;
		
	}
	public void getIndentInfo()
	{
	      String sql = "select * from indent where indentID = ?";
	      try{
	         createStatement(sql);
	         stmt.setInt(1, indentID);
	         rs = executeQuery();
	         // 使用while循环遍历结果集
	         if(rs.next())
	         {
	        	 amount = rs.getFloat("amount");
	        	 status = rs.getString("status");
	        	 time = rs.getDate("time");
	         }
	      }catch(Exception e){
	         System.out.println(e.toString());
	      }
	      return ;
		
	}
	public void editAmount(float newAmount)
	{
	      String sql = "update indent set amount = ? where indentID = ?";
	      try{
	         createStatement(sql);
	         stmt.setFloat(1, newAmount);
	         stmt.setInt(2, indentID);
	         executeUpdate();
	      }catch(Exception e){
	         System.out.println(e.toString());
	      }
	      return ;
	}
	public void findAllItem()
	{
	      String sql = "select * from shipment join book join book_detail where indentID = ? and shipment.bookID = book.bookID and shipment.bookID = book_detail.bookID";
	      try{
	         createStatement(sql);
	         stmt.setInt(1, indentID);
	         rs = executeQuery();
	         // 使用while循环遍历结果集
	         while(rs.next())
	         {

	            // 使用rs的getString方法，以字符串的形式获取第一列，参数也可以是列的名字
	            // 可以得到当前记录的每一列
	            int tempBookID = rs.getInt("bookID");
	            String tempBookName = rs.getString("book_name");
	            String tempAuthor = rs.getString("author");
	            float tempPrice = rs.getFloat("price");
	            String tempPublisher = rs.getString("publisher");
	            int tempNumber = rs.getInt("number");
	            IndentItem indentItem = new IndentItem(indentID, tempBookID, tempNumber, tempPrice, tempNumber*tempPrice, tempBookName,tempPublisher, tempAuthor);

	            indentItems.add(indentItem);
	         }
	      }catch(Exception e){
	         System.out.println(e.toString());
	      }
	      return ;
		
	}
	public int getIndentID() {
		return indentID;
	}
	public void setIndentID(int indentID) {
		this.indentID = indentID;
	}
	public ArrayList<IndentItem> getIndentItems()
	{
		return indentItems;
	}
	public void setIndentItems(ArrayList<IndentItem> indentItems)
	{
		this.indentItems = indentItems;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
}