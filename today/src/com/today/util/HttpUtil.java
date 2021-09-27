package com.today.util;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil {
	
	public static void redirect(HttpServletResponse response, String url) {
		try {
			response.sendRedirect(url);
		} catch (Exception e) {
			System.out.println("redirect 과정에서 예외 발생 : ");
			e.printStackTrace();
		}
	}
	public static void forward(HttpServletRequest request, HttpServletResponse response, String url) {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		
		try {
			dispatcher.forward(request,  response);
		} catch (Exception e) {
			System.out.println("forward 과정에서 예외 발생 : ");
			e.printStackTrace();
		}
	}

}
