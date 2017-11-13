package data;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Class to scrape movie data from the web.
 * @author Daniel Ghazvini, dib952
 */

public class MoviesScrape {
	
	// 3 Movie titles that will be recommended.
	private String movie1;
	private String movie2;
	private String movie3;
	
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
			System.out.println("I will look for Science fiction movies!");
			
			Document doc = Jsoup.connect("https://www.flicks.co.nz/now-playing/science-fiction/").get();
			Elements results = doc.select("/movie[href]");
			
			htmlString = results.toString();	
		}
		else if(input == 'C') 
		{
			System.out.println("I will look for Comedy movies!");
			
			htmlString = "test";
		}
		
		return htmlString;

	}

}
