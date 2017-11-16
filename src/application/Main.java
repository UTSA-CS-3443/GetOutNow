package application;

import application.controller.LoginController;
import application.model.LoginModel;
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

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {

			//Parent root = FXMLLoader.load(getClass().getResource("view/GetOutView.fxml"));		// test page
			//Parent root = FXMLLoader.load(getClass().getResource("view/GetOutNowHomepage.fxml"));	// test homepage
			//Parent root = FXMLLoader.load(getClass().getResource("view/LoginMenu.fxml"));			// to load login menu

			BorderPane root = new BorderPane();
			FXMLLoader loginLoader =	new FXMLLoader(getClass().getResource("view/LoginMenu.fxml"));
			root.setCenter(loginLoader.load());
			LoginController loginController = loginLoader.getController();

			LoginModel model = new LoginModel();
			loginController.initModel(model);

			Scene scene = new Scene(root, 700, 400);
			primaryStage.setScene(scene);

			primaryStage.resizableProperty().setValue(Boolean.FALSE);
			primaryStage.setTitle("Login/SignUp");
			
			primaryStage.setOnCloseRequest(e -> {
				primaryStage.close();
				System.out.println("Window closed."); 	// print to console confirmation
			});		// secure close 

			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}