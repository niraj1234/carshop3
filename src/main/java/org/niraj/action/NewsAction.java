package org.niraj.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/news")
public class NewsAction {

	
	@RequestMapping(value="/daily")
	public String dailyNews(){
		System.out.println("This is daily News Module Welcome page");
		System.out.println("This is new line added");
		return "dailyNews";
	}
	
}
