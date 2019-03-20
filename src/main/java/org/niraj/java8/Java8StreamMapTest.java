package org.niraj.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Java8StreamMapTest {

	public static void main(String[] args) {

		EmailService es = new EmailService();
		NewsService  ns = new NewsService();
		NewsDao newsDao = new NewsDao();
		
		Map<String, Double> newsMap = new HashMap<>();
		newsMap.put("TOI", 6.9);
		newsMap.put("ANI", 3.9);
		newsMap.put("CNN", 4.9);
		newsMap.put("BBC", 3.9);
		newsMap.put("PICOM", 1.9);
		newsMap.put("NYT", 3.9);
		newsMap.put("SMH", 1.9);
		newsMap.put("MIRROR", 4.9);
		newsMap.put("WP", 1.2);


		
		
		
		
/*	    Set<String> keys = productPrice.keySet();
		keys.forEach(e -> {
			System.out.print(e+"\t");
			System.out.println(productPrice.get(e));
		});	    
*/	
	
//		productPrice.forEach((k,v) -> System.out.println(k+"\t"+v));
		
		// You can call the method on another class and perform some work
		newsMap.forEach((k, v) -> {
			ns.getNews(k);
			es.sendMail(k, v);
			newsDao.insertNews(k);

			System.out.println("Process completed for " + k.toString());
			System.out.println("");
			System.out.println("============= New Data Fetch Start ============");
		});		
		
		
	}

}
