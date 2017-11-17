package applicationController;

import java.io.IOException;
import applicationModel.LoginModel;
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
 * 
 * @author Julian Chan / xmp183
 * ProfileController is paired with Register.fxml which contains a 'next'
 * button that will load the Homepage
 *
 */
public class ProfileController implements EventHandler<ActionEvent> {
	
	private LoginModel model;
	
	@FXML
	private Button next;      // next button
	
	public ProfileController() {
		super();
		this.model = new LoginModel();
	}

	/**
	 * handleButtonAction waits for an event
	 * IE: button to be pressed
	 * When 'next' is pressed, the Homepage will be loaded
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleButtonAction(ActionEvent event) throws IOException {
		if(event.getSource() == next) {
			System.out.println("Next Button pressed");
			FXMLLoader homepageLoader = new FXMLLoader(getClass().getResource("/applicationView/GetOutNowHomepage.fxml"));
			Parent homepageParent = homepageLoader.load();
			Scene homepageScene = new Scene(homepageParent);
			Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Stage.setTitle("Homepage Window");
			Stage.hide();
			Stage.setScene(homepageScene);
			Stage.show();
		}
	}
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

}
