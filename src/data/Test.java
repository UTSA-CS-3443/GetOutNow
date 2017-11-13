package data;
import java.io.IOException;

/**
 * Main file for testing.
 * @author Daniel Ghazvini dib952
 */

public class Test {

	public static void main(String[] args) throws IOException {
				
		// Testing out with Fahrenheit
		Weather weatherObj = new Weather(96.4);
		System.out.println(weatherObj.getTemp());
		
		// Prints out the current weather in San Antonio.
		System.out.println(WeatherScrape.Valhalla());
		
		
	}

}
