package org.niraj.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.niraj.dao.AppDAO;
import org.niraj.vo.CompanyUserVO;
import org.niraj.vo.CompanyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompanyController {

	@Autowired
	private AppDAO appDaoJdbc;

	@RequestMapping(value = "/Company", method = RequestMethod.GET)
	public String company() {
		System.out.println("Path /Company in GET method");
		return "company";
	}

	
	@RequestMapping(value = "/Company", method = RequestMethod.POST)
	public String companyP() {
		System.out.println("Path /Company in POST method");
		return "company";
	}

	
	@RequestMapping(value = "/Company/Add", method = RequestMethod.GET)
	public String addCompanyForm(@ModelAttribute("company") CompanyVO companyVo, 
								  HttpServletRequest hReq,
								  HttpServletResponse hRes) {
		return "companyAddForm";
	}

	
	@RequestMapping(value="/Company/Add" , method= RequestMethod.POST)
	public ModelAndView addCompany(@Valid @ModelAttribute("company") CompanyVO companyVo , 
									BindingResult result , 
									HttpServletRequest request , 
									HttpServletResponse response){
		String nextAction ="";
		ModelAndView modelView = new ModelAndView();
		if (result.hasErrors()) {
			nextAction = "companyAddForm";
		} else {
			CompanyUserVO companyUser = (CompanyUserVO) request.getSession().getAttribute("USER");
			companyVo.setFkCompanyUseId(companyUser.getUserId());
			String dbResult = appDaoJdbc.insertCompany(companyVo);
			if (dbResult.equalsIgnoreCase("DB_SUCCESS")) {
				nextAction = "companyAddSuccess";
			} else {
				nextAction = "companyAddFailed";
			}
		}
		modelView.setViewName(nextAction);
		return modelView;
	}

	
    @RequestMapping(value = "/Company/View", method = RequestMethod.GET)
	public String viewCompanyForm(HttpServletRequest hReq, HttpServletResponse hRes) {
		List<CompanyVO> companyList = new ArrayList<CompanyVO>();
		CompanyUserVO companyUser = (CompanyUserVO) hReq.getSession().getAttribute("USER");
		companyList = appDaoJdbc.getCompanyByUser(companyUser.getUserId());
		hReq.setAttribute("CompanyList", companyList);
		return "companyView";
	}	

}
