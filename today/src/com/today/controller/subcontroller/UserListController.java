package com.today.controller.subcontroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.today.controller.Controller;
import com.today.service.UserService;
import com.today.util.HttpUtil;
import com.today.vo.UserVO;

public class UserListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		UserService service = UserService.getInstance();
		
		try {
			ArrayList<UserVO> userList = service.userList();
			request.setAttribute("ulist", userList);
			
			url="userList.jsp";
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			url="error.jsp";
		}
		HttpUtil.forward(request, response, url);

	}

}
