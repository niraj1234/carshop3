package org.niraj.feed;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/*
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedOutput;

public class RssFeedCreator {

	public static void main(String[] args) {

		      String feedType = "rss_2.0";
			   String fileName = "feed.xml";

			   SyndFeed feed = new SyndFeedImpl();
			   feed.setFeedType(feedType);

			   feed.setTitle("Programming Videos");
			   feed.setLink("http://www.netroxtech.com");

		       List entries  = new ArrayList();
		       SyndEntry entry;
		       SyndContent description;

		       entry = new SyndEntryImpl();
		       entry.setTitle("How to create RSS feed");
		       entry.setLink("http://www.iansnews.net");
//		       entry.setPublishDate(DATE_PARSER.parse("2016-06-08"));

		       description = new SyndContentImpl();
		       description.setType("text/plain");
		       description.setValue("Cool JAva Snippet");
		       entry.setDescription(description);
		       entries.add(entry);

		       feed.setEntries(entries);
		       Writer writer;

		try {
			writer = new FileWriter(fileName);
			SyndFeedOutput output = new SyndFeedOutput();
			output.output(feed, writer);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FeedException e) {
			e.printStackTrace();
		}
	
	}

}
*/