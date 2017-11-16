package data;

import java.util.ArrayList;

/**
 * Restaurant class that extends Location 
 * Contains ArrayList of String recommendations
 * of standard lunch/dinner locations 
 * 
 * @author Manuel Ben Bravo 
 */
public class Restaurant extends Location {
	
	
	public Restaurant(ArrayList<String>Locations) {
		super(Locations);
	}
	

	@Override
	public double getWeather() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public String getMovie() {
		// TODO Auto-generated method stub
		return null;
	}


}
