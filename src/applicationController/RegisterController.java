package applicationController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import applicationModel.Account;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *  
 * @author Erwin Herrera
 * @author Julian Chan / xmp183
 * RegisterController is paired with Register.fxml which contains a 'register'
 * button that will redirect the user back to the login screen to login
 * with the user(s)' newly created account.
 *
 */
public class RegisterController implements Initializable {

	// FXML variables used
	@FXML
	private AnchorPane parentPane;

	@FXML
	private JFXTextField firstName;

	@FXML
	private JFXTextField lastName;

	@FXML
	private JFXTextField registerEmail;

	@FXML
	private JFXTextField userName;

	@FXML
	private JFXPasswordField registerPassword;

	@FXML
	private JFXPasswordField confirmPassword;

	@FXML
	private JFXButton registerBT;

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

	@FXML
	private ImageView loading;

	// primitive data types used 
	// for data storage
	private String nameFirst;
	private String nameLast;
	private String email;
	private String username;
	private String passwordSave;
	private String passwordConfirm;

	// used to create
	// a new account
	private Account account;

	/**
	 * Constructor.
	 */
	public RegisterController() {
		super();
		
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

	/**
	 * handleButtonAction waits for an event
	 * IE: button to be pressed
	 * When 'registerBT' is pressed, the login/signup page will be loaded
	 * for the newly registered user to log in.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleButtonAction(ActionEvent event) throws IOException {

		if(event.getSource() == registerBT) {		// when the register button is pressed

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

				boolean working = false;

				registerFirstNameError.setVisible(false);
				registerLastNameError.setVisible(false);
				registerEmailError.setVisible(false);
				registerUsernameError.setVisible(false);
				registerPasswordError.setVisible(false);
				confirmPasswordError.setVisible(false);

				System.out.println("Register pressed");

				nameFirst = firstName.getText();
				nameLast = lastName.getText();
				email = registerEmail.getText();
				username = userName.getText();
				passwordSave = registerPassword.getText();		
				passwordConfirm = confirmPassword.getText();

				System.out.println("First Name: " + nameFirst);
				System.out.println("Last Name: " + nameLast);
				System.out.println("User Name: " + username);
				System.out.println("Email: " + email);
				System.out.println("Password: " + passwordSave);

				try {

					if (Account.checkPassword(passwordSave) == true) {

						if (Account.createProfile(nameFirst, nameLast, email, username, passwordSave, passwordConfirm) == 0) {
							Account.createProfile(nameFirst, nameLast, email, username, passwordSave, passwordConfirm);
							working = true;


						} else if (Account.createProfile(nameFirst, nameLast, email, username, passwordSave, passwordConfirm) == 1) {

							Notifications notificationBuilder = Notifications.create()
									.title("Error")
									.text("Profile already exists.")
									.graphic(null) 							// sets graphic to null which gets a defualt image described below when null
									.hideAfter(Duration.seconds(5))
									.position(Pos.CENTER)
									.onAction(new EventHandler<ActionEvent>() {

										public void handle(ActionEvent event) {
											System.out.println("Clicked on Notification");
										}
									});

							notificationBuilder.darkStyle();
							notificationBuilder.showError();			// shows an x for an error notification

						} else if (Account.createProfile(nameFirst, nameLast, email, username, passwordSave, passwordConfirm) == 2) {

							Notifications notificationBuilder = Notifications.create()
									.title("Error")
									.text("Passwords do not match.")
									.graphic(null) 							// sets graphic to null which gets a defualt image described below when null
									.hideAfter(Duration.seconds(10))
									.position(Pos.CENTER)
									.onAction(new EventHandler<ActionEvent>() {

										public void handle(ActionEvent event) {
											System.out.println("Clicked on Notification");
										}
									});

							notificationBuilder.darkStyle();
							notificationBuilder.showError();			// shows an x for an error notification
						}

					} else {

						if (passwordSave.length() < 8 || passwordSave.length() > 26) {

							Notifications notificationBuilder = Notifications.create()
									.title("Error")

									.text("Password is either too long or too short (must be within 8 and "
											+ "26 characters). \nLength: " + passwordSave.length())
									.graphic(null) 							// sets graphic to null which gets a defualt image described below when null
									.hideAfter(Duration.seconds(10))
									.position(Pos.CENTER)
									.onAction(new EventHandler<ActionEvent>() {

										public void handle(ActionEvent event) {
											System.out.println("Clicked on Notification");
										}
									});
							notificationBuilder.darkStyle();
							notificationBuilder.showError();			// shows an x for an error notification

						} else {

							Notifications notificationBuilder = Notifications.create()
									.title("Error")

									.text("Password needs to have at least 1 lowercase letter, 1 uppercase letter, "
											+ "\n1 number, and one special character (!?.,|)")
									.graphic(null) 							// sets graphic to null which gets a defualt image described below when null
									.hideAfter(Duration.seconds(10))
									.position(Pos.CENTER)
									.onAction(new EventHandler<ActionEvent>() {

										public void handle(ActionEvent event) {
											System.out.println("Clicked on Notification");
										}
									});

							notificationBuilder.darkStyle();
							notificationBuilder.showError();			// shows an x for an error notification
						}
					}

				} catch (Exception e) {

					System.err.println("Invalid username/password");
					working = false;
				}

				if (working == true) {

					loading.setVisible(true);
					PauseTransition pt = new PauseTransition();		// animation
					pt.setDuration(Duration.seconds(7));	// animation duration set to 5 seconds
					pt.setOnFinished(ev -> {
						System.out.println("Login Successful");		// after animation done, print


						FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/applicationView/LoginMenu.fxml"));
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

					Notifications notificationBuilder = Notifications.create()
							.title("Success")
							.text("Congratulations, you are now registered for GetOutNow. \nPlease sign in.")
							.graphic(null) 							// sets graphic to null which gets a defualt image described below when null
							.hideAfter(Duration.seconds(10))
							.position(Pos.CENTER)
							.onAction(new EventHandler<ActionEvent>() {

								public void handle(ActionEvent event) {
									System.out.println("Clicked on Notification");
								}
							});


					notificationBuilder.showInformation(); 		// shows an i icon for information
				}
			}

		}

	}
}
