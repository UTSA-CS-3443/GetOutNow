package applicationModel;

import java.util.ArrayList;

/**
 * Restaurant class that extends Location 
 * Contains ArrayList of String recommendations
 * of standard lunch/dinner locations 
 * 
 * @author Manuel Ben Bravo, pfa698
 */
public class Restaurant extends Location {
	
	/**
	 * Creates the Restaurant object 
	 * Takes in ArrayList, should be passed as parameter
	 * what is return from LocationScrape.scrapeRestraurants
	 * 
	 * @param Locations
	 */
	public Restaurant(ArrayList<String>Locations) {
		super(Locations);
	}
	
	/**
	 * Returns the WeatherConversion with a Restaurant Recommendation
	 * @param WeatherConversion 
	 * @return String
	 */
	@Override
	public String getWeather(WeatherConversion temp) {
		String str;
		return null;
	}

	/**
	 * Returns a message to pair a movie with a Restaurant
	 * @param Movies
	 * @return String 
	 */
	@Override
	public String getMovie(Movies temp) {
		String str;
		return null;
	}
}
