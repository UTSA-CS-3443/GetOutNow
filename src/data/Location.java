package data;

/*
 * Patch Notes:
 * 	 11/15/17 - 
 * 	- Added instance variables: _address, _state, _city, _zip, stateArray, stateAbrrevArray
 * TODO:
 *	Find a text file with valid US cities/locations
 *
 * 
 */

/**
 * 
 * Class for Location Recommendations
 * 
 * @author Manuel Ben Bravo pfa698 
 */


public abstract class Location {
	
	private String Location; //Name of commercial location
	
	boolean coffee; // User wants CoffeeShop recommendations 
	boolean restaurant; //User wants restaurant recommendations
	
	public Location(String Location) {
		this.Location = Location;
	}
		
	public abstract String getLocation(int index);
	
	/*
	 * Get Weather Data
	 */
	public abstract double getWeather();
	
	/*
	 * Get movie recommendation to pair with a Dinner
	 */
	public abstract String getMovie();
	
}
