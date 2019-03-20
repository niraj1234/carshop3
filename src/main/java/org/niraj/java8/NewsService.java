package org.niraj.java8;

public class NewsService {

	public String getNews(String p){
		System.out.println("Getting the news by calling Asia News Network WEB-Services API for " + p);
		return "News Got ->"+p;
	}

}
