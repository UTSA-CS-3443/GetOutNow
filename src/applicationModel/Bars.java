package applicationModel;

import java.util.ArrayList;

/**
 * Bars class creates the Bars object, extends Location Class
 * 
 * @author Manuel Ben Bravo, pfa698
 *
 */
public class Bars extends Location {
	
	/**
	 * Takes in ArrayList, should be passed the ArrayList
	 * returned from LocationScrape.scrapeBars 
	 * @param Location
	 */
	public Bars(ArrayList <String> Location) {
		super(Location);
	}

	/**
	 * Returns the WeatherConversion with a Bar Recommendation
	 * @param WeatherConversion 
	 * @return String
	 */
	@Override
	public String getWeather(WeatherConversion temp) {
		String str;
		
		return null;
	}


	/**
	 * Returns a message to pair a movie with a Night
	 * at the Bar
	 * @param Movies 
	 * @return String
	 */
	@Override
	public String getMovie(Movies temp) {
		String str;
		return null;
	}
}
