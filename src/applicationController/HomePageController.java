package applicationController;
import data.WeatherScrape;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;

import applicationModel.ConfirmBox;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * This program manages the GetOutNowHomepage.fxml
 * @author Erwin Herrera
 *
 */
public class HomePageController implements Initializable {

	@FXML
	private Parent homePageParent;

	@FXML
	private FXMLLoader loginLoader;

	@FXML
	private JFXButton homeBT;

	@FXML
	private JFXButton whatsNewBT;

	@FXML
	private JFXButton accountBT;

	@FXML
	private JFXButton logOutBT;

	@FXML
	private JFXButton exitBT;

	@FXML
	private AnchorPane holderPane;

	@FXML
	private AnchorPane home;

	@FXML
	private JFXButton weatherBT;

	@FXML
	private JFXButton moviesBT;

	@FXML
	private JFXButton restaurantsBT;

	@FXML
	private JFXButton sportsBT;
	
//	private WeatherScrape weather;

	/**
	 * This method initializes FXML variables to be used
	 * and sets the values of the variables accordingly.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		loginLoader = new FXMLLoader(getClass().getResource("/applicationView/LoginMenu.fxml"));
		homePageParent = null;

	}

	/**
	 * 
	 * @param event
	 */
	@FXML
	public void handleAccountBT(ActionEvent event) {

	}

	/**
	 * This method manages the action of the Exit button. When pressed, a
	 * pop up window is displayed to verify exiting the program.
	 * @param event
	 */
	@FXML
	public void handleExitBT(ActionEvent event) {

		Stage stage = (Stage) exitBT.getScene().getWindow();
		Boolean answer = ConfirmBox.display("Confirm", "Are you sure you want to exit?");
		if (answer == true)
			stage.close();
	}

	/**
	 * 
	 * @param event
	 */
	@FXML
	public void handleHomeButton(ActionEvent event) {

	}

	/**
	 * This method manages the action of the Log Out button. When pressed, a 
	 * pop up window is displayed to verify log out. 
	 * @param event
	 */
	@FXML
	public void handleLogOutBT(ActionEvent event) {

		Boolean answer = ConfirmBox.display("Log Out", "Are you sure you want to log out?");
		if (answer == true) {
			try {
				homePageParent = this.loginLoader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Scene homePageScene = new Scene (homePageParent);
			Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Stage.hide();
			Stage.setTitle("Login/SignUp");
			Stage.setScene(homePageScene);
			Stage.show();
		}
	}

	/**
	 * 
	 * @param event
	 */
	@FXML
	public void handleMoviesButton(ActionEvent event) {

	}

	/**
	 * 
	 * @param event
	 */
	@FXML
	public void handleRestaurantButton(ActionEvent event) {

	}

	/**
	 * Sports button that will print out games playing that the user likes.
	 * @param event
	 */
	@FXML
	public void handleSportsButton(ActionEvent event) {
		
		Notifications notificationBuilder = Notifications.create()
				.title("Sports")
				.text("The current weather is ") 	// Calls WeatherData and returns weather in Fahrenheit.
				.graphic(null) 							// sets graphic to null which gets a defualt image described below when null
				//.graphic(new ImageView(img))
				.hideAfter(Duration.seconds(5))
				.position(Pos.CENTER)
				.onAction(new EventHandler<ActionEvent>() {

					public void handle(ActionEvent event) {
						System.out.println("Clicked on Notification");
					}
				});
		
		notificationBuilder.show();

	}

	/**
	 * Weather button that will print out the current weather when pressed.
	 * @param event
	 */
	@FXML
	public void handleWeatherButton(ActionEvent event) {
				
		Notifications notificationBuilder = Notifications.create()
				.title("Weather")
				.text("The current weather is " + WeatherScrape.WeatherData() + " in San Antonio, TX.") 	// Calls WeatherData and returns weather in Fahrenheit.
				.graphic(null) 							// sets graphic to null which gets a defualt image described below when null
				//.graphic(new ImageView(img))
				.hideAfter(Duration.seconds(5))
				.position(Pos.CENTER)
				.onAction(new EventHandler<ActionEvent>() {

					public void handle(ActionEvent event) {
						System.out.println("Clicked on Notification");
					}
				});
		
		notificationBuilder.show();

	}


	/**
	 * 
	 * @param event
	 */
	@FXML
	public void handleWhatsNewButton(ActionEvent event) {

	}
}
