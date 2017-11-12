package data;

/**
 * Class for performing weather conversions.
 * @author Daniel Ghazvini dib952
 *
 */
public class Weather {
	
	private double fahrenheit;
	private double celsius;
	private boolean isFahrenheit;
	
	/**
	 * Constructor
	 */
	public Weather(double input) {
		this.fahrenheit = input;
		this.isFahrenheit = true;
	}
	
	/**
	 * Converts Celsius to Fahrenheit
	 * @param degrees in Celsius
	 * @return degrees in Fahrenheit
	 */
	public double toFahrenheit(double input) {
		double returnTemp;
		returnTemp = (input*1.8) + 32;
		return returnTemp;
	}
	
	/**
	 * Converts Fahrenheit to Celsius
	 * @param degrees in Fahrenheit
	 * @return degrees in Celsius
	 */
	public double toCelsius(double input) {
		double returnTemp;
		returnTemp = (input-32) * .5556;
		return returnTemp;
	}
	
	/**
	 * Returns the current temperature, whether in Celsius or Fahrenheit
	 * @return
	 */
	public double getTemp() {
		if(this.isFahrenheit == true)
			return this.fahrenheit;
		else
			return this.celsius;		
	}
}
