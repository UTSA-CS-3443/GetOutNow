package applicationController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import applicationModel.LoginModel;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 
 * @author Julian Chan / xmp183
 * @author Erwin Herrera
 * RegisterController is paired with Register.fxml which contains a 'register'
 * button that will load the Homepage.
 *
 */
public class RegisterController implements Initializable {

	private LoginModel model;

	@FXML
	private AnchorPane parentPane;

	@FXML
	private JFXTextField firstName;

	@FXML
	private JFXPasswordField registerEmail;

	@FXML
	private JFXButton registerBT;

	@FXML
	private JFXPasswordField registerPassword;

	@FXML
	private JFXTextField lastName;

	@FXML
	private JFXPasswordField userName;

	@FXML
	private JFXPasswordField confirmPassword;

	@FXML
	private ImageView loading;

	@FXML
	private Label registerFirstNameError;

	@FXML
	private Label registerLastNameError;

	@FXML
	private Label registerEmailError;

	@FXML
	private Label registerUsernameError;

	@FXML
	private Label registerPasswordError;

	@FXML
	private Label confirmPasswordError;

	private String nameFirst;
	private String nameLast;
	private String email;
	private String username;
	private String passwordSave;

	/**
	 * Constructor.
	 */
	 public RegisterController() {
		 super();
		 this.model = new LoginModel();

		 email = new String();
		 nameFirst = new String();
		 nameLast = new String();
		 username = new String();
		 passwordSave = new String();

	 }

	 /**
	  * This method initializes all FXML variables and sets them
	  * to the necessary values to be used.
	  * @param location
	  * @param resources
	  */
	 public void initialize(URL location, ResourceBundle resources) {

		 registerFirstNameError.setVisible(false);
		 registerLastNameError.setVisible(false);
		 registerEmailError.setVisible(false);
		 registerUsernameError.setVisible(false);
		 registerPasswordError.setVisible(false);
		 confirmPasswordError.setVisible(false);
		 loading.setVisible(false);
	 }

	 public void handle(ActionEvent event) {
		 // TODO Auto-generated method stub

	 }

	 /**
	  * handleButtonAction waits for an event
	  * IE: button to be pressed
	  * When 'registerBT' is pressed, the Homepage will be loaded
	  * @param event
	  * @throws IOException
	  */
	 @FXML
	 public void handleButtonAction(ActionEvent event) throws IOException {

		 if(event.getSource() == registerBT) {

			 if ( (firstName.getText() == null || firstName.getText().trim().isEmpty() 
					 && (lastName.getText() == null || lastName.getText().trim().isEmpty()))  
					 && (userName.getText() == null || userName.getText().trim().isEmpty()) 
					 && (registerEmail.getText() == null || registerEmail.getText().trim().isEmpty()) 
					 && (registerPassword.getText() == null || registerPassword.getText().trim().isEmpty()) 
					 && (confirmPassword.getText() == null || confirmPassword.getText().trim().isEmpty()) ) {

				 registerFirstNameError.setVisible(true);
				 registerLastNameError.setVisible(true);
				 registerEmailError.setVisible(true);
				 registerUsernameError.setVisible(true);
				 registerPasswordError.setVisible(true);
				 confirmPasswordError.setVisible(false);
				 loading.setVisible(false);
				 
				 System.out.println("All fields are empty");

			 } else if (firstName.getText() == null || firstName.getText().trim().isEmpty()) {

				 registerFirstNameError.setVisible(true);
				 registerLastNameError.setVisible(false);
				 registerEmailError.setVisible(false);
				 registerUsernameError.setVisible(false);
				 registerPasswordError.setVisible(false);
				 confirmPasswordError.setVisible(false);
				 loading.setVisible(false);
				 System.out.println("No firstname");

			 } else if (lastName.getText() == null || lastName.getText().trim().isEmpty()) {

				 registerFirstNameError.setVisible(false);
				 registerLastNameError.setVisible(true);
				 registerEmailError.setVisible(false);
				 registerUsernameError.setVisible(false);
				 registerPasswordError.setVisible(false);
				 confirmPasswordError.setVisible(false);
				 loading.setVisible(false);
				 System.out.println("No lastname");

			 } else if (userName.getText() == null || userName.getText().trim().isEmpty()) {

				 registerFirstNameError.setVisible(false);
				 registerLastNameError.setVisible(false);
				 registerEmailError.setVisible(false);
				 registerUsernameError.setVisible(true);
				 registerPasswordError.setVisible(false);
				 confirmPasswordError.setVisible(false);
				 loading.setVisible(false);
				 System.out.println("No username");

			 } else if (registerEmail.getText() == null || registerEmail.getText().trim().isEmpty()) {

				 registerFirstNameError.setVisible(false);
				 registerLastNameError.setVisible(false);
				 registerEmailError.setVisible(true);
				 registerUsernameError.setVisible(false);
				 registerPasswordError.setVisible(false);
				 confirmPasswordError.setVisible(false);
				 loading.setVisible(false);
				 System.out.println("No email");


			 } else if (registerPassword.getText() == null || registerPassword.getText().trim().isEmpty()) {

				 registerFirstNameError.setVisible(false);
				 registerLastNameError.setVisible(false);
				 registerEmailError.setVisible(false);
				 registerUsernameError.setVisible(false);
				 registerPasswordError.setVisible(true);
				 confirmPasswordError.setVisible(false);
				 loading.setVisible(false);
				 System.out.println("Register password");

			 } else if (confirmPassword.getText() == null || confirmPassword.getText().trim().isEmpty()) {

				 registerFirstNameError.setVisible(false);
				 registerLastNameError.setVisible(false);
				 registerEmailError.setVisible(false);
				 registerUsernameError.setVisible(false);
				 registerPasswordError.setVisible(false);
				 confirmPasswordError.setVisible(true);
				 loading.setVisible(false);
				 System.out.println("Confirm password");

			 } else {

				 registerFirstNameError.setVisible(false);
				 registerLastNameError.setVisible(false);
				 registerEmailError.setVisible(false);
				 registerUsernameError.setVisible(false);
				 registerPasswordError.setVisible(false);
				 confirmPasswordError.setVisible(false);
				 loading.setVisible(true);

				 System.out.println("Register pressed");

				 nameFirst = firstName.getText();
				 nameLast = lastName.getText();
				 email = registerEmail.getText();
				 username = userName.getText();
				 passwordSave = registerPassword.getText();		

				 System.out.println("First Name: " + nameFirst);
				 System.out.println("Last Name: " + nameLast);
				 System.out.println("User Name: " + username);
				 System.out.println("Email: " + email);
				 System.out.println("Password: " + passwordSave);

				 //this.account.getInfo();

				 loading.setVisible(true);	// show loading
				 PauseTransition pt = new PauseTransition();		// animation
				 pt.setDuration(Duration.seconds(3));	// animation duration set to 3 seconds
				 pt.setOnFinished(ev -> {
					 System.out.println("Login Successful");		// after animation done, print


					 FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/applicationView/GetOutNowHomepage.fxml"));
					 Parent homePageParent = null;
					 try {
						 homePageParent = loginLoader.load();
					 } catch (IOException e1) {
						 // TODO Auto-generated catch block
						 e1.printStackTrace();
					 }
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
				 });
				 pt.play();		// play animation
			 }

		 }

	 }
}
