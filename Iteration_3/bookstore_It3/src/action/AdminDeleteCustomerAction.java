package action;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;

import service.UserService;

public class AdminDeleteCustomerAction extends BaseAction{
	private int userID;
	private UserService userService;
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String execute(){
		userService.deleteUserByID(userID);
		try{
			
			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("bookstore");
			String newPhotoName="photo"+userID;
			GridFS gfsPhoto = new GridFS(db, "photo");
			gfsPhoto.remove(gfsPhoto.findOne(newPhotoName));
			String newVideoName="video"+userID;
			GridFS gfsVideo = new GridFS(db, "video");
			gfsVideo.remove(gfsVideo.findOne(newVideoName));
        } catch (Exception e) {
            System.out.println("ÎÄ¼þÉ¾³ýÊ§°Ü");
            e.printStackTrace();
        }
		return SUCCESS;
	}
}
