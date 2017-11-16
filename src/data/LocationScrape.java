package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

/**
 * Scrapes web for locations
 *  
 * @author Manuel Ben Bravo
 *
 */
public class LocationScrape {

	public static ArrayList<String> scrapeRestaurant() {
		Document doc = null;
		Elements results = null;
		try {
			doc = Jsoup.connect("https://www.yellowpages.com/search?search_terms=restaurant&geo_location_terms=78249").get();
			 results = doc.getElementsByClass("n");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Store class information with up-to-date restaurant inputin htmlString.

		ArrayList<String> locations = new ArrayList<String>();
		Matcher m = Pattern.compile("<span? itemprop=\"name\">(.*)</span>").matcher(results.toString());
		
		while(m.find()) {
			locations.add(m.group(1));
		}
		return locations;
	}
	
	public static ArrayList<String> scrapeCoffeeShop() {
		Document doc = null;
		Elements results = null;
		try {
			doc = Jsoup.connect("https://www.yellowpages.com/search?search_terms=Coffee+%26+Espresso+Restaurants&geo_location_terms=78249").get();
			 results = doc.getElementsByClass("n");

		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList <String> locations = new ArrayList<String>();
		
		Matcher m = Pattern.compile("\"name\">(.*)</span>").matcher(results.toString());
	
		while(m.find()) {
			locations.add(m.group(1));
		}
		return locations;
	}	
		
}

