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
	
	//DB관련 객체
	Connection con;
	PreparedStatement pstmt;
	ResultSet rset;
	UserVO user;
	ArrayList<UserVO> userList;
	
	//user 등록
	public int userInsert(UserVO user) {
		try(Connection con = DBUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into today values(?, ?, ?)")){
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getNick());
			
			result = pstmt.executeUpdate();
			System.out.println("회원이 등록되었습니다");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//user 전체 정보
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
			//today 객체 리턴, 
			pstmt.setString(1, id);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				
				if(rset.getString(1).equals(pwd)) {
					x= 1;
				}
				else {
					x= 0; //비번 불일지
				}
			} else
			x= -1; //id 없을때
		} catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	
	
}
