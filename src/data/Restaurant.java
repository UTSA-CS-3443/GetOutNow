package data;
/**
 * 
 * @author Manuel Ben Bravo pfa698 
 *
 */


public abstract class Restaurant {
	
	private String Restaurant;
	
	public Restaurant(String Restaurant) {
		this.Restaurant = Restaurant;
	}
	
	public abstract void add();
	
	public abstract String getRestaurant();
	
	
}
