package service;

import dao.UserDetailDao;
import entity.UserDetail;

public class UserDetailServiceImpl implements UserDetailService{

	private UserDetailDao userDetailDao;
	public void updateUserDetail(UserDetail userDetail){
		userDetailDao.updateUserDetail(userDetail);
		return;
	}
	public UserDetailDao getUserDetailDao() {
		return userDetailDao;
	}
	public void setUserDetailDao(UserDetailDao userDetailDao) {
		this.userDetailDao = userDetailDao;
	}
}
