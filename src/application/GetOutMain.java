package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Erwin Herrera
 *
 * @author Julian Chan-xmp183
 * 
 *
 */
public class GetOutMain extends Application {
	Stage stage;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			
			//Parent root = FXMLLoader.load(getClass().getResource("view/GetOutView.fxml"));		// test page
			//Parent root = FXMLLoader.load(getClass().getResource("view/GetOutNowHomepage.fxml"));	// test homepage
			Parent root = FXMLLoader.load(getClass().getResource("view/LoginMenu.fxml"));			// to load login menu
			primaryStage.setTitle("Login");
			primaryStage.setOnCloseRequest(e -> primaryStage.close());		// secure close 

			primaryStage.setScene(new Scene(root, 700, 400));		// set to 700 by 400 for log in menu pixels
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		this.stage = primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}