package applicationModel.sportsModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Classes that inherit from Game.java:
 * 		NBAGame.java
 * 		NFLGame.java
 */
public class Game implements GameInterface {
	
	String homeTeamName;	//name of the defending team
	String awayTeamName;	//name of the visiting team
	String gameTime;		//when the game begins
	String dataTextFilePath;
	
	protected String[] validTeamNameArray; 
	protected eLeague e;	//Either NBA or NFL (defined in GameInterface)
	
	
	//<<Constructor>>
	public Game(String home, String away, String time, eLeague eParam) {
		this.homeTeamName = home;
		this.awayTeamName = away;
		this.gameTime = time;
		this.e = eParam;
	}
	
	
	/*
	 * Fills validTeamNameArray by opening data file and reading in
	 * team names strings.
	 * @param teamM
	 * @param dataFilePath
	 */
    protected void scanTeamNames(String[] teamM, final String dataFilePath){
        Scanner in = null;

        //try to open file
        try{
            in = new Scanner(new File(dataFilePath));
        }catch(FileNotFoundException e){
            exitError("Invalid file path: " + dataFilePath, 
            		"scanTeamNames();", FILE_NOT_FOUND_ERROR);
        }
       
        //read in every team name in the text file
        for(int t = 0; in.hasNext(); t++){
            teamM[t] = in.nextLine();
        }

        in.close();
    }
   
   
    /*
     * First checks if the absolute path of the passed in team's logo
     * is valid/exists. Returns the string of the path relative to the
     * sports controller.
     * @return relativePath
     */
	public String returnTeamLogoPath(String fullTeamName) {
		// only get the last word of a string and add ".png" extension
		final String FILE_NAME = fullTeamName.substring(fullTeamName.lastIndexOf(" ")+1) + ".png";
		String absolutePath = new String();
		
		//assign string to absolutePath
		if(this.e == eLeague.NBA)
			 absolutePath = "/src/images/nba_images/" + FILE_NAME;
		else if(this.e == eLeague.NFL)
			 absolutePath = "/src/images/nfl_images/" + FILE_NAME;
		
		if(new File(absolutePath).exists())
			exitError("Invalid file path: " + absolutePath, "returnTeamLogoPath();",
					INVALID_TEAM_NAME_ERROR);
		
 
		//return path relative to controller
		return "images/nfl_images/" + FILE_NAME;
	}	
	
	/*
	 * Validate 
	 */
	public void validateGameInfo() {
		 
		 	if(e == eLeague.NBA) {
		 		this.dataTextFilePath = "GetOutNow-master/src/data/NBA.txt";
		 	}else if(e == eLeague.NFL)
		 		this.dataTextFilePath = "GetOutNow-master/src/data/NFL.txt";
		 	
		 	System.out.println(homeTeamName);
			scanTeamNames(validTeamNameArray, dataTextFilePath);
			
			
			validTeamName(homeTeamName);
			validTeamName(awayTeamName);
			
			//if both teams have the same name, exit error
			if(homeTeamName.compareTo(awayTeamName) == 0)
				exitError("NBA home & away team have same name: " + 
						homeTeamName, "validateGameInfo()", SAME_TEAM_NAME_ERROR);
	}
	 
	/*
	 * Searches for the passed in keyName inside of validTeams array.
	 * Returns if the passed in team is valid, exit error otherwise.
	 */
	protected void validTeamName(String keyName){
		
		String[] validTeams = this.validTeamNameArray;
	     //for every name in validTeamNames
	     for(int t = 0; t < validTeams.length; t++){
	         if(validTeams[t].compareTo(keyName) == 0)
	             return;
	     }
	     
	     //not found, exit error
	     exitError("Invalid team name: " + keyName, 
	     		"validTeamName(); ", INVALID_TEAM_NAME_ERROR);
	}
	
	/*
	 * Prints the passed in errorMessage along with the function name
	 * this method is called in. Then system exits.
	 */
	public void exitError(String errorMessage, String funcName, int errorInt){
        System.err.println(errorMessage);
        System.err.println("Inside " + funcName);
        
        System.exit(errorInt);
    }
	
	/*getters*/
	public String getHomeTeam() {
		return homeTeamName;
	}
	
	public String getAwayTeam() {
		return awayTeamName;
	}
	
	public String getGameTime() {
		return gameTime;
	}
}
