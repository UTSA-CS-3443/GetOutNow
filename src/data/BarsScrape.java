package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/**
 * Scrape web for Bars
 * 
 * @author Manuel Ben Bravo, pfa698
 *
 */
public class BarsScrape {
	
	/**
	 * Scrapes the Web for Bars, Adds each Bars into an
	 * ArrayList<String>
	 * @return ArrayList of Bars
	 */
	
	public static ArrayList<String> scrapeBars(){
		/*
		 * Download data from Web into Document doc, copy data from html class "n" into Elements results
		 */
		Document doc = null;
		Elements results = null;
		try {
			doc = Jsoup.connect("https://www.yellowpages.com/search?search_terms=bars+and+clubs&geo_location_terms=78249").get();
			 results = doc.getElementsByClass("n");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Create ArrayList to hold Locations
		ArrayList <String> locations = new ArrayList<String>();
		
		//Pattern Match to find Bars
		Matcher m = Pattern.compile("\"name\">(.*)</span>").matcher(results.toString());
		
		//Add each Bar into ArrayList
		int count = 1;
		while(m.find() && count < 5) {
			locations.add(m.group(1));
			count ++;
		}
		
		//return ArrayList Locations
		return locations;
	}
}