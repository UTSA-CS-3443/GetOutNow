package data;

import java.util.ArrayList;

/**
 * Coffee class extends Location
 * contains ArrayList of coffeeShops with
 * coffeeShops recommendations
 * @author Manuel Ben Bravo
 *
 */
public class Coffee extends Location {
		
	
	public Coffee(ArrayList <String> Location) {
		super(Location);
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


