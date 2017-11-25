package applicationController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;

import applicationModel.ConfirmBox;
import data.Coffee;
import data.CoffeeScrape;
import data.Restaurant;
import data.RestaurantScrape;
import data.SportsScrape;
import data.WeatherScrape;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	private Parent loginPageParent;

	@FXML
	private Parent plannerLoader;

	@FXML
	private FXMLLoader loginLoader;

	@FXML
	private JFXButton plannerBT;

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

	/**
	 * This method initializes FXML variables to be used
	 * and sets the values of the variables accordingly.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		loginLoader = new FXMLLoader(getClass().getResource("/applicationView/LoginMenu.fxml"));
		loginPageParent = null;
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
	public void handlePlannerButton(ActionEvent event) {

		try {
			plannerLoader = FXMLLoader.load(getClass().getResource("/applicationView/Planner.fxml"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Stage secondStage = new Stage();
		Scene plannerPageScene = new Scene(plannerLoader);
		secondStage.setScene(plannerPageScene);
		secondStage.setTitle("Planner");
		secondStage.show();
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
				loginPageParent = this.loginLoader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Scene loginPageScene = new Scene (loginPageParent);
			Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Stage.hide();
			Stage.setTitle("Login/SignUp");
			Stage.setScene(loginPageScene);
			Stage.show();
		}
	}

	/**
	 * This method displays all of the available buttons' displays at once
	 * to show the user all information that is new and current when the 
	 * what's new button is pressed.
	 * @param event
	 */
	@FXML
	public void handleWhatsNewButton(ActionEvent event) {

		//Weather
		Image img = new Image("/images/stillWeather.png");
		Notifications notificationBuilder = Notifications.create()
				.title("Weather")
				.text("The current weather is " + WeatherScrape.WeatherData() + " in San Antonio, TX.")
				.graphic(new ImageView(img))
				.hideAfter(Duration.seconds(30))
				.position(Pos.TOP_LEFT)
				.onAction(new EventHandler<ActionEvent>() {

					public void handle(ActionEvent event) {
						System.out.println("Clicked on Notification");
					}
				});

		notificationBuilder.show();

		//Movies
		Image img2 = new Image("/images/movieReel.jpg");
		Notifications notificationBuilder2 = Notifications.create()
				.title("Movies")
				.text("Here are some movies you may be interested in seeing!\n") 
				//				+ "Action\n" + MoviesScrape.MoviesData('A') + "\nScience Fiction\n" 
				//				+ MoviesScrape.MoviesData('B') + "\nComedy\n" + MoviesScrape.MoviesData('C'))
				.graphic(new ImageView(img2))
				.hideAfter(Duration.seconds(30))
				.position(Pos.TOP_RIGHT)
				.onAction(new EventHandler<ActionEvent>() {

					public void handle(ActionEvent event) {
						System.out.println("Clicked on Notification");
					}
				});

		notificationBuilder2.show();

		//Sports
		Image img3 = new Image("/images/sportsStill.jpeg");
		Notifications notificationBuilder3 = Notifications.create()
				.title("Sports")
				.text("Here are some sports games you may be interested in!\n" 
						+ "\nNBA\n" + SportsScrape.SportsData('A') + "\nNFL\n" + SportsScrape.SportsData('B'))
				.graphic(new ImageView(img3))
				.hideAfter(Duration.seconds(30))
				.position(Pos.BOTTOM_LEFT)
				.onAction(new EventHandler<ActionEvent>() {

					public void handle(ActionEvent event) {
						System.out.println("Clicked on Notification");
					}
				});

		notificationBuilder3.show();

		//Restaurants
		// Create ArrayList to store strings
		ArrayList<String> restaurantLocations = new ArrayList<String>();
		ArrayList<String> coffeeLocations = new ArrayList<String>();


		Restaurant rObj = new Restaurant(RestaurantScrape.scrapeRestaurant());
		Coffee cObj = new Coffee(CoffeeScrape.scrapeCoffeeShop());

		//for(int i = 0; i < rObj.getSize(); i++){}
		for(int i = 0; i < 5; i++) {
			restaurantLocations.add(rObj.getLocation(i));
		}

		//for(int i = 0; i < rObj.getSize(); i++){}
		for(int i = 0; i < 5; i++){
			coffeeLocations.add(cObj.getLocation(i));
		}

		Image img4 = new Image("/images/coffee.png");
		Notifications notificationBuilder4 = Notifications.create()
				.title("Restaurants")
				.text("Here are some restaurants you might like!\n" 
						+ restaurantLocations.get(0) + "\n" 
						+ restaurantLocations.get(1) + "\n"
						+ restaurantLocations.get(2) + "\n" 
						+ "\nHere are some coffee shops you might like!\n"
						+ coffeeLocations.get(0) + "\n"
						+ coffeeLocations.get(1) + "\n"
						+ coffeeLocations.get(2) + "\n")
				.graphic(new ImageView(img4))
				.hideAfter(Duration.seconds(30))
				.position(Pos.BOTTOM_RIGHT)
				.onAction(new EventHandler<ActionEvent>() {

					public void handle(ActionEvent event) {
						System.out.println("Clicked on Notification");
					}
				});

		notificationBuilder4.show();

	}

	/**
	 * This method displays information about current movies and showtimes
	 * when the movies button is pressed by the user.
	 * @param event
	 */
	@FXML
	public void handleMoviesButton(ActionEvent event) {

		Image img = new Image("/images/movieReel.jpg");
		Notifications notificationBuilder = Notifications.create()
				.title("Movies")
				.text("Here are some movies you may be interested in seeing!\n") 
				//				+ "Action\n" + MoviesScrape.MoviesData('A') + "\nScience Fiction\n" 
				//				+ MoviesScrape.MoviesData('B') + "\nComedy\n" + MoviesScrape.MoviesData('C'))
				.graphic(new ImageView(img))
				.hideAfter(Duration.seconds(20))
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
	public void handleRestaurantButton(ActionEvent event) {

		// Create ArrayList to store strings
		ArrayList<String> restaurantLocations = new ArrayList<String>();
		ArrayList<String> coffeeLocations = new ArrayList<String>();


		Restaurant rObj = new Restaurant(RestaurantScrape.scrapeRestaurant());
		Coffee cObj = new Coffee(CoffeeScrape.scrapeCoffeeShop());

		//for(int i = 0; i < rObj.getSize(); i++){}
		for(int i = 0; i < 5; i++) {
			restaurantLocations.add(rObj.getLocation(i));
		}

		//for(int i = 0; i < rObj.getSize(); i++){}
		for(int i = 0; i < 5; i++){
			coffeeLocations.add(cObj.getLocation(i));
		}

		Image img = new Image("/images/coffee.png");
		Notifications notificationBuilder = Notifications.create()
				.title("Restaurants")
				.text("Here are some restaurants you might like!\n" 
						+ restaurantLocations.get(0) + "\n" 
						+ restaurantLocations.get(1) + "\n"
						+ restaurantLocations.get(2) + "\n" 
						+ "\nHere are some coffee shops you might like!\n"
						+ coffeeLocations.get(0) + "\n"
						+ coffeeLocations.get(1) + "\n"
						+ coffeeLocations.get(2) + "\n")
				.graphic(new ImageView(img))
				.hideAfter(Duration.seconds(20))
				.position(Pos.CENTER)
				.onAction(new EventHandler<ActionEvent>() {

					public void handle(ActionEvent event) {
						System.out.println("Clicked on Notification");
					}
				});

		notificationBuilder.show();
	}

	/**
	 * This method displays sports games and the times that they are being played
	 * when the sports button is pressed by the user.
	 * @param event
	 */
	@FXML
	public void handleSportsButton(ActionEvent event) {

		Image img = new Image("/images/sportsStill.jpeg");
		Notifications notificationBuilder = Notifications.create()
				.title("Sports")
				.text("Here are some sports games you may be interested in!\n" 
						+ "\nNBA\n" + SportsScrape.SportsData('A') + "\nNFL\n" + SportsScrape.SportsData('B'))
				.graphic(new ImageView(img))
				.hideAfter(Duration.seconds(20))
				.position(Pos.CENTER)
				.onAction(new EventHandler<ActionEvent>() {

					public void handle(ActionEvent event) {
						System.out.println("Clicked on Notification");
					}
				});

		notificationBuilder.show();

	}

	/**
	 * This method displays the current weather when the weather button is pressed by the user.
	 * @param event
	 */
	@FXML
	public void handleWeatherButton(ActionEvent event) {

		Image img = new Image("/images/stillWeather.png");
		Notifications notificationBuilder = Notifications.create()
				.title("Weather")
				.text("The current weather is " + WeatherScrape.WeatherData() + " in San Antonio, TX.") 	// Calls WeatherData and returns weather in Fahrenheit.
				.graphic(new ImageView(img))
				.hideAfter(Duration.seconds(10))
				.position(Pos.CENTER)
				.onAction(new EventHandler<ActionEvent>() {

					public void handle(ActionEvent event) {
						System.out.println("Clicked on Notification");
					}
				});

		notificationBuilder.show();
	}
}
