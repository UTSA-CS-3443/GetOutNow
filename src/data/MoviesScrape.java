package data;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Class to scrape movie data from the web.
 * @author Daniel Ghazvini, dib952
 */

public class MoviesScrape {
	
	// 3 Movie titles that will be recommended.
	private static String movie1;
	private static String movie2;
	private static String movie3;
	
	/**
	 * Will return 3 movie recommendations based on what the user specified they like.
	 * @param input
	 * @return
	 * @throws IOException
	 */
	public static String Mercuryblast(char input) throws IOException {
		
		String htmlString = null;
		
		if(input == 'A') 
		{
			System.out.println("I will look for Action movies!");
			
			htmlString = "test";
		}
		else if(input == 'B') 
		{			
			Document doc = Jsoup.connect("https://www.flicks.co.nz/now-playing/science-fiction/").get();
			Elements results = doc.getElementsContainingText(".");
			htmlString = results.toString();

			Pattern pattern1 = Pattern.compile(">1. (.*)</a>");
			Matcher matcher1 = pattern1.matcher(htmlString);
			if (matcher1.find())
			    movie1 = matcher1.group(1);
			
			Pattern pattern2 = Pattern.compile(">2. (.*)</a>");
			Matcher matcher2 = pattern2.matcher(htmlString);
			if (matcher2.find())
			    movie2 = matcher2.group(1);		
			
			Pattern pattern3 = Pattern.compile(">3. (.*)</a>");
			Matcher matcher3 = pattern3.matcher(htmlString);
			if (matcher3.find())
			    movie3 = matcher3.group(1);	
			
		}
		else if(input == 'C') 
		{
			System.out.println("I will look for Comedy movies!");
			
			htmlString = "test";
		}
		
		System.out.println("Here are some movies playing that you might like!");
		return movie1 + "\n" + movie2 + "\n" + movie3 + "\n";

	}

}
