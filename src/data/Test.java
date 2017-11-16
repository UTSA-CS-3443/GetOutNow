package data;
import java.io.IOException;
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
				
		// Weather converion test.
		System.out.println("Please enter a weather");
		Scanner in = new Scanner(System.in);
		Weather weatherObj = new Weather(in.nextDouble());
		System.out.println(weatherObj.getTemp());
		
		// Prints out the current weather in San Antonio.
		System.out.println("The current weather is " + WeatherScrape.Valhalla() + " in San Antonio, TX.");
		
		// Create a movies object.
		Movies movieObj = new Movies();
		System.out.println(MoviesScrape.Mercuryblast(movieObj.getAnswer()));
		
		Location test = new Restaurant("Test");
		
		// Create a sports object.
		Sports sportObj = new Sports();
		//System.out.println();
		in.close();
	}
}
