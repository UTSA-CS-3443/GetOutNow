package applicationController;

import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import applicationModel.Account;
import applicationModel.ConfirmBox;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * This class manages the DeleteAccount.fxml 
 * that manages the option to delete an account.
 * @author Erwin Herrera
 *
 */
public class DeleteAccountController implements Initializable {

	@FXML
	private AnchorPane parentPane;

	@FXML
	private JFXTextField userName;

	@FXML
	private JFXPasswordField registerPassword;

	@FXML
	private JFXPasswordField confirmPassword;

	@FXML
	private JFXButton deleteBT;

	@FXML
	private Label registerUsernameError;

	@FXML
	private Label registerPasswordError;

	@FXML
	private Label confirmPasswordError;

	private String username;
	private String passwordSave;
	private String passwordConfirm;

	/**
	 * Constructor.
	 */
	public DeleteAccountController() {
		super();

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

		registerUsernameError.setVisible(false);
		registerPasswordError.setVisible(false);
		confirmPasswordError.setVisible(false);

	}

	/**
	 * This method handles the event when the 'Delete Account' button is pressed.
	 * It will give the user confirmation to delete their account/ an account or
	 * it will give the user an error for non matching passwords.
	 * @param event
	 */
	@FXML
	void handleButtonAction(ActionEvent event) {

		if (userName.getText() == null || userName.getText().trim().isEmpty()) {

			registerUsernameError.setVisible(true);
			registerPasswordError.setVisible(false);
			confirmPasswordError.setVisible(false);

			System.out.println("No username");

		} else if (registerPassword.getText() == null || registerPassword.getText().trim().isEmpty()) {

			registerUsernameError.setVisible(false);
			registerPasswordError.setVisible(true);
			confirmPasswordError.setVisible(false);

			System.out.println("Password Error");

		} else if (confirmPassword.getText() == null || confirmPassword.getText().trim().isEmpty()) {

			registerUsernameError.setVisible(false);
			registerPasswordError.setVisible(false);
			confirmPasswordError.setVisible(true);

			System.out.println("Confirm password error");

		} else {

			registerUsernameError.setVisible(false);
			registerPasswordError.setVisible(false);
			confirmPasswordError.setVisible(false);

			System.out.println("Delete Account pressed");

			boolean answer = false;
			username = userName.getText();
			passwordSave = registerPassword.getText();		
			passwordConfirm = confirmPassword.getText();

			if (!passwordSave.equals(passwordConfirm)) {
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
				notificationBuilder.showError();
				
			} else {

				try {

					System.out.println("User Name: " + username);
					System.out.println("Password: " + passwordSave);


					answer = ConfirmBox.display("Deletion", "Are you sure you want to delete your account?");

					if (answer == true) {
						if (Account.deleteProfile(username, passwordSave, passwordConfirm) == 0) {
							PauseTransition pt = new PauseTransition();		// animation
							pt.setDuration(Duration.seconds(5));	// animation duration set to 5 seconds
							pt.setOnFinished(ev -> {
								System.out.println("Deletion Successful");		// after animation done, print

								Platform.exit();
							});
							pt.play();		// play animation

							Notifications notificationBuilder = Notifications.create()
									.title("Deletion Successful")
									.text("Your account has been deleted, GetOutNow will now close.\n")
									.graphic(null) 							// sets graphic to null which gets a defualt image described below when null
									.hideAfter(Duration.seconds(5))
									.position(Pos.CENTER);

							notificationBuilder.showInformation(); 		// shows an i icon for information

						} else if (Account.deleteProfile(username, passwordSave, passwordConfirm) == -2) {
							Notifications notificationBuilder = Notifications.create()
									.title("Error")
									.text("Profile does not exist.")
									.graphic(null) 							// sets graphic to null which gets a defualt image described below when null
									.hideAfter(Duration.seconds(10))
									.position(Pos.CENTER);

							notificationBuilder.darkStyle();
							notificationBuilder.showError();
						}
					}

				} catch (Exception e) {

					System.err.println("Invalid username/password");
				}
			}
		}
	}
}
