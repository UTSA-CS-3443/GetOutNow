package data;
import java.util.Scanner;

/**
 * Main file for testing.
 * @author Daniel Ghazvini
 *
 */

public class Test {

	public static void main(String[] args) {
		
		System.out.println("This is the main Test file!");
		
		// Testing out with Fahrenheit
		Weather weatherObj = new Weather(96.4);
		System.out.println(weatherObj.getTemp());
		
		
		System.out.println("Enter your City:");
		Scanner scanner = new Scanner(System.in);
		String cityName = scanner.nextLine();
		System.out.println("Your city is " + cityName);
		
		//WeatherScrape.java()

	}

}
