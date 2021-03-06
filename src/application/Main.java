package application;

import applicationModel.ConfirmBox;
//import applicationController.LoginController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * This is the main class where the application is launched with the 
 * LoginMenu where the user can either sign in or sign up for the GetOutNow application.
 * 
 * @author Erwin Herrera
 * @author Julian Chan-xmp183
 */
public class Main extends Application {

	Stage stage;
	
	/**
	 * This is the start method, which sets up the stage and scene to be displayed. 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		stage = primaryStage;
		
		try {

			BorderPane root = new BorderPane();
			FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/applicationView/LoginMenu.fxml"));
			root.setCenter(loginLoader.load());

			Scene scene = new Scene(root, 700, 400);
			primaryStage.setScene(scene);

			primaryStage.resizableProperty().setValue(Boolean.FALSE);
			primaryStage.setTitle("Login/SignUp");
			
			primaryStage.setOnCloseRequest(e -> {
				e.consume(); 		// tells java to not close on request, instead implement choices
				closeProgram();		// whenever user hits exit button in corner
				System.out.println("Window closed."); 	// print to console confirmation
			});		// secure close
			
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method handles closing the program by showing a confirmation box.
	 */
	private void closeProgram() {
		
		Boolean answer = ConfirmBox.display("Confirm", "Are you sure you want to exit?");
		if (answer == true)
			Platform.exit();
	}
	
	/**
	 * This method launches the application.
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}