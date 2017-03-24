package entity;

public class UserDetail {
	private int userID;
	private String email;
	private String ID_number;
	private User user;
	
	
	public UserDetail(){
		
	}
	
	public UserDetail(User user, String email, String ID_number){
		this.user = user;
		this.email = email;
		this.ID_number = ID_number;
	}
	
	public UserDetail(String email, String ID_number){
		this.email = email;
		this.ID_number = ID_number;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getID_number() {
		return ID_number;
	}
	public void setID_number(String iD_number) {
		ID_number = iD_number;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	

}
