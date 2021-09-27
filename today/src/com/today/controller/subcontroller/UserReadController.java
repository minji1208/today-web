package com.today.controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.today.controller.Controller;
import com.today.service.UserService;
import com.today.util.HttpUtil;
import com.today.vo.UserVO;

public class UserReadController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nick = request.getParameter("nick");
		String pwd = request.getParameter("pwd");
		String id = request.getParameter("id");
		String url = null;
		
		UserService service = UserService.getInstance();
		
		try {
			
			
			url="userList.jsp";
		} catch(Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			url="error.jsp";
		}
		HttpUtil.forward(request, response, url);

	}

}
