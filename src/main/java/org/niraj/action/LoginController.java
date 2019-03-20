package org.niraj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.niraj.dao.AppDAO;
import org.niraj.vo.CompanyUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class LoginController {

	@Autowired
	private AppDAO appDaoJdbc;
	
	
	
	@RequestMapping(value="/Login" , method=RequestMethod.GET)
	public String loginForm(@ModelAttribute("login") CompanyUserVO compUserVo ){
		System.out.println("In the login block for login form display");
		return "loginForm";
	}


	@RequestMapping(value="/Login" ,  method=RequestMethod.POST)
	public String loginCheck(@Valid @ModelAttribute("login") CompanyUserVO compUserVo, BindingResult result,
			HttpServletRequest hReq, HttpServletResponse hRes) {	

		if(result.hasErrors()){
			return "loginForm";
		}else{
	
			CompanyUserVO companyUserVo =	appDaoJdbc.getCompanyUser(compUserVo.getUserName());
		    System.out.println("User logged in ==> " + companyUserVo);
		 
			 if((compUserVo.getPassword()).equalsIgnoreCase(companyUserVo.getPassword())){
				 hReq.getSession().setAttribute("USER_AUTH", "USER_VALID");
				 hReq.getSession().setAttribute("USER", companyUserVo);
				 hReq.setAttribute("UserData", companyUserVo); 
				 return "forward:/Company";
			 }else{
				 hReq.setAttribute("USER_MESSAGE", "<font color='#DD6655'>Your Credentials are not valid 1!</font>");
				 hReq.getSession().setAttribute("USER_AUTH", "USER_NOT_VALID");
				 hReq.setAttribute("userMessage", "<font color='#DD6622'>Your Credentials are not valid !!!</font>"); 
				 return "loginForm";
			 }
		}
	}


	@RequestMapping(value="/Logout" , method=RequestMethod.GET)
	public String logout(HttpServletRequest hReq , HttpServletResponse hRes){
		hReq.getSession().invalidate();
		System.out.println("In the login block for login form display");
		return "forward:/Login";
	}

	
}
