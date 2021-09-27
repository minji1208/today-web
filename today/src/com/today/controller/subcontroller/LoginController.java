package com.today.controller.subcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.today.controller.Controller;
import com.today.service.UserService;
import com.today.util.HttpUtil;
import com.today.vo.UserVO;

public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		request.setCharacterEncoding("UTF-8");
		UserService service = UserService.getInstance();
		
		UserVO user = new UserVO();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String nick = request.getParameter("nick");
		
			
		try {
			int result = service.userLogin(id, pwd);
			if(result == 1) {
				System.out.println("로그인 성공");
				
				//request.setAttribute("nick", today.getNick());
				url = "main.jsp";
			} else if(result == 0) {
				System.out.println("비밀번호 오류");
				url = "login.jsp";
			} else {
				System.out.println("존재하지 않는 아이디입니다.");
				url = "insert.jsp";
			}
			HttpUtil.redirect(response, url);
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			url="error.jsp";
			HttpUtil.forward(request, response, url);
		}
	}

}
