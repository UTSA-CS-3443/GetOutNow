package data;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Class to scrape Sports data from the web.
 * @author Daniel Ghazvini, dib952
 */

public class SportsScrape {
	
	// Stores the home (team1) and away (team2) teams and the time they are playing.
	private static String game1team1;
	private static String game1team2;
	private static String game1time;
	
	private static String game2team1;
	private static String game2team2;
	private static String game2time;
	
	private static String game3team1;
	private static String game3team2;
	private static String game3time;
	
	/**
	 * Will return 3 sports game play times depending on what sport the user likes.
	 * @throws IOException 
	 */
	public static String CorellianAle (char input)
	{
		
		String htmlString = null;
		String retString = null;	
		
		// Basketball
		if(input == 'A') 
		{
			try {	
				Document doc = Jsoup.connect("https://www.msn.com/en-us/sports/nba/schedule").get();
				Elements results = doc.getAllElements();
				htmlString = results.toString();
				
				Pattern pattern1 = Pattern.compile("/en-us/sports/nba/(.*)-at-(.*)/game-center.*>(.*)</a>");
				Matcher matcher1 = pattern1.matcher(htmlString);

				// Method is marked as deprecated - Need to change soon.
				if (matcher1.find())
				{
				    game1team1 = matcher1.group(1);
				    game1team2 = matcher1.group(2);
				    game1team1 = game1team1.replace("-", " ");
					game1team2 = game1team2.replace("-", " ");
				    game1team1 = WordUtils.capitalize(game1team1);
					game1team2 = WordUtils.capitalize(game1team2);
					game1time = matcher1.group(3);
				}	
				
				retString = "The " + game1team1 + " are playing the defending " + game1team2 + " at " + game1time + ".\n";
				
				if (matcher1.find())
				{
				    game2team1 = matcher1.group(1);
				    game2team2 = matcher1.group(2);
				    game2team1 = game2team1.replace("-", " ");
					game2team2 = game2team2.replace("-", " ");
				    game2team1 = WordUtils.capitalize(game2team1);
					game2team2 = WordUtils.capitalize(game2team2);
					game2time = matcher1.group(3);
				}
				
				retString += "The " + game2team1 + " are playing the defending " + game2team2 + " at " + game2time + ".\n";
			
				if (matcher1.find())
				{
   				 	game3team1 = matcher1.group(1);
   				 	game3team2 = matcher1.group(2);
   				 	game3team1 = game3team1.replace("-", " ");
   				 	game3team2 = game3team2.replace("-", " ");
   				 	game3team1 = WordUtils.capitalize(game3team1);
   				 	game3team2 = WordUtils.capitalize(game3team2);
   				 	game3time = matcher1.group(3);	
				}
				
				retString += "The " + game3team1 + " are playing the defending " + game3team2 + " at " + game3time + ".\n";
		
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// Football
		else if(input == 'B') 
		{
			try {
				Document doc = Jsoup.connect("https://www.msn.com/en-us/sports/nfl/schedule").get();
				Elements results = doc.getAllElements();
				htmlString = results.toString();
				
				Pattern pattern1 = Pattern.compile("/en-us/sports/nfl/(.*)-at-(.*)/game-center.*>(.*)</a>");
				Matcher matcher1 = pattern1.matcher(htmlString);

				// Method is marked as deprecated - Need to change soon.
				if (matcher1.find())
				{
				    game1team1 = matcher1.group(1);
				    game1team2 = matcher1.group(2);
				    game1team1 = game1team1.replace("-", " ");
					game1team2 = game1team2.replace("-", " ");
				    game1team1 = WordUtils.capitalize(game1team1);
					game1team2 = WordUtils.capitalize(game1team2);
					game1time = matcher1.group(3);
				}	
				
				retString = "The " + game1team1 + " are playing the defending " + game1team2 + " on " + game1time + ".\n";
				
				if (matcher1.find())
				{
				    game2team1 = matcher1.group(1);
				    game2team2 = matcher1.group(2);
				    game2team1 = game2team1.replace("-", " ");
					game2team2 = game2team2.replace("-", " ");
				    game2team1 = WordUtils.capitalize(game2team1);
					game2team2 = WordUtils.capitalize(game2team2);
					game2time = matcher1.group(3);
				}
				
				retString += "The " + game2team1 + " are playing the defending " + game2team2 + " on " + game2time + ".\n";
	
				if (matcher1.find())
				{
				    game3team1 = matcher1.group(1);
				    game3team2 = matcher1.group(2);
				    game3team1 = game3team1.replace("-", " ");
					game3team2 = game3team2.replace("-", " ");
				    game3team1 = WordUtils.capitalize(game3team1);
					game3team2 = WordUtils.capitalize(game3team2);
					game3time = matcher1.group(3);
				}
				
				retString += "The " + game3team1 + " are playing the defending " + game3team2 + " on " + game3time + ".\n";
		
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// Baseball (This won't work right now since the season is over).
		else if(input == 'C')
		{
			/*
			 *  This shouldn't even run at at all. If this if statement passed,
			 *  something went really wrong.
			 */
		}
		
		return retString;
	}
}