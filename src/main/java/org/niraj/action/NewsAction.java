package org.niraj.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value="/news")
public class NewsAction {

	
	@RequestMapping(value="/daily")
	public String dailyNews(){
		System.out.println("This is daily News Module Welcome page");
		return "Your Daily News";
	}
	
}
