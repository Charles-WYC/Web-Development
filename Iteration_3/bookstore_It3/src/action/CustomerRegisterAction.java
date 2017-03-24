package action;

import java.io.File;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import com.opensymphony.xwork2.ActionContext;

import entity.User;
import entity.UserDetail;
import service.UserService;

public class CustomerRegisterAction extends BaseAction{
	private User user;
	private UserService userService;
	private String email;
	private String ID_number;
	private File photo = null;
	private File video = null;
	
	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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

	public String execute(){
		System.out.println(1);
		user.setIdentity("customer");
		UserDetail userDetail = new UserDetail(user, email, ID_number);
		user.setUserDetail(userDetail);
		user = userService.addUser(user);
		if(user == null){
			return ERROR;
		}
		else
		{
			System.out.println(1);
			try{
				Mongo mongo = new Mongo("localhost", 27017);
				DB db = mongo.getDB("bookstore");
				String newPhotoName="photo"+user.getUserID();
				String newVideoName="video"+user.getUserID();
	            System.out.println(newPhotoName);
	            System.out.println(newVideoName);
				GridFS gfsVideo = new GridFS(db, "video");
				GridFS gfsPhoto = new GridFS(db, "photo");
				GridFSInputFile gfsFile=gfsPhoto.createFile(photo);
				gfsFile.setFilename(newPhotoName);
				gfsFile.save();
				gfsFile = gfsVideo.createFile(video);
				gfsFile.setFilename(newVideoName);
				gfsFile.save();
	            System.out.println("aaa");
	        } catch (Exception e) {
	            System.out.println("文件上传失败");
	            e.printStackTrace();
	        }
			ActionContext.getContext().getSession().put("user", user);
			return SUCCESS;
		}
	}

	public File getVideo() {
		return video;
	}

	public void setVideo(File video) {
		this.video = video;
	}
}
