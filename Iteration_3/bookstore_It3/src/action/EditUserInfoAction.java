package action;

import java.io.File;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import entity.User;
import entity.UserDetail;
import service.UserDetailService;
import service.UserService;

public class EditUserInfoAction extends BaseAction implements ModelDriven<User>{

	private User user;
	private UserService userService;
	private String email;
	private String ID_number;
	private File photo;
	private File video;
	
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
		User midUser = (User) ActionContext.getContext().getSession().get("user");
		midUser.setMail_address(user.getMail_address());
		midUser.setPassword(user.getPassword());
		midUser.setUsername(user.getUsername());
		UserDetail userDetail = new UserDetail(midUser, email, ID_number);
		midUser.setUserDetail(userDetail);
		userService.updateUser(midUser);
		ActionContext.getContext().getSession().put("user", midUser);
		
		if(user.getIdentity().equals("admin")){
			return ADMINSUCCESS;
		}
		else{
			
			System.out.println(photo);
			try{
				
				Mongo mongo = new Mongo("localhost", 27017);
				DB db = mongo.getDB("bookstore");
				if(photo != null){
					String newPhotoName="photo"+user.getUserID();
					GridFS gfsPhoto = new GridFS(db, "photo");
					gfsPhoto.remove(gfsPhoto.findOne(newPhotoName));
					GridFSInputFile gfsFile=gfsPhoto.createFile(photo);
					gfsFile.setFilename(newPhotoName);
					gfsFile.save();
				}
				if(video != null){
					String newVideoName="video"+user.getUserID();
					GridFS gfsVideo = new GridFS(db, "video");
					gfsVideo.remove(gfsVideo.findOne(newVideoName));
					GridFSInputFile gfsFile = gfsVideo.createFile(video);
					gfsFile.setFilename(newVideoName);
					gfsFile.save();
				}
	        } catch (Exception e) {
	            System.out.println("文件更新失败");
	            e.printStackTrace();
	        }
			return CUSTOMERSUCCESS;
		}
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getID_number() {
		return ID_number;
	}

	public void setID_number(String iD_number) {
		ID_number = iD_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public File getVideo() {
		return video;
	}

	public void setVideo(File video) {
		this.video = video;
	}
}
