package applicationController;


import java.io.IOException;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

//import applicationModel.Login;
import applicationModel.LoginModel;
import javafx.animation.FadeTransition;
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
import javafx.util.Duration;

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
	
	@FXML
    private JFXTextField signInUserEmail;
	
	@FXML
	private JFXPasswordField password;
	
	private String email_username;
	private String passwordSave;
//	private Account account;

	/**
	 * Constructor.
	 * This method initializes all variables to be used.
	 */
	public LoginController() {
		super();
//		this.account = new Account(email_username, passwordSave);
    	signInUserEmail = new JFXTextField();
    	password = new JFXPasswordField();
	}

	/**
	 * This method manages the event when the 
	 * Forgot Password hyper link is pressed.
	 * @param event
	 */
	@FXML
	public void forgotPasswordHandle(ActionEvent event) {
		System.out.println("Forgot password pressed");
	}

	/**
	 * This method handles most, if not all of the buttons
	 * when they are pressed and depending on the type of button
	 * executes specific pieces of code.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleButtonAction(ActionEvent event) throws IOException {
		if(event.getSource () == SignInButton)
		{
			signInPage.toFront();

		} else if (event.getSource() == signUpButton) {
			signUpPage.toFront();

		} else if (event.getSource() == loginButton) {
			System.out.println("Login pressed");
    		email_username = signInUserEmail.getText();
    		passwordSave = password.getText();
    		
    		System.out.println("Email: " + email_username);
    		System.out.println("Password: " + passwordSave);
    		//this.account.getInfo();
			
			FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/applicationView/GetOutNowHomePage.fxml"));
			Parent homePageParent = loginLoader.load();
			Scene homePageScene = new Scene (homePageParent);
			Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			FadeTransition ft = new FadeTransition(Duration.millis(1500));
			ft.setNode(homePageParent);
			ft.setFromValue(0.1);
			ft.setToValue(1);
			ft.setCycleCount(1);
			ft.setAutoReverse(false);
			Stage.hide();
			Stage.setTitle("Homepage");
			Stage.setScene(homePageScene);
			Stage.show();
			ft.play();
			
		} else if (event.getSource() == registerButton) {  
			// When register button is clicked, the Register.fxml is loaded 
			// and a new stage is set ------>
			System.out.println("Register pressed");
			FXMLLoader registerLoader = new FXMLLoader(getClass().getResource("/applicationView/Register.fxml"));
			Parent registerParent = registerLoader.load();
			Scene registerScene = new Scene(registerParent);
			Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Stage.hide();
			Stage.setTitle("Register Window");
			Stage.setScene(registerScene);
			Stage.show();
		}

	}

	/**
	 * This method ensures that the model of the login is only
	 * initialized once.
	 * @param model
	 */
	public void initModel(LoginModel model) {
		// ensure model is only set once:
		if (this.model != null) {
			throw new IllegalStateException("Model can only be initialized once");
		}
	}

	/**
	 * This method handles any other events that occur
	 * within the scene.
	 * @param event
	 */
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

	}

}
