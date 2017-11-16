package data;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

/**
 * 
 * @author Manuel Ben Bravo
 *
 */
public class LocationScrape {

	public static String scrapeRestaurant() {
		Document doc = null;
		Elements results = null;
		try {
			doc = Jsoup.connect("https://www.yellowpages.com/search?search_terms=restaurant&geo_location_terms=78249").get();
			 results = doc.getElementsByClass("n");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Store class information with up-to-date restaurant in htmlString.
		String htmlString = results.toString();
		
		Pattern pattern = Pattern.compile("\"business-name\">(.*)<");
		Matcher matcher = pattern.matcher(htmlString);
		if (matcher.find())
		    htmlString = matcher.group(1);
	
		return htmlString;
	}
	
	public static String scrapeCoffeeShop() {
		Document doc = null;
		Elements results = null;
		try {
			doc = Jsoup.connect("https://www.yellowpages.com/search?search_terms=Coffee+%26+Espresso+Restaurants&geo_location_terms=78249").get();
			 results = doc.getElementsByClass("n");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Store class information with up-to-date restaurant in htmlString.
		String htmlString = results.toString();
		
		Pattern pattern = Pattern.compile("\"name\">(.*)</span>");
		Matcher matcher = pattern.matcher(htmlString);
		if (matcher.find())
		    htmlString = matcher.group(1);
	
		return htmlString;
	}
		
		
}

