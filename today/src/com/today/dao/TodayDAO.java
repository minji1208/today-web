package com.today.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.today.util.DBUtil;
import com.today.vo.TodayVO;
import com.today.vo.UserVO;

public class TodayDAO {
	public static TodayDAO tdao = new TodayDAO();

	private TodayDAO() {
	}

	public static TodayDAO getInstance() {
		return tdao;
	}

	int result;

	Connection con;
	PreparedStatement pstmt;
	ResultSet rset;
	TodayVO today;
	ArrayList<TodayVO> todayList;

	// 글 등록
	public int todayInsert(TodayVO today) {
		try (Connection con = DBUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into diary values(?, ?, ?)")) {
			pstmt.setString(1, today.getTt());
			pstmt.setString(2, today.getDt());
			pstmt.setString(3, today.getWt());

			result = pstmt.executeUpdate();
			System.out.println(today+"글이 등록되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//글 전체 정보
	public ArrayList<TodayVO> todayList() throws SQLException {
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from diary");

			rset = pstmt.executeQuery();
			todayList = new ArrayList<TodayVO>();

			while (rset.next()) {
				today = new TodayVO();
				today.setTt(rset.getString("tt"));
				today.setDt(rset.getString("dt"));
				today.setWt(rset.getString("wt"));

				todayList.add(today);
			}

		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return todayList;

	}

	//글 수정
	public int todayUpdate(TodayVO today) throws SQLException{
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update diary set wt = ? where tt = ?");
			pstmt.setString(1, today.getWt());
			pstmt.setString(2, today.getTt());
			
			result = pstmt.executeUpdate();
			System.out.println("글이 수정되었습니다."+result);
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}

	//글 삭제
	public int todayDelete(String tt) throws SQLException{
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from diary where tt = ?");
			pstmt.setString(1, tt);
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(con,  pstmt);
		}
		return result;
	}

	//글 정보
	public TodayVO todayRead(String tt) throws SQLException{
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from diary where tt = ?");
			pstmt.setString(1, tt);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				today = new TodayVO();
				today.setTt(rset.getString(1));
				today.setDt(rset.getString(2));
				today.setWt(rset.getString(3));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return today;
	}
}
