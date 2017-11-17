package applicationController;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * This program manages the GetOutNowHomepage.fxml
 * @author Erwin Herrera
 *
 */
public class HomePageController implements EventHandler<ActionEvent> {

	@FXML
	Parent homePageParent;
	
	@FXML
	FXMLLoader loginLoader;
	
    @FXML
    private Button LogOutButton;
    
    public void initialize() {

        // do initialization and configuration work...

		loginLoader = new FXMLLoader(getClass().getResource("/applicationView/LoginMenu.fxml"));
		homePageParent = null;
		
    }
    
	@Override
	public void handle(ActionEvent event) {
		
		try {
			homePageParent = this.loginLoader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene homePageScene = new Scene (homePageParent);
		Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		Stage.setTitle("Homepage");
		Stage.hide();
		Stage.setScene(homePageScene);
		Stage.show();
	}
    

}
