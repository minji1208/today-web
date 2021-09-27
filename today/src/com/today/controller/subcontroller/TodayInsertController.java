package com.today.controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.today.controller.Controller;
import com.today.service.TodayService;
import com.today.util.HttpUtil;
import com.today.vo.TodayVO;

public class TodayInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tt = request.getParameter("tt");
		String dt = request.getParameter("dt");
		String wt = request.getParameter("wt");
		
		TodayVO today = new TodayVO();
		today.setTt(tt);
		today.setDt(dt);
		today.setWt(wt);
		
		TodayService tservice = TodayService.getInstance();
		int result = tservice.todayInsert(today);
		System.out.println(result + "���� �߰��Ǿ����ϴ�.");
		
		String url = "today?command=list";
		
		HttpUtil.redirect(response, url);

	}

}
