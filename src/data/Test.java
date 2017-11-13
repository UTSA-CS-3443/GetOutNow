package data;
import java.io.IOException;

/**
 * Main file for testing.
 * @author Daniel Ghazvini dib952
 */

public class Test {

	public static void main(String[] args) throws IOException {
				
		// Weather converion test.
		Weather weatherObj = new Weather(96.4);
		System.out.println(weatherObj.getTemp());
		
		// Prints out the current weather in San Antonio.
		System.out.println("The current weather is " + WeatherScrape.Valhalla() + " in San Antonio, TX.");
		
		// Create a movies object.
		Movies movieObj = new Movies();
		System.out.println(MoviesScrape.Mercuryblast(movieObj.getAnswer()));
		
	}
}
