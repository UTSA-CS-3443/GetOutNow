package applicationModel.sportsModel;

public class NFLGame extends Game implements GameInterface{
	//<<constructor>>
	public NFLGame(String home, String away, String time, eLeague eParam) {
		super(home, away, time, eParam);
		validTeamNameArray = new String[NUMBER_OF_NFL_TEAMS];
	}
}
