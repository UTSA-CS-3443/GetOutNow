package data;
/**
 * 
 * @author Manue Ben Bravo
 *
 */
public class Coffee extends Location {
	
	private String [] coffeeShops;
	
	
	public Coffee(String Restaurant) {
		super(Restaurant);
	}
	
	
	
	public String getLocation(int index) {

		return this.coffeeShops[index];
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


