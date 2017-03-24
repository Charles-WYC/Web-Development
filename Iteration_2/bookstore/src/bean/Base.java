package bean;

import java.sql.*;

public class Base {
	   Connection con = null;
	   PreparedStatement stmt = null;
	   ResultSet rs = null;
	   
	   String dbid = "jdbc:mysql://localhost:3306/bookstore";
	   String drivername = "com.mysql.jdbc.Driver";
	   String username = "root";
	   String password = "";
	    
	   
	   // 完成连接的创建，相当于第1.2步
	   public Connection getConnection() throws Exception{
	      Class.forName(drivername); // 加载驱动程序
	      if(con == null)
	         con = DriverManager.getConnection(dbid,username,password);
	      return con;
	   }

	   // 创建语句对象
	   public PreparedStatement createStatement(String sql) throws Exception{
	      stmt = getConnection().prepareStatement(sql);
	      return stmt;
	   }  

	   // 执行有结果集返回的方法
	   public ResultSet executeQuery() throws Exception{
	      rs = stmt.executeQuery();
	      return rs;
	   }

	   // 执行没有结果集返回的方法
	   public int executeUpdate() throws Exception{
	      return stmt.executeUpdate();
	   }

	   // 关闭对象
	   public void close(){
	      if(rs != null) 
	         try{ rs.close();  }catch(Exception e){} 
	      if(stmt != null) 
	         try{ stmt.close();  }catch(Exception e){} 
	      if(con != null) 
	         try{ con.close();  }catch(Exception e){} 
	   }
}
