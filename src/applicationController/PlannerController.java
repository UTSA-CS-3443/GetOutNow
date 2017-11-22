package applicationController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

/**
 * 
 * @author Julian Chan / xmp183
 * PlannerController.java is the controller for Planner.fxml
 * It will allow users to add Dates and Events to a Planner via Planner.java
 *
 */
public class PlannerController implements Initializable {

	@FXML
	private FXMLLoader plannerLoader;
	
	@FXML
	private Parent plannerParent;
	
	/**
	 * CONSTRUCTOR
	 */
	public PlannerController() {
		
	}
	
	/**
	 * This method initializes FXML variables to be used
	 * and sets the values of the variables accordingly.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		plannerLoader = new FXMLLoader(getClass().getResource("/applicationView/Planner.fxml"));
		plannerParent = null;

	}
	
	/**
	 * Event Handler
	 * @param event
	 */
	@FXML
	public void handleButtonAction(ActionEvent event) {
		
	}

}
