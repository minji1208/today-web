package com.today.controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.today.controller.Controller;
import com.today.service.UserService;
import com.today.util.HttpUtil;
import com.today.vo.UserVO;

public class UserInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String nick = request.getParameter("nick");
		
		UserVO user = new UserVO();
		user.setId(id);
		user.setPwd(pwd);
		user.setNick(nick);
		
		UserService service = UserService.getInstance();
		int result = service.userInsert(user);
		System.out.println(result+"행이 추가되었습니다.");
		
		String url = "welcome.jsp";
		
		HttpUtil.redirect(response, url);
	}

}
