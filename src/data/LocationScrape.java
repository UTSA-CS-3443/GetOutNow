package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

/**
 * Scrapes web for Locations
 *  
 * @author Manuel Ben Bravo, pfa698
 *
 */
public class LocationScrape {

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
		while(m.find()) {
			locations.add(m.group(1));
		}
		
		//return locations 
		return locations;
	}
	
	/**
	 * Scrapes the Web for CoffeeShops, Adds each CoffeeShop into an
	 * ArrayList<String>
	 * @return ArrayList of CoffeeShops
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
		while(m.find()) {
			locations.add(m.group(1));
		}
		
		//return ArrayList Locations
		return locations;
	}
}

