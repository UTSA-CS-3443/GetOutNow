package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


/**
 * Scrapes the Web for CoffeeShops
 * 
 * @author Manuel Ben Bravo, pfa698
 */

public class CoffeeScrape {
	
	/**
	 * 
	 * @return ArrayList<String> CoffeeShops
	 */

	public static ArrayList<String> scrapeCoffeeShop() {
		
		/*
		 * Download data from Web into Document doc, copy data from html class "n" into Elements results
		 */
		Document doc = null;
		Elements results = null;
		try {
			doc = Jsoup.connect("https://www.yellowpages.com/search?search_terms=Coffee+%26+Espresso+Restaurants&geo_location_terms=78249").get();
			 results = doc.getElementsByClass("n");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Create ArrayList to hold Locations
		ArrayList <String> locations = new ArrayList<String>();
		
		//Pattern Match for CoffeeShops
		Matcher m = Pattern.compile("\"name\">(.*)</span>").matcher(results.toString());
		
		//Add each Match into ArrayList
		while(m.find()) {
			locations.add(m.group(1));
		}
		
		//Return ArrayList
		return locations;
	}	
}