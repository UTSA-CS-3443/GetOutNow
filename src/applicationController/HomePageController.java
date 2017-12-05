package applicationController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;

import applicationModel.Coffee;
import applicationModel.CoffeeScrape;
import applicationModel.ConfirmBox;
import applicationModel.MoviesScrape;
import applicationModel.Restaurant;
import applicationModel.RestaurantScrape;
import applicationModel.SportsScrape;
import applicationModel.WeatherScrape;
import javafx.application.Platform;
import javafx.concurrent.Task;
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
 * This class manages the GetOutNowHomepage.fxml
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
	private Parent accountLoader;

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

	private Restaurant rObj;
	private Coffee cObj;
	private String weather;
	private String basketball;
	private String football;
	private String action;
	private String scienceFiction;
	private String comedy;

	/**
	 * Constructor.
	 * This method is where variables are initialized to be used
	 * appropriately by the program.
	 */
	public HomePageController() {
		rObj = new Restaurant(RestaurantScrape.scrapeRestaurant());
		cObj = new Coffee(CoffeeScrape.scrapeCoffeeShop());
		weather = WeatherScrape.WeatherData();
		basketball = SportsScrape.SportsData('A');
		football = SportsScrape.SportsData('B');
		action = MoviesScrape.MoviesData('A');
		scienceFiction = MoviesScrape.MoviesData('B');
		comedy = MoviesScrape.MoviesData('C');
	}

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

		try {
			accountLoader = FXMLLoader.load(getClass().getResource("/applicationView/AccountSettings.fxml"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Stage secondStage = new Stage();
		Scene plannerPageScene = new Scene(accountLoader);
		secondStage.resizableProperty().setValue(Boolean.FALSE);
		secondStage.setScene(plannerPageScene);
		secondStage.setTitle("Account Settings");
		secondStage.show();
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

		Task<Void> task4 = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				// update message property
				updateMessage(weather);
				return null;
			}
		};

		// display message changes as notifications
		task4.messageProperty().addListener((observable, oldMessage, newMessage) ->
		Notifications.create()
		.title("Weather")
		.text("The current weather is " + newMessage + " in San Antonio, TX.")  // Calls WeatherData and returns weather in Fahrenheit.
		.graphic(new ImageView(img))
		.hideAfter(Duration.seconds(12))
		.position(Pos.TOP_LEFT)
		.show());
		// execute long running task on background thread
		Thread weather = new Thread(task4); 
		weather.start();

		if(weather.getState()!=Thread.State.TERMINATED){
			System.out.println("Weather Finished");
		}

		//Movies
		Image img2 = new Image("/images/movieReel.jpg");

		Task<Void> task = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				// update message property
				updateMessage(action);
				return null;
			}
		};

		// display message changes as notifications
		task.messageProperty().addListener((observable, oldMessage, newMessage) ->
		Notifications.create()
		.title("Movies")
		.text("Here are some movies you may be interested in seeing!\n" 
				+ "\nAction:\n" + newMessage + "\n\nScience Fiction:\n" 
				+ scienceFiction + "\n\nComedy:\n" + comedy)
		.graphic(new ImageView(img2))
		.hideAfter(Duration.seconds(12))
		.position(Pos.TOP_RIGHT)
		.show());
		// execute long running task on background thread
		Thread movies = new Thread(task); 
		movies.start();

		if(movies.getState()!=Thread.State.TERMINATED){
			System.out.println("Movies Finished");
		}

		//Sports
		Image img3 = new Image("/images/sportsStill.jpeg");

		Task<Void> task3 = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				// update message property
				updateMessage(basketball);
				return null;
			}
		};

		// display message changes as notifications
		task3.messageProperty().addListener((observable, oldMessage, newMessage) ->
		Notifications.create()
		.title("Sports")
		.text("Here are some sports games you may be interested in!\n" 
				+ "\nNBA:\n" + newMessage + "\nNFL:\n" + football)
		.graphic(new ImageView(img3))
		.hideAfter(Duration.seconds(12))
		.position(Pos.BOTTOM_LEFT)
		.show());
		// execute long running task on background thread
		Thread sports = new Thread(task3); 
		sports.start();

		if(sports.getState()!=Thread.State.TERMINATED){
			System.out.println("Sports Finished");
		}

		//Restaurants
		Image img4 = new Image("/images/coffee.png");

		Task<Void> task2 = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				// update message property
				updateMessage(rObj.getLocation(1));
				return null;
			}
		};

		// display message changes as notifications
		task2.messageProperty().addListener((observable, oldMessage, newMessage) ->
		Notifications.create()
		.title("Restaurants")
		.text("Here are some restaurants you might like!\n" 
				+ newMessage + "\n" 
				+ rObj.getLocation(2) + "\n"
				+ rObj.getLocation(3) + "\n" 
				+ "\nHere are some coffee shops you might like!\n"
				+ cObj.getLocation(0) + "\n"
				+ cObj.getLocation(2) + "\n"
				+ cObj.getLocation(3) + "\n")
		.graphic(new ImageView(img4))
		.hideAfter(Duration.seconds(12))
		.position(Pos.BOTTOM_RIGHT)
		.show());
		// execute long running task on background thread
		Thread restaurants = new Thread(task2); 
		restaurants.start();

		if(restaurants.getState()!=Thread.State.TERMINATED){
			System.out.println("Restaurants Finished");
		}

	}

	/**
	 * This method displays information about current movies and showtimes
	 * when the movies button is pressed by the user.
	 * @param event
	 */
	@FXML
	public void handleMoviesButton(ActionEvent event) {

		Image img = new Image("/images/movieReel.jpg");

		Task<Void> task = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				// update message property
				updateMessage(action);
				return null;
			}
		};

		// display message changes as notifications
		task.messageProperty().addListener((observable, oldMessage, newMessage) ->
		Notifications.create()
		.title("Movies")
		.text("Here are some movies you may be interested in seeing!\n" 
				+ "\nAction:\n" + newMessage + "\n\nScience Fiction:\n" 
				+ scienceFiction + "\n\nComedy:\n" + comedy)
		.graphic(new ImageView(img))
		.hideAfter(Duration.seconds(15))
		.position(Pos.CENTER)
		.show());
		// execute long running task on background thread
		Thread movies = new Thread(task); 
		movies.start();

		if(movies.getState()!=Thread.State.TERMINATED){
			System.out.println("Movies Finished");
		}
	}

	/**
	 * This method displays information about nearby restaurants
	 * that the user might be interested in.
	 * @param event
	 */
	@FXML
	public void handleRestaurantButton(ActionEvent event) {

		Image img = new Image("/images/coffee.png");

		Task<Void> task = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				// update message property
				updateMessage(rObj.getLocation(1));
				return null;
			}
		};

		// display message changes as notifications
		task.messageProperty().addListener((observable, oldMessage, newMessage) ->
		Notifications.create()
		.title("Restaurants")
		.text("Here are some restaurants you might like!\n" 
				+ newMessage + "\n" 
				+ rObj.getLocation(2) + "\n"
				+ rObj.getLocation(3) + "\n" 
				+ "\nHere are some coffee shops you might like!\n"
				+ cObj.getLocation(0) + "\n"
				+ cObj.getLocation(2) + "\n"
				+ cObj.getLocation(3) + "\n")
		.graphic(new ImageView(img))
		.hideAfter(Duration.seconds(15))
		.position(Pos.CENTER)
		.show());
		// execute long running task on background thread
		Thread restaurants = new Thread(task); 
		restaurants.start();

		if(restaurants.getState()!=Thread.State.TERMINATED){
			System.out.println("Restaurants Finished");
		}
	}

	/**
	 * This method displays sports games and the times that they are being played
	 * when the sports button is pressed by the user.
	 * @param event
	 */
	@FXML
	public void handleSportsButton(ActionEvent event) {

		Image img = new Image("/images/sportsStill.jpeg");

		Task<Void> task3 = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				// update message property
				updateMessage(basketball);
				return null;
			}
		};

		// display message changes as notifications
		task3.messageProperty().addListener((observable, oldMessage, newMessage) ->
		Notifications.create()
		.title("Sports")
		.text("Here are some sports games you may be interested in!\n" 
				+ "\nNBA:\n" + newMessage + "\nNFL:\n" + football)
		.graphic(new ImageView(img))
		.hideAfter(Duration.seconds(15))
		.position(Pos.CENTER)
		.show());
		// execute long running task on background thread
		Thread sports = new Thread(task3); 
		sports.start();

		if(sports.getState()!=Thread.State.TERMINATED){
			System.out.println("Sports Finished");
		}

	}

	/**
	 * This method displays the current weather when the weather button is pressed by the user.
	 * @param event
	 */
	@FXML
	public void handleWeatherButton(ActionEvent event) {

		Image img = new Image("/images/stillWeather.png");

		Task<Void> task4 = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				// update message property
				updateMessage(weather);
				return null;
			}
		};

		// display message changes as notifications
		task4.messageProperty().addListener((observable, oldMessage, newMessage) ->
		Notifications.create()
		.title("Weather")
		.text("The current weather is " + newMessage + " in San Antonio, TX.")  // Calls WeatherData and returns weather in Fahrenheit.
		.graphic(new ImageView(img))
		.hideAfter(Duration.seconds(12))
		.position(Pos.CENTER)
		.show());
		// execute long running task on background thread
		Thread weather = new Thread(task4); 
		weather.start();

		if(weather.getState()!=Thread.State.TERMINATED){
			System.out.println("Weather Finished");
		}
	}
}
