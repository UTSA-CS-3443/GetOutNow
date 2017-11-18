package data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
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

public class Test {

	public static void main(String[] args) throws IOException {
				
	/*	
		Restaurant rObj = new Restaurant(LocationScrape.scrapeRestaurant());
		Coffee cObj = new Coffee(LocationScrape.scrapeCoffeeShop());
		
		for(int i = 0; i < rObj.getSize(); i++){
			System.out.println(i+". Restaurant Scrape: " + rObj.getLocation(i));

		}
		for(int i = 0; i < cObj.getSize(); i++){
			System.out.println(i +". Coffee Scrape: " + cObj.getLocation(i));

		}
		
		// Weather converion test.
		System.out.print("Please enter the weather in Fahrenheit: ");
		Scanner in = new Scanner(System.in);
		Weather weatherObj = new Weather(in.nextDouble());
		System.out.printf("The weather is Celsius is %d\n", (int)weatherObj.toCelsius(weatherObj.getTemp()));
	*/
		// Prints out the current weather in San Antonio.
		System.out.println("The current weather is " + WeatherScrape.Valhalla() + " in San Antonio, TX.");
	/*	
		// Create a movies object.
		Movies movieObj = new Movies();
		System.out.println(MoviesScrape.MercuryBlast(movieObj.getAnswer()));
	*/	
		// Create a sports object.
		Sports sportObj = new Sports();
		System.out.println(SportsScrape.CorellianAle(sportObj.getAnswer()));
	//	in.close();
	}
}
