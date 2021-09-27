package com.today.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.today.util.DBUtil;
import com.today.vo.TodayVO;
import com.today.vo.UserVO;

public class UserDAO {
	public static UserDAO dao = new UserDAO();
	
	private UserDAO() {}
	
	public static UserDAO getInstance() {
		return dao;
	}
	
	int result;
	
	//DB���� ��ü
	Connection con;
	PreparedStatement pstmt;
	ResultSet rset;
	UserVO user;
	ArrayList<UserVO> userList;
	
	//user ���
	public int userInsert(UserVO user) {
		try(Connection con = DBUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into today values(?, ?, ?)")){
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getNick());
			
			result = pstmt.executeUpdate();
			System.out.println("ȸ���� ��ϵǾ����ϴ�");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//user ��ü ����
	public ArrayList<UserVO> userList() throws SQLException {
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from today");
			
			rset = pstmt.executeQuery();
			userList = new ArrayList<UserVO>();
			
			while(rset.next()) {
				user = new UserVO();
				user.setId(rset.getString("ID"));
				user.setPwd(rset.getString("Password"));
				user.setNick(rset.getString("Nick"));
				
				userList.add(user);
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return userList;
	}

	
	public UserVO userRead(UserVO user) throws SQLException{
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from today");
//			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				user = new UserVO();
				user.setId(rset.getString(1));
				user.setPwd(rset.getString(2));
				user.setNick(rset.getString(3));
			}
		} finally {
			DBUtil.close(con,  pstmt, rset);
		}
		return user;
	}

	public int userLogin(String id, String pwd) throws SQLException {

		int x = -1;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select pwd from today where id = ?");
			//select * from today where id = ? and where pwd = ?
			//today ��ü ����, 
			pstmt.setString(1, id);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				
				if(rset.getString(1).equals(pwd)) {
					x= 1;
				}
				else {
					x= 0; //��� ������
				}
			} else
			x= -1; //id ������
		} catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	
	
}
