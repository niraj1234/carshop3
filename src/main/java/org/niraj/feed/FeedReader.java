package org.niraj.feed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class FeedReader {

	public static void main(String[] args) {

		String urlString = "http://rss.cnn.com/rss/edition.rss";
		
		readRssFeed(urlString);
	}

	private static void readRssFeed(String urlString) {
	
		URL urlData;
		try {
			urlData = new  URL(urlString);
			BufferedReader buffReader =  new BufferedReader(new InputStreamReader(urlData.openStream()));
			String sourceCode = "";
			String line;
			while((line = buffReader.readLine()) != null ){
				if(line.contains("<title>")){
					int firstPosition = line.indexOf("<title>");
					String temp = line.substring(firstPosition);
					temp = temp.replace("<title>", "");
					int lastPosition = line.indexOf("</title>");
					temp = temp.substring(lastPosition);
					sourceCode = 	temp + "\n" ;
				}
			}
			buffReader.close();
          System.out.println("============ Data coming from the Given RSS Feed ============" );
          System.out.println(sourceCode);
          System.out.println("============ Feed Read Completed ============" );
          
		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	
}
