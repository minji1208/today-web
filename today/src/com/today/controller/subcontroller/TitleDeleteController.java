package com.today.controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.today.controller.Controller;
import com.today.service.TodayService;
import com.today.util.HttpUtil;

public class TitleDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		String tt = request.getParameter("tt");
		
		TodayService tservice = TodayService.getInstance();
		
		try {
			int result = tservice.todayDelete(tt);
			
			url = "today?command=list";
			HttpUtil.redirect(response, url);
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			url = "error.jsp";
			HttpUtil.forward(request, response, url);
		}

	}

}
