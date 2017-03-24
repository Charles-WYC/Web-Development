package action;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.opensymphony.xwork2.ActionContext;

import entity.User;

public class CustomerShowInfoAction extends BaseAction{
	
	public String execute(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		try{
			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("bookstore");
			String newPhotoName="photo"+user.getUserID();
			String newVideoName="video"+user.getUserID();
            System.out.println(newPhotoName);
            System.out.println(newVideoName);
			GridFS gfsVideo = new GridFS(db, "video");
			GridFS gfsPhoto = new GridFS(db, "photo");
			GridFSDBFile photoForOutput = gfsPhoto.findOne(newPhotoName);
			GridFSDBFile videoForOutput = gfsVideo.findOne(newVideoName);
            System.out.println("bb");
            System.out.println(photoForOutput);
            System.out.println(videoForOutput);
			photoForOutput.writeTo("D://Program Files/Eclipse/bookstore_It3/WebContent/photo/"+newPhotoName+".jpg");
			videoForOutput.writeTo("D://Program Files/Eclipse/bookstore_It3/WebContent/video/"+newVideoName+".mp4");
            System.out.println("cc");
		}catch (Exception e) {
            System.out.println("ÎÄ¼þ²éÕÒÊ§°Ü");
            e.printStackTrace();
        }
		return SUCCESS;
	}
}
