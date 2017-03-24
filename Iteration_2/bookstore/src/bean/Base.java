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
	    
	   
	   // ������ӵĴ������൱�ڵ�1.2��
	   public Connection getConnection() throws Exception{
	      Class.forName(drivername); // ������������
	      if(con == null)
	         con = DriverManager.getConnection(dbid,username,password);
	      return con;
	   }

	   // ����������
	   public PreparedStatement createStatement(String sql) throws Exception{
	      stmt = getConnection().prepareStatement(sql);
	      return stmt;
	   }  

	   // ִ���н�������صķ���
	   public ResultSet executeQuery() throws Exception{
	      rs = stmt.executeQuery();
	      return rs;
	   }

	   // ִ��û�н�������صķ���
	   public int executeUpdate() throws Exception{
	      return stmt.executeUpdate();
	   }

	   // �رն���
	   public void close(){
	      if(rs != null) 
	         try{ rs.close();  }catch(Exception e){} 
	      if(stmt != null) 
	         try{ stmt.close();  }catch(Exception e){} 
	      if(con != null) 
	         try{ con.close();  }catch(Exception e){} 
	   }
}
