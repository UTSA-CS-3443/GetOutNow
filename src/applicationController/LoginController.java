package applicationController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import applicationModel.LoginModel;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import profile.Account;

/**
 * @author Erwin Herrera
 * @author Julian Chan / xmp183
 *
 */
public class LoginController implements EventHandler<ActionEvent> {

	private LoginModel model;

	@FXML
	private AnchorPane signUpPage;

	@FXML
	private Button SignInButton;

	@FXML
	private Button registerButton;

	@FXML
	private JFXTextField registerEmail;

	@FXML
	private ImageView loading2;

	@FXML
	private Label registerEmailError;

	@FXML
	private Label registerPasswordError;

	@FXML
	private JFXPasswordField registerPassword;

	@FXML
	private JFXPasswordField confirmPassword;

	@FXML
	private Label confirmPasswordError;

	@FXML
	private AnchorPane signInPage;

	@FXML
	private Button loginButton;

	@FXML
	private Hyperlink forgotPasswordHyperLink;

	@FXML
	private JFXTextField signInUserEmail;

	@FXML
	private JFXPasswordField password;

	@FXML
	private ImageView loading;

	@FXML
	private Button signUpButton;

	@FXML
	private Label userEmailError;

	@FXML
	private Label passwordError;

	private String email_username;
	private String passwordSave;

	private Account account;

	/**
	 * Constructor.
	 * This method initializes all variables to be used.
	 */
	public LoginController() {
		super();
		email_username = new String();
		passwordSave = new String();
	}

	/**
	 * This method initializes FXML variables to be used
	 * and sets the values of the variables accordingly.
	 * @param location
	 * @param resources
	 */
	public void initialize(URL location, ResourceBundle resources) {

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
			userEmailError.setVisible(false);
			passwordError.setVisible(false);
			signInPage.toFront();

		} else if (event.getSource() == signUpButton) {

			registerEmailError.setVisible(false);
			registerPasswordError.setVisible(false);
			confirmPasswordError.setVisible(false);
			signUpPage.toFront();

		} else if (event.getSource() == loginButton) {

			if ((signInUserEmail.getText() == null || signInUserEmail.getText().trim().isEmpty() 
					&& (password.getText() == null || password.getText().trim().isEmpty()))){
				userEmailError.setVisible(true);
				passwordError.setVisible(true);

			} else if (signInUserEmail.getText() == null || signInUserEmail.getText().trim().isEmpty()) {

				passwordError.setVisible(false);
				userEmailError.setVisible(true);
				System.out.println("No email");

			} else if (password.getText() == null || password.getText().trim().isEmpty()) {

				userEmailError.setVisible(false);
				passwordError.setVisible(true);
				System.out.println("No password");

			} else {

				boolean working;

				userEmailError.setVisible(false);
				passwordError.setVisible(false);

				System.out.println("Login pressed");

				email_username = signInUserEmail.getText();
				passwordSave = password.getText();

				System.out.println("Email: " + email_username);
				System.out.println("Password: " + passwordSave);

				try {
					this.account = new Account(email_username, passwordSave);
					working = true;
				} catch (Exception e) {
					System.err.println("Invalid username/password");
					working = false;
				}

				if (working == true) {

					loading.setVisible(true);	// show loading

					// create task to be done in background
					Task<Parent> loadTask = new Task<Parent>() {
						@Override
						public Parent call() throws IOException, InterruptedException {

							FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/applicationView/GetOutNowHomepage.fxml"));
							Parent homePageParent = null;
							try {
								homePageParent = loginLoader.load();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							return homePageParent;
						}
					};

					// when task has succeeded, show scene on stage
					loadTask.setOnSucceeded(e -> {
						Scene homePageScene = new Scene (loadTask.getValue());
						Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
						FadeTransition ft = new FadeTransition(Duration.millis(1000));
						ft.setNode(loadTask.getValue());
						ft.setFromValue(0.1);
						ft.setToValue(1);
						ft.setCycleCount(1);
						ft.setAutoReverse(false);
						System.out.println("Login Successful");
						Stage.hide();
						Stage.setTitle("Homepage");
						Stage.setScene(homePageScene);
						Stage.show();
						ft.play();
					});

					loadTask.setOnFailed(e -> loadTask.getException().printStackTrace());

					Thread thread = new Thread(loadTask);
					thread.start();

				} else {
					Notifications notificationBuilder = Notifications.create()
							.title("Login Error")
							.text("Incorrect username or password.")
							.graphic(null) 							// sets graphic to null which gets a defualt image described below when null
							.hideAfter(Duration.seconds(7))
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

		} else if (event.getSource() == registerButton) {

			if ((registerEmail.getText() == null || registerEmail.getText().trim().isEmpty())
					&& (registerPassword.getText() == null || registerPassword.getText().trim().isEmpty())) {

				registerEmailError.setVisible(true);
				registerPasswordError.setVisible(true);
				confirmPasswordError.setVisible(false);
				System.out.println("No email and password");	

			} else if (registerEmail.getText() == null || registerEmail.getText().trim().isEmpty()) {

				registerEmailError.setVisible(true);
				registerPasswordError.setVisible(false);
				confirmPasswordError.setVisible(false);
				System.out.println("No email");

			} else if (registerPassword.getText() == null || registerPassword.getText().trim().isEmpty()) {

				registerEmailError.setVisible(false);
				registerPasswordError.setVisible(true);
				confirmPasswordError.setVisible(false);
				System.out.println("No password");


			} else if (confirmPassword.getText() == null || confirmPassword.getText().trim().isEmpty()) {

				registerEmailError.setVisible(false);
				registerPasswordError.setVisible(false);
				confirmPasswordError.setVisible(true);
				System.out.println("Confirm password");

			} else {

				registerEmailError.setVisible(false);
				registerPasswordError.setVisible(false);
				confirmPasswordError.setVisible(false);

				System.out.println("Register pressed");

				email_username = registerEmail.getText();
				passwordSave = registerPassword.getText();

				System.out.println("Email: " + email_username);
				System.out.println("Password: " + passwordSave);
				//this.account.getInfo();

				loading2.setVisible(true);	// show loading
				PauseTransition pt2 = new PauseTransition();		// animation
				pt2.setDuration(Duration.seconds(3));	// animation duration set to 3 seconds
				pt2.setOnFinished(ev -> {
					System.out.println("Login Successful");		// after animation done, print


					FXMLLoader loginLoader2 = new FXMLLoader(getClass().getResource("/applicationView/Register.fxml"));
					Parent homePageParent2 = null;
					try {
						homePageParent2 = loginLoader2.load();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Scene homePageScene2 = new Scene (homePageParent2);
					Stage Stage2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
					FadeTransition ft2 = new FadeTransition(Duration.millis(1500));
					ft2.setNode(homePageParent2);
					ft2.setFromValue(0.1);
					ft2.setToValue(1);
					ft2.setCycleCount(1);
					ft2.setAutoReverse(false);
					Stage2.hide();
					Stage2.setTitle("Register");
					Stage2.setScene(homePageScene2);
					Stage2.show();
					ft2.play();
				});
				pt2.play();		// play animation
			}
		}
	}
}
