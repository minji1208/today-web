package com.today.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.today.controller.subcontroller.LoginController;
import com.today.controller.subcontroller.LogoutController;
import com.today.controller.subcontroller.TitleDeleteController;
import com.today.controller.subcontroller.TitleListController;
import com.today.controller.subcontroller.TodayInsertController;
import com.today.controller.subcontroller.TodayMainController;
import com.today.controller.subcontroller.TodayReadController;
import com.today.controller.subcontroller.TodayUpdateController;
import com.today.controller.subcontroller.UserInsertController;
import com.today.controller.subcontroller.UserListController;
import com.today.controller.subcontroller.UserReadController;

@WebServlet("/today")
public class FrontController extends HttpServlet{
	
	String charset = null;
	HashMap<String, Controller> list = null;
	
	public void init(ServletConfig config) throws ServletException{
		list = new HashMap<String, Controller>();
		list.put("insert", new UserInsertController());
		list.put("tinsert", new TodayInsertController());
		list.put("list", new TitleListController());
		list.put("ulist", new UserListController());
		list.put("main", new TodayMainController());
		list.put("login", new LoginController());
		list.put("read", new TodayReadController());
		list.put("uread", new UserReadController());
		list.put("update", new TodayUpdateController());
		list.put("delete", new TitleDeleteController());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String command = req.getParameter("command");
		System.out.println("command : "+command);
		
		if(command == null) {
			command = "list";
		}
		
		Controller subController = list.get(command);
		subController.execute(req, resp);
	}
	


}
