package testing;
import java.util.Scanner;

import data.*;
/*
 * Patches:
 * 11/15/17 
 * 	Created a scanner called "in" for testing via console -Line 20
 * 			Clarence
 */
/**
 * Main file for testing.
 * @author Daniel Ghazvini dib952
 */

public class TestData {

	public static void main(String[] args) {
				
	
//		Restaurant rObj = new Restaurant(RestaurantScrape.scrapeRestaurant());
//		Coffee cObj = new Coffee(CoffeeScrape.scrapeCoffeeShop());
//		
//		for(int i = 0; i < rObj.getSize(); i++){
//			System.out.println(i+". Restaurant Scrape: " + rObj.getLocation(i));
//
//		}
//		for(int i = 0; i < cObj.getSize(); i++){
//			System.out.println(i +". Coffee Scrape: " + cObj.getLocation(i));
//
//		}
	
		// WeatherConversion conversion test.
//		System.out.print("Please enter the weather in Fahrenheit: ");
//		Scanner in = new Scanner(System.in);
//		WeatherConversion weatherObj = new WeatherConversion(in.nextDouble());
//		System.out.printf("The weather is Celsius is %d\n", (int)weatherObj.toCelsius(weatherObj.getTemp()));
//	
//		// Prints out the current weather in San Antonio.
//		System.out.println("The current weather is " + WeatherScrape.WeatherData() + " in San Antonio, TX.");
		
//		// Create a movies object.
//		Movies movieObj = new Movies();
//		System.out.println(MoviesScrape.MoviesData(movieObj.getAnswer()));
		
		// Create a sports object.
		Sports sportObj = new Sports();
		System.out.println(SportsScrape.SportsData(sportObj.getAnswer()));
	//	in.close();
	}
}
