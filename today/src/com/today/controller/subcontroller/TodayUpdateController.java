package com.today.controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.today.controller.Controller;
import com.today.service.TodayService;
import com.today.util.HttpUtil;
import com.today.vo.TodayVO;

public class TodayUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		
		TodayService tservice = TodayService.getInstance();
		
		TodayVO today = new TodayVO(
				request.getParameter("tt"),
				request.getParameter("dt"),
				request.getParameter("wt")
				);
		System.out.println(today);
		
		try {
			int result = tservice.todayUpdate(today);
			url = "today?command=list";
			HttpUtil.redirect(response, url);
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			url="error.jsp";
			HttpUtil.forward(request, response, url);
		}

	}

}
