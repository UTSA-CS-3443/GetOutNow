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
	
//	private static String game3team1;
//	private static String game3team2;
	
	/**
	 * Will return 3 sports game play times depending on what sport you like.
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
				
				Pattern pattern2 = Pattern.compile("/en-us/sports/nba/(.*)-at-(.*)/game-center.*>(.*)</a>");
				Matcher matcher2 = pattern2.matcher(htmlString);
				
				if (matcher2.find())
				{
				    game2team1 = matcher1.group(1);
				    game2team2 = matcher1.group(2);
				    game2team1 = game1team1.replace("-", " ");
					game2team2 = game1team2.replace("-", " ");
				    game2team1 = WordUtils.capitalize(game1team1);
					game2team2 = WordUtils.capitalize(game1team2);
					game2time = matcher1.group(3);
				}
				
				retString += "The " + game2team1 + " are playing the defending " + game2team2 + " at " + game2time + ".\n";
			/*	
				Pattern pattern3 = Pattern.compile("/name/.*>(.*)</a>.*");
				Matcher matcher3 = pattern3.matcher(htmlString);
				if (matcher1.find())
				    game2team1 = matcher1.group(1);
				
				Pattern pattern4 = Pattern.compile("/name/.*>(.*)</a>.*");
				Matcher matcher4 = pattern4.matcher(htmlString);
				if (matcher1.find())
				    game2team2 = matcher1.group(1);
				
				retString += "The " + game2team2 + " are playing the defending " + game2team1 + "\n";
				
				if (matcher1.find())
				    game3team1 = matcher1.group(1);
				
				if (matcher1.find())
				    game3team2 = matcher1.group(1);
				
				retString += "The " + game3team2 + " are playing the defending " + game3team1 + "\n";
			*/		
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// Football
		else if(input == 'B') 
		{/*
			try {
				Document doc = Jsoup.connect("http://www.espn.com/nfl/schedule").get();
				Elements results = doc.getElementsContainingText(".");
				htmlString = results.toString();
				
				Pattern pattern1 = Pattern.compile("/name/.*>(.*)</a>.*");
				Matcher matcher1 = pattern1.matcher(htmlString);
				if (matcher1.find())
				    game1team1 = matcher1.group(1);
				
				Pattern pattern2 = Pattern.compile("/name/.*>(.*)</a>.*");
				Matcher matcher2 = pattern2.matcher(htmlString);
				if (matcher1.find())
				    game1team2 = matcher1.group(1);
				
				retString = "The " + game1team2 + " are playing the defending " + game1team1 + "\n";
				
				Pattern pattern3 = Pattern.compile("/name/.*>(.*)</a>.*");
				Matcher matcher3 = pattern3.matcher(htmlString);
				if (matcher1.find())
				    game2team1 = matcher1.group(1);
				
				Pattern pattern4 = Pattern.compile("/name/.*>(.*)</a>.*");
				Matcher matcher4 = pattern4.matcher(htmlString);
				if (matcher1.find())
				    game2team2 = matcher1.group(1);
				
				retString += "The " + game2team2 + " are playing the defending " + game2team1 + "\n";
				
				if (matcher1.find())
				    game3team1 = matcher1.group(1);
				
				if (matcher1.find())
				    game3team2 = matcher1.group(1);
				
				retString += "The " + game3team2 + " are playing the defending " + game3team1 + "\n";
					
			} catch (IOException e) {
				e.printStackTrace();
			}*/
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