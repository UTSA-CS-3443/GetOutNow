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
	 * @param input, a character value specifying what type of movies they like.
	 */
	public static String MoviesData (char input) {
		
		String htmlString = null;
		
		if(input == 'A') 
		{			
			try {
			Document doc = Jsoup.connect("https://www.showtimes.com/now-playing-movies/action-films/").get();
			Elements results = doc.getElementsContainingText(".");
			htmlString = results.toString();

			Pattern pattern1 = Pattern.compile("<h3 class=\"movie-title\">.*>(.*)</a>");
			Matcher matcher1 = pattern1.matcher(htmlString);
			
			if (matcher1.find())
			    movie1 = matcher1.group(1);
			
			if (matcher1.find())
			    movie2 = matcher1.group(1);		
			
			if (matcher1.find())
			    movie3 = matcher1.group(1);	
			
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		else if(input == 'B') 
		{
			try {
			Document doc = Jsoup.connect("https://www.showtimes.com/now-playing-movies/sci-fi-films/").get();
			Elements results = doc.getElementsContainingText(".");
			htmlString = results.toString();

			Pattern pattern1 = Pattern.compile("<h3 class=\"movie-title\">.*>(.*)</a>");
			Matcher matcher1 = pattern1.matcher(htmlString);
			
			if (matcher1.find())
			    movie1 = matcher1.group(1);
			
			if (matcher1.find())
			    movie2 = matcher1.group(1);		
			
			if (matcher1.find())
			    movie3 = matcher1.group(1);	
			
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		else if(input == 'C') 
		{		
			try {
			Document doc = Jsoup.connect("https://www.showtimes.com/now-playing-movies/comedy-films/").get();
			Elements results = doc.getElementsContainingText(".");
			htmlString = results.toString();
			
			Pattern pattern1 = Pattern.compile("<h3 class=\\\"movie-title\\\">.*>(.*)</a>");
			Matcher matcher1 = pattern1.matcher(htmlString);
			
			if (matcher1.find())
			    movie1 = matcher1.group(1);
			
			if (matcher1.find())
			    movie2 = matcher1.group(1);		
			
			if (matcher1.find())
			    movie3 = matcher1.group(1);	
			
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		
		System.out.println("Here are some movies playing that you might like!");
		return movie1 + "\n" + movie2 + "\n" + movie3;

	}

}
