package applicationModel;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

/**
 * Class to scrape weather data from the web.
 * @author Daniel Ghazvini, dib952
 *
 */
public class WeatherScrape {
		
/**
 * Class to retrieve weather information from webpage.
 * @return The current weather in San Antonio, TX.
 * @throws IOException
 */
	public static String WeatherData() {
		
		try {
		
		// Webpage used to gather weather information in San Antonio.
		Document doc = Jsoup.connect("http://forecast.weather.gov/MapClick.php?lat=29.46&lon=-98.5/").get();
		Elements results = doc.getElementsByClass("myforecast-current-lrg");
		
		// Store class information with up-to-date weather in htmlString.
		String htmlString = results.toString();
		
		// Used to pull only the degrees in Fahrenheit.
		Pattern pattern = Pattern.compile(">(.*)<");
		Matcher matcher = pattern.matcher(htmlString);
		if (matcher.find())
		    htmlString = matcher.group(1);
	
		return htmlString;
		
		} catch (IOException e){
			e.printStackTrace();
			return null;
		}
		
	}
}
