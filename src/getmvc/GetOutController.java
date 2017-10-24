package getmvc;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class GetOutController implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("It worked!");
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/GetOutView2.fxml"));
			GetOutMain.stage.setScene(new Scene(root, 400, 400));
			GetOutMain.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
