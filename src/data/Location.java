package data;
/**
 * 
 * Class for Location Recommendations 
 * 
 * @author Manuel Ben Bravo pfa698 
 */


public abstract class Location {
	
	private String Location;
	
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
