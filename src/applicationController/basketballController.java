package applicationController;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import applicationModel.sportsModel.*;
import data.SportsScrape;


// will refactor as 'SportsController' once football is integrated
public class BasketballController implements EventHandler<ActionEvent>, GameInterface{
	
	private Game _game;
	
	@FXML
    private AnchorPane parentPane;
	
	@FXML
    private ImageView awayTeamLogo;
	
	@FXML
    private ImageView homeTeamLogo;

	@FXML
    private Button okButton;
    
    @FXML
    private Text textTime;
    
    @FXML
    public void initialize() {
    	retrieveGameData('B');
    	setTime();
    	setImages();
    }
    
    /*
     * Retrieves game data based on what's passed into the scrape
     */
	private void retrieveGameData(char c) {
		SportsScrape scrape = new SportsScrape();
		scrape.SportsData('B');
		
		switch(c) {
		case 'A':
		
			this._game = new NBAGame(scrape.getHomeTeam(), scrape.getAwayTeam(), 
					scrape.getGameTime(), eLeague.NBA);
			break;
		case 'B':
		
			this._game = new NFLGame(scrape.getHomeTeam(), scrape.getAwayTeam(), 
					scrape.getGameTime(), eLeague.NFL);
			break;
			
		}
		
		this._game.validateGameInfo();
	}
	
	/*
	 * Calls returnTeamLogoPath to retrieve image path strings
	 * then uses them to show the team logos 
	 * 
	 */
	@FXML
	public void setImages() {
		
		final String HOME_LOGO_PATH = _game.returnTeamLogoPath(_game.getHomeTeam());
		final String AWAY_LOGO_PATH = _game.returnTeamLogoPath(_game.getAwayTeam());
		System.out.println(HOME_LOGO_PATH);
		homeTeamLogo.setImage(new Image(HOME_LOGO_PATH));
		awayTeamLogo.setImage(new Image(AWAY_LOGO_PATH));
	}
	
	@FXML
	public void setTime() {
		String strTime = _game.getGameTime();
		
		if(strTime.compareTo("right now") == 0) {
			textTime.setText("LIVE");
			return;
		}
		textTime.setText(_game.getGameTime());
	}
	
	
    @FXML
	public void handle(ActionEvent event) {
    	parentPane.getChildren().clear();
    }
}
