package com.today.controller.subcontroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.today.controller.Controller;
import com.today.service.TodayService;
import com.today.util.HttpUtil;
import com.today.vo.TodayVO;

public class TitleListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		TodayService tservice = TodayService.getInstance();
		
		try {
			ArrayList<TodayVO> todayList = tservice.todayList();
			request.setAttribute("list", todayList);
			
			url = "todayHome.jsp";
			
		} catch (Exception e) {
			request.setAttribute("eerorMsg", e.getMessage());
			url="error.jsp";
			
		}
		HttpUtil.forward(request, response, url);

	}

}
