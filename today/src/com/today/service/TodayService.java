package com.today.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.today.dao.TodayDAO;
import com.today.vo.TodayVO;

public class TodayService {
	public static TodayService tservice = new TodayService();
	
	private TodayService() {}
	
	public static TodayService getInstance() {
		return tservice;
	}
	
	public TodayDAO tdao = TodayDAO.getInstance();
	
	public int todayInsert(TodayVO today) {
		return tdao.todayInsert(today);
	}
	
	public ArrayList<TodayVO> todayList() throws SQLException{
		return tdao.todayList();
	}
	
	public int todayUpdate(TodayVO today) throws SQLException{
		return tdao.todayUpdate(today);
	}
	
	public int todayDelete(String tt) throws SQLException{
		return tdao.todayDelete(tt);
	}

	public TodayVO todayRead(String tt) throws SQLException{
		
		return tdao.todayRead(tt);
	}
}
