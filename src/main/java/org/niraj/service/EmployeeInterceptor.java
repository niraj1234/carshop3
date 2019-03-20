package org.niraj.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class EmployeeInterceptor extends HandlerInterceptorAdapter{

	public EmployeeInterceptor() {
         System.out.println("EmployeeInterceptor Contructor has called ===>");	
    }
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		String user = "IN_SESSION";

		if(user.equalsIgnoreCase("IN_SESSION")){
        	System.out.println("User in Session Hence Continue the normal flow. ===>");
        	return true;
        }else{
        	System.out.println("User not is session hence stop the processing ==>");
        	System.out.println("Context Path ==> " + request.getContextPath());
          
        	response.sendRedirect(request.getContextPath()+"/Login");
    		return false;
        }		
	}
	
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
		System.out.println("||||===>postHandle Method called in EmployeeInterceptor ==>");
		
		modelAndView.addObject("MyName", "This is from Interceptor ==> Niraj");
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
		
		System.out.println("||||===>aftreCompletion Method called in EmployeeInterceptor ==>");
		
	}
	
}
