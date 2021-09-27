package com.today.controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.today.controller.Controller;
import com.today.service.TodayService;
import com.today.util.HttpUtil;
import com.today.vo.TodayVO;

public class TodayReadController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tt = request.getParameter("tt");
		
		TodayService tservice = TodayService.getInstance();
		
		String url = null;
		try {
			TodayVO today = tservice.todayRead(tt);
			
			request.setAttribute("today", today);
			url = "update.jsp";
			
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			url="error.jsp";
		}
		
		HttpUtil.forward(request, response, url);
	}

}
