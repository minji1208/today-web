package com.today.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.today.dao.UserDAO;
import com.today.vo.UserVO;

public class UserService {

	public static UserService service = new UserService();
	
	private UserService() {	}
	
	public static UserService getInstance() {
		return service;
	}
	
	public UserDAO dao = UserDAO.getInstance();
	
	public int userInsert(UserVO user) {
		return dao.userInsert(user);
	}
	
	public ArrayList<UserVO> userList() throws SQLException{
		return dao.userList();
	}
	
	public UserVO userRead(UserVO user) throws SQLException{
		return dao.userRead(user);
	}
	
	public int userLogin(String id, String pwd) throws SQLException{
		return dao.userLogin(id, pwd);
	}
	
}
