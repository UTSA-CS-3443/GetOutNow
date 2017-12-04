package applicationModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Scrapes web for Restaurants
 * 
 * @author Manuel Ben Bravo, pfa698
 */
public class RestaurantScrape {
	
	/**
	 * Scrapes the Web for Restaurants, Adds each restaurant into an
	 * ArrayList<String>
	 * @return ArrayList of Restaurants
	 */
	public static ArrayList<String> scrapeRestaurant() {
		
		/*
		 * Download data from Web into Document doc, copy data from html class "n" into Elements results
		 */
		Document doc = null;
		Elements results = null;
		try {
			doc = Jsoup.connect("https://www.yellowpages.com/search?search_terms=restaurant&geo_location_terms=78249").get();
			 results = doc.getElementsByClass("n");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Create ArrayList to store strings
		ArrayList<String> locations = new ArrayList<String>();
		
		// Pattern Match for results of Restaurant Names
		Matcher m = Pattern.compile("<span? itemprop=\"name\">(.*)</span>").matcher(results.toString());
		//Add each match into ArrayList 
		int count = 1;
		while(m.find() && count < 5) {
			locations.add(m.group(1));
			count++;
		}
		
		//return locations 
		return locations;
	}
}