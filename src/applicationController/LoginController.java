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
import javafx.scene.control.Hyperlink;
//import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Erwin Herrera
 * @author Julian Chan / xmp183
 *
 */
public class LoginController implements EventHandler<ActionEvent> {

	private LoginModel model;

	@FXML
	private AnchorPane signInPage;

	@FXML
	private Button signUpButton;

	@FXML
	private Button loginButton;

	@FXML
	private Hyperlink forgotPasswordHyperLink;

	@FXML
	private AnchorPane signUpPage;

	@FXML
	private Button SignInButton;

	@FXML
	private Button registerButton;


	public LoginController() {
		super();
	}

	@FXML
	public void forgotPasswordHandle(ActionEvent event) {
		System.out.println("Forgot password pressed");
	}

	@FXML
	public void handleButtonAction(ActionEvent event) throws IOException {
		if(event.getSource () == SignInButton)
		{
			signInPage.toFront();

		} else if (event.getSource() == signUpButton) {
			signUpPage.toFront();

		} else if (event.getSource() == loginButton) {
			System.out.println("Login pressed");
			FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/applicationView/GetOutNowHomePage.fxml"));
			Parent homePageParent = loginLoader.load();
			Scene homePageScene = new Scene (homePageParent);
			Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Stage.setTitle("Other Window");
			Stage.hide();
			Stage.setScene(homePageScene);
			Stage.show();
			
		} else if (event.getSource() == registerButton) {  
			// When register button is clicked, the Register.fxml is loaded 
			// and a new stage is set ------>
			System.out.println("Register pressed");
			FXMLLoader registerLoader = new FXMLLoader(getClass().getResource("/applicationView/Register.fxml"));
			Parent registerParent = registerLoader.load();
			Scene registerScene = new Scene(registerParent);
			Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Stage.setTitle("Register Window");
			Stage.hide();
			Stage.setScene(registerScene);
			Stage.show();
		}

	}

	public void initModel(LoginModel model) {
		// ensure model is only set once:
		if (this.model != null) {
			throw new IllegalStateException("Model can only be initialized once");
		}
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

	}

}
