package data;

import java.util.ArrayList;


/**
 * 
 * Class for Location Recommendations
 * 
 * @author Manuel Ben Bravo pfa698 
 */


public abstract class Location {
	
	private ArrayList <String> Location; //Name of commercial locations
	
	/**
	 * Creates the Location object 
	 * @param Location
	 */
	public Location(ArrayList <String> Location) {
		this.Location = new ArrayList<String>(Location.size());
		for(String s: Location) {
			this.Location.add(s);
		}
	}
		/**
		 * Get String of Location from specific index in 
		 * ArrayList
		 * @param index
		 * @return String Location
		 */
	public String getLocation(int index) {
		return this.Location.get(index);
	}
	
	/** 
	 * Get Weather Data to recommend pairing with a Location
	 * @param Weather object
	 * @return String 
	 */
	public abstract String getWeather(Weather temp);
	
	/**
	 * Get movie recommendation to pair with a Location
	 * @param Movies 
	 * @return String
	 */
	public abstract String getMovie(Movies temp);
	
	/**
	 * Returns the size of the Location ArrayList 
	 */
	public int getSize() {
		return this.Location.size();
	}

}
