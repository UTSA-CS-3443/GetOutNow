package data;

import java.util.ArrayList;

/**
 * Coffee class extends Location
 * contains ArrayList of coffeeShops with
 * coffeeShops recommendations
 * @author Manuel Ben Bravo, pfa698
 *
 */
public class Coffee extends Location {
		
	/**
	 * Creates the Coffee Object, should be passed as parameter
	 * what is returned from LocationScrape.scrapeCoffeeShops
	 * @param Location
	 */
	public Coffee(ArrayList <String> Location) {
		super(Location);
	}

	/**
	 * Returns the WeatherConversion with a CoffeShop Recommendation
	 * @param WeatherConversion 
	 * @return String
	 */
	@Override
	public String getWeather(WeatherConversion temp) {
		String str;
		return null;
	}

	/**
	 * Returns a message to pair a movie with a CoffeeShop
	 * @param Movies
	 * @return String 
	 */
	@Override
	public String getMovie(Movies temp) {
		String str;
		return null;
	}

}


