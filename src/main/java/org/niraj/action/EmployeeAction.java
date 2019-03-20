package org.niraj.action;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.niraj.dao.AppDAO;
import org.niraj.service.LogSpring;
import org.niraj.util.SendGmail;
import org.niraj.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/Employee")
public class EmployeeAction implements EmployeeInter {
		
	@Autowired
	private SendGmail sendGmail;
	
	@Autowired
    private AppDAO appDaoJDBC;
	
//	@Autowired
//	private LogSpring logSpr;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomeEmployee(HttpServletRequest hReq, HttpServletResponse hResp) {
		System.out.println("EmployeeAction welcomeEmployee() method call ==>");
		return "employeeWelcome";
	}

	
	
	@RequestMapping(value = "/View", method = RequestMethod.GET)
	public ModelAndView viewEmployee(HttpServletRequest hReq, HttpServletResponse hResp) {
		System.out.println("EmployeeAction viewEmployee() method call ==>");
        ModelAndView modelView = new ModelAndView("employeeView");
		ArrayList<EmployeeVO> employeeList;
		employeeList = (ArrayList<EmployeeVO>) appDaoJDBC.getAllEmployee();
        modelView.addObject("MyName2", "Niraj2 in View Block");
		hReq.setAttribute("employeeList", employeeList);
		return modelView;
	}

	
	
	@RequestMapping("/Add")
	public ModelAndView addEmployee(@Valid @ModelAttribute("employee") EmployeeVO empVo, BindingResult result,
			HttpServletRequest hReq, HttpServletResponse hResp) {
		ModelAndView modelView = null;

		if (result.hasErrors()) {
//			logSpr.error(this.getClass().getName(), "DATA sent by user is wrong ::"+empVo.toString());
			modelView = new ModelAndView("employeeAdd");
		} else {
			appDaoJDBC.insertEmployee2(empVo);
//			logSpr.log(this.getClass().getName(), "DATA CORRECT : INSERTED IN DB ==> "+ empVo.toString());
			modelView = new ModelAndView("redirect:/Employee/View");
		}

		return modelView;
	}

	
	
	@RequestMapping(value = "/Update/{empId}", method = RequestMethod.GET)
	public ModelAndView updateEmployeeForm(@ModelAttribute("employee") EmployeeVO empVo, HttpServletRequest hReq,
			HttpServletResponse hResp, @PathVariable("empId") int empId) {
		ModelAndView modelView = null;

		modelView = new ModelAndView("employeeUpdateForm");

		EmployeeVO employeeVo = appDaoJDBC.getEmployee(empId);
		modelView.addObject("employee", employeeVo);
		modelView.addObject("empId", employeeVo.getEmployeeId());
		return modelView;
	}

	
	
	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@Valid @ModelAttribute("employee") EmployeeVO empVo, BindingResult result,
			HttpServletRequest hReq, HttpServletResponse hResp) {

		System.out.println("Data Sent in Update Employee => " + empVo.toString());

/*		String empIdStr = hReq.getParameter("empId");
		int empId = Integer.parseInt(empIdStr);
*/
		ModelAndView modelView = null;

		if (result.hasErrors()) {
			modelView = new ModelAndView("employeeUpdateForm");
//			modelView.addObject("empId", empId);

		} else {
			String updateResult = appDaoJDBC.updateEmployee(empVo, empVo.getEmployeeId());
			if (updateResult.equalsIgnoreCase("SUCCESS")) {
				modelView = new ModelAndView("employeeSuccess");
			} else {
				modelView = new ModelAndView("employeeFailed");
			}
		}

		return modelView;
	}

	
	
	@RequestMapping(value = "/Delete/{empId}")
	public String deleteEmployee(HttpServletRequest hReq, HttpServletResponse hResp, @PathVariable("empId") int empId) {
		System.out.println("Employee Delete Block " + empId);
		String deleteStatus = appDaoJDBC.deleteEmployee(empId);
		String nextAction = "";
        ModelAndView modelView = new ModelAndView();
        modelView.addObject("MyName3", "Niraj3 in Delete Block");
		
		if (deleteStatus.equalsIgnoreCase("SUCCESS")) {
		
			nextAction = "forward:/Employee/View";
		} else {
			nextAction = "employeeFailed";
		}

		return nextAction;
	}    
    
}
