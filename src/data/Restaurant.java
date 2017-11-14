package data;

/**
 * Restaurant class that extends Location 
 * Contains string[] with list of recommendations
 * of standard lunch/dinner locations 
 * 
 * @author Manuel Ben Bravo 
 */
public class Restaurant extends Location {
	
	private String [] Restaurants;
	
	public Restaurant(String Restaurant) {
		super(Restaurant);
	}
	
	
	
	public String getLocation(int index) {

		return this.Restaurants[index];
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
