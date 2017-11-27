package notification;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/*
 * Using a Notifcation object:
 * Notification n = new Notification();
 *	n.start(new Stage());	//launches code inside start method
 */
public class Notification extends Application{
	public enum eNotification {NBA, NFL};
	public Notification(){
		
	}
	
	
	public void start(Stage primaryStage) throws Exception {
		try {
			   	Parent root = FXMLLoader.load(getClass().getResource("/applicationView/basketballNotification.fxml"));
		        primaryStage.setTitle("NBA Game");
		        primaryStage.setScene(new Scene(root, 600, 400));
		        primaryStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//will add more methods later
}
