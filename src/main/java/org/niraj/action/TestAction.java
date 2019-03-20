package org.niraj.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TestAction {

	
	private String messageForTest;

	public String getMessageForTest() {
		return messageForTest;
	}

	public void setMessageForTest(String messageForTest) {
		this.messageForTest = messageForTest;
	}


	
	public void initTestAction(){
		System.out.println("inside the initTestAction method");
	}

	
	public void destroyTestAction(){
		System.out.println("inside the destroyTestAction method");
	}

	
	@ModelAttribute
	public void everyTimeCalled(){
		System.out.println("This method will be called every time when TestAction=> anyMethod is getting called == >");
	}

	
	@RequestMapping(value = "/Test", method = RequestMethod.GET)
	public void testDAtaForGetMEthod(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Default call to GET method MSG " + messageForTest);
		System.out.println("Requested Path " + req.getPathInfo());
		try {
			res.getWriter().write(getMessageForTest());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

