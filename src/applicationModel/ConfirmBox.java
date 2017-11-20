package applicationModel;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This program generates a confirm box with two options.
 * To close the program, or to cancel.
 * @author Erwin Herrera
 *
 */
public class ConfirmBox {		// used as verification (yes or no)

	static boolean answer;
	
	/**
	 * This method displays the confirm box generated.
	 * @param title
	 * @param message
	 * @return a boolean value to determine the user's choice
	 */
	public static boolean display(String title, String message) {
		
		Stage window = new Stage();
		window.resizableProperty().setValue(Boolean.FALSE);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		Label label = new Label();
		label.setText(message);
		
		//Create two buttons
		Button yesButton = new Button("Confirm");
		Button noButton = new Button("Cancel");
		
		yesButton.setOnAction(e -> {		// action of confirm
			answer = true;
			window.close();;
		});
		
		noButton.setOnAction(e -> {			// action of cancel
			answer = false;
			window.close();;
		});
		
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, yesButton, noButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();		// needs to be closed
		
		return answer;
	
	}
	
}
