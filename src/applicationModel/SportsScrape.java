package applicationModel;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.PrintStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.text.WordUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Class to scrape Sports data from the web.
 * @author Daniel Ghazvini, dib952
 */
public class SportsScrape {
	
	// Stores the home (szTeam1) and away (szTeam2) teams and the time (szTime) they are playing.
	// In the case of Football, the date (szDate) is also given.
	private static String szTeam1;
	private static String szTeam2;
	private static String szTime;
	private static String szDate;
			
	/**
	 * Will return 3 sports game play times depending on what sport the user likes.
	 * @input A character A, B, C, or D that indicates the user's sports preference. 
	 * @return A string showing 3 games of each sport the user likes.
	 */
	public static String SportsData (char input)
	{
		
		String htmlString = null;
		String retString = null;	
		
		// Basketball
		if(input == 'A') 
		{
			try {
				// Connect to the MSN NBA scores page.
				Document doc = Jsoup.connect("https://www.msn.com/en-us/sports/nba/schedule").get();
				Elements results = doc.getAllElements();
				htmlString = results.toString();
			
				Pattern teamsPattern = Pattern.compile("/en-us/sports/nba/(.*)-at-(.*)/game-center.*>(.*)</a>");
				Matcher teamsMatcher = teamsPattern.matcher(htmlString);

				// Method is marked as deprecated - Need to change soon.
				if (teamsMatcher.find())
				{
				    szTeam1 = teamsMatcher.group(1);
				    szTeam2 = teamsMatcher.group(2);
				    szTeam1 = szTeam1.replace("-", " ");
					szTeam2 = szTeam2.replace("-", " ");
				    szTeam1 = WordUtils.capitalize(szTeam1);
					szTeam2 = WordUtils.capitalize(szTeam2);
					szTime = teamsMatcher.group(3);
					if(szTime.equals("Live"))
						szTime = "right now";
				}	
				
				if(szTime.equals("right now"))
					retString = "The " + szTeam1 + " are playing the defending " + szTeam2  + " " + szTime + "!\n";
				else
					retString = "The " + szTeam1 + " are playing the defending " + szTeam2 + " at " + szTime + ".\n";
				
				if (teamsMatcher.find())
				{
				    szTeam1 = teamsMatcher.group(1);
				    szTeam2 = teamsMatcher.group(2);
				    szTeam1 = szTeam1.replace("-", " ");
					szTeam2 = szTeam2.replace("-", " ");
				    szTeam1 = WordUtils.capitalize(szTeam1);
					szTeam2 = WordUtils.capitalize(szTeam2);
					szTime = teamsMatcher.group(3);
					if(szTime.equals("Live"))
						szTime = "right now";
				}
				
				if(szTime.equals("right now"))
					retString += "The " + szTeam1 + " are playing the defending " + szTeam2  + " " + szTime + "!\n";
				else
					retString += "The " + szTeam1 + " are playing the defending " + szTeam2 + " at " + szTime + ".\n";
				
				if (teamsMatcher.find())
				{
   				 	szTeam1 = teamsMatcher.group(1);
   				 	szTeam2 = teamsMatcher.group(2);
   				 	szTeam1 = szTeam1.replace("-", " ");
   				 	szTeam2 = szTeam2.replace("-", " ");
   				 	szTeam1 = WordUtils.capitalize(szTeam1);
   				 	szTeam2 = WordUtils.capitalize(szTeam2);
   				 	szTime = teamsMatcher.group(3);	
					if(szTime.equals("Live"))
						szTime = "right now";
				}
				
				if(szTime.equals("right now"))
					retString += "The " + szTeam1 + " are playing the defending " + szTeam2  + " " + szTime + "!\n";
				else
					retString += "The " + szTeam1 + " are playing the defending " + szTeam2 + " at " + szTime + ".\n";
				
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
				
				Pattern datePattern = Pattern.compile("<div class=\"matchdate hidedownlevel\">\n               (.*)\n.*</div>");
				Matcher dateMatcher = datePattern.matcher(htmlString);
				Pattern timePattern = Pattern.compile("<div class=\"hidedownlevel status size123 \">\n               (.*)\n.*</div>");
				Matcher timeMatcher = timePattern.matcher(htmlString);
				
				// Method is marked as deprecated - Need to change soon.
				if (matcher1.find())
				{
				    szTeam1 = matcher1.group(1);
				    szTeam2 = matcher1.group(2);
				    szTeam1 = szTeam1.replace("-", " ");
					szTeam2 = szTeam2.replace("-", " ");
				    szTeam1 = WordUtils.capitalize(szTeam1);
					szTeam2 = WordUtils.capitalize(szTeam2);
					if (dateMatcher.find())
						szDate = dateMatcher.group(1);
					if (timeMatcher.find())
						szTime = timeMatcher.group(1);
				}	
				
				retString = "The " + szTeam1 + " are playing the defending " + szTeam2 + " on " + szDate + " at " + szTime + ".\n";
				
				if (matcher1.find())
				{
				    szTeam1 = matcher1.group(1);
				    szTeam2 = matcher1.group(2);
				    szTeam1 = szTeam1.replace("-", " ");
					szTeam2 = szTeam2.replace("-", " ");
				    szTeam1 = WordUtils.capitalize(szTeam1);
					szTeam2 = WordUtils.capitalize(szTeam2);
					if (dateMatcher.find())
						szDate = dateMatcher.group(1);
					if (timeMatcher.find())
						szTime = timeMatcher.group(1);
				}
				
				retString += "The " + szTeam1 + " are playing the defending " + szTeam2 + " on " + szDate + " at " + szTime + ".\n";

	
				if (matcher1.find())
				{
				    szTeam1 = matcher1.group(1);
				    szTeam2 = matcher1.group(2);
				    szTeam1 = szTeam1.replace("-", " ");
					szTeam2 = szTeam2.replace("-", " ");
				    szTeam1 = WordUtils.capitalize(szTeam1);
					szTeam2 = WordUtils.capitalize(szTeam2);
					if (dateMatcher.find())
						szDate = dateMatcher.group(1);
					if (timeMatcher.find())
						szTime = timeMatcher.group(1);
				}
				
				retString += "The " + szTeam1 + " are playing the defending " + szTeam2 + " on " + szDate + " at " + szTime + ".\n";

		
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
		else if(input == 'D')
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
				    szTeam1 = matcher1.group(1);
				    szTeam2 = matcher1.group(2);
				    szTeam1 = szTeam1.replace("-", " ");
					szTeam2 = szTeam2.replace("-", " ");
				    szTeam1 = WordUtils.capitalize(szTeam1);
					szTeam2 = WordUtils.capitalize(szTeam2);
					szTime = matcher1.group(3);
					if(szTime.equals("Live"))
						szTime = "right now";
				}	
				
				if(szTime.equals("right now"))
					retString = "The " + szTeam1 + " are playing the defending " + szTeam2  + " " + szTime + "!\n";
				else
					retString = "The " + szTeam1 + " are playing the defending " + szTeam2 + " at " + szTime + ".\n";
				
				if (matcher1.find())
				{
				    szTeam1 = matcher1.group(1);
				    szTeam2 = matcher1.group(2);
				    szTeam1 = szTeam1.replace("-", " ");
					szTeam2 = szTeam2.replace("-", " ");
				    szTeam1 = WordUtils.capitalize(szTeam1);
					szTeam2 = WordUtils.capitalize(szTeam2);
					szTime = matcher1.group(3);
					if(szTime.equals("Live"))
						szTime = "right now";
				}
				
				if(szTime.equals("right now"))
					retString += "The " + szTeam1 + " are playing the defending " + szTeam2  + " " + szTime + "!\n";
				else
					retString += "The " + szTeam1 + " are playing the defending " + szTeam2 + " at " + szTime + ".\n";
				
				if (matcher1.find())
				{
   				 	szTeam1 = matcher1.group(1);
   				 	szTeam2 = matcher1.group(2);
   				 	szTeam1 = szTeam1.replace("-", " ");
   				 	szTeam2 = szTeam2.replace("-", " ");
   				 	szTeam1 = WordUtils.capitalize(szTeam1);
   				 	szTeam2 = WordUtils.capitalize(szTeam2);
   				 	szTime = matcher1.group(3);	
					if(szTime.equals("Live"))
						szTime = "right now";
				}
				
				if(szTime.equals("right now"))
					retString += "The " + szTeam1 + " are playing the defending " + szTeam2  + " " + szTime + "!\n";
				else
					retString += "The " + szTeam1 + " are playing the defending " + szTeam2 + " at " + szTime + ".\n";
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				Document doc = Jsoup.connect("https://www.msn.com/en-us/sports/nfl/schedule").get();
				Elements results = doc.getAllElements();
				htmlString = results.toString();
				
				Pattern pattern1 = Pattern.compile("/en-us/sports/nfl/(.*)-at-(.*)/game-center.*>(.*)</a>");
				Matcher matcher1 = pattern1.matcher(htmlString);
				
				Pattern datePattern = Pattern.compile("<div class=\"matchdate hidedownlevel\">\n               (.*)\n.*</div>");
				Matcher dateMatcher = datePattern.matcher(htmlString);
				Pattern timePattern = Pattern.compile("<div class=\"hidedownlevel status size123 \">\n               (.*)\n.*</div>");
				Matcher timeMatcher = timePattern.matcher(htmlString);

				// Method is marked as deprecated - Need to change soon.
				if (matcher1.find())
				{
				    szTeam1 = matcher1.group(1);
				    szTeam2 = matcher1.group(2);
				    szTeam1 = szTeam1.replace("-", " ");
					szTeam2 = szTeam2.replace("-", " ");
				    szTeam1 = WordUtils.capitalize(szTeam1);
					szTeam2 = WordUtils.capitalize(szTeam2);
					if (dateMatcher.find())
						szDate = dateMatcher.group(1);
					if (timeMatcher.find())
						szTime = timeMatcher.group(1);
				}	
				
				retString += "The " + szTeam1 + " are playing the defending " + szTeam2 + " on " + szDate + " at " + szTime + ".\n";
				
				if (matcher1.find())
				{
				    szTeam1 = matcher1.group(1);
				    szTeam2 = matcher1.group(2);
				    szTeam1 = szTeam1.replace("-", " ");
					szTeam2 = szTeam2.replace("-", " ");
				    szTeam1 = WordUtils.capitalize(szTeam1);
					szTeam2 = WordUtils.capitalize(szTeam2);
					if (dateMatcher.find())
						szDate = dateMatcher.group(1);
					if (timeMatcher.find())
						szTime = timeMatcher.group(1);
				}
				
				retString += "The " + szTeam1 + " are playing the defending " + szTeam2 + " on " + szDate + " at " + szTime + ".\n";
	
				if (matcher1.find())
				{
				    szTeam1 = matcher1.group(1);
				    szTeam2 = matcher1.group(2);
				    szTeam1 = szTeam1.replace("-", " ");
					szTeam2 = szTeam2.replace("-", " ");
				    szTeam1 = WordUtils.capitalize(szTeam1);
					szTeam2 = WordUtils.capitalize(szTeam2);
					if (dateMatcher.find())
						szDate = dateMatcher.group(1);
					if (timeMatcher.find())
						szTime = timeMatcher.group(1);
				}
				
				retString += "The " + szTeam1 + " are playing the defending " + szTeam2 + " on " + szDate + " at " + szTime + ".\n";
		
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return retString;
		// This is for debugging the html source code in case there are errors.
	/*	
		File file = new File("out.txt");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
		System.out.println(htmlString);	
	*/
	}
	
	/*getters*/
	public String getHomeTeam(){
		return this.szTeam2;	
	}
	
	public String getAwayTeam(){
		return this.szTeam1;	
	}
	
	public String getGameTime(){
		return this.szTime;	
	}
}
