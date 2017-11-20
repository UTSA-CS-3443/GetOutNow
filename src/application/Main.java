package application;

import applicationModel.ConfirmBox;
//import applicationController.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Erwin Herrera
 * @author Julian Chan-xmp183
 * 
 *
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

			//Parent root = FXMLLoader.load(getClass().getResource("view/GetOutView.fxml"));		// test page
			//Parent root = FXMLLoader.load(getClass().getResource("view/GetOutNowHomepage.fxml"));	// test homepage
			//Parent root = FXMLLoader.load(getClass().getResource("view/LoginMenu.fxml"));			// to load login menu

			BorderPane root = new BorderPane();
			FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/applicationView/LoginMenu.fxml"));
			root.setCenter(loginLoader.load());
			//LoginController loginController = loginLoader.getController();

			//LoginModel model = new LoginModel();
			//loginController.initModel(model);

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
		if (answer)
			stage.close();
	}
	
	/**
	 * This method launches the application.
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}