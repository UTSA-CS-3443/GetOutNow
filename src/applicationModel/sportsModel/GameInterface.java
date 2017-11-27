package applicationModel.sportsModel;

public interface GameInterface {
	//error exit codes
	final int FILE_NOT_FOUND_ERROR = 400;
    final int INVALID_TEAM_NAME_ERROR = 500;
    final int SAME_TEAM_NAME_ERROR = 555;
    
    final int NUMBER_OF_NBA_TEAMS = 30;
    final int NUMBER_OF_NFL_TEAMS = 32;
    
    public enum eLeague {NBA, NFL};
}
