package org.niraj.service;


import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.niraj.vo.CompanyUserVO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CompanyInterceptor extends HandlerInterceptorAdapter {

	private long startTime;
	private long endTime;
	private long total;

	public CompanyInterceptor() {
		System.out.println("CompanyInterceptor constructor has called =>");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("CompanyInterceptor preHandler method has called =>");

		startTime = System.currentTimeMillis();

		CompanyUserVO userInSess = (CompanyUserVO) request.getSession().getAttribute("USER");
		if (userInSess != null) {
			String userValid = (String) request.getSession().getAttribute("USER_AUTH");
			if (userValid.equalsIgnoreCase("USER_VALID")) {
				/*
				 * RequestDispatcher reqDisp =
				 * request.getRequestDispatcher("/Company");
				 * reqDisp.forward(request, response);
				 */
				return true;
			} else {
				request.setAttribute("USER_MESSAGE", "<font color='#DD6655'>Your Credentials are not valid !</font>");
				RequestDispatcher reqDisp = request.getRequestDispatcher("/Login");
				reqDisp.forward(request, response);
				return false;
			}
		} else {
			request.setAttribute("USER_MESSAGE", "<font color='#DD6655'>Please Login !</font>");
			RequestDispatcher reqDisp = request.getRequestDispatcher("/Login");
			reqDisp.forward(request, response);
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		System.out.println("CompanyInterceptor postHandler method has called =>");
		endTime = System.currentTimeMillis();
		total = endTime - startTime;
		request.setAttribute("TotalTime", Long.toString(total));
	}

	
}
