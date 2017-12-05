package applicationController;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * This class manages the two buttons in teh Account Settings fxml.
 * The user has the option to either create a new account or delete
 * an account. When the buttons are pressed, they will display another 
 * window accordingly.
 * @author Erwin Herrera
 *
 */
public class AccountSettingsController {

    @FXML
    private AnchorPane parentPane;

    @FXML
    private JFXButton deleteBT;

    @FXML
    private JFXButton registerBT;

    @FXML
    private JFXButton modifyBT;
    
	@FXML
	private Parent registerLoader;
	
	@FXML
	private Parent deleteLoader;

	/**
	 * Constructor.
	 * This method initializes all variables to be used.
	 */
	public AccountSettingsController() {
		super();
	}
    
	/**
	 * This method handles the event when the create account button is pressed.
	 * It will load the Create Account fxml and the user may create another account.
	 * @param event
	 */
    @FXML
    void handleCreateButtonAction(ActionEvent event) {
    	
		try {
			registerLoader = FXMLLoader.load(getClass().getResource("/applicationView/CreateAccount.fxml"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Stage secondStage = new Stage();
		Scene plannerPageScene = new Scene(registerLoader);
		secondStage.resizableProperty().setValue(Boolean.FALSE);
		secondStage.setScene(plannerPageScene);
		secondStage.setTitle("Create Account");
		secondStage.show();
    }

    /**
     * This method handles the event when the delete account button is pressed.
     * When the user presses the button, it will load the Delete Account fxml and the user
     * may choose to delete an existing account.
     * @param event
     */
    @FXML
    void handleDeleteButtonAction(ActionEvent event) {
    	
		try {
			deleteLoader = FXMLLoader.load(getClass().getResource("/applicationView/DeleteAccount.fxml"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Stage thirdStage = new Stage();
		Scene plannerPageScene = new Scene(deleteLoader);
		thirdStage.resizableProperty().setValue(Boolean.FALSE);
		thirdStage.setScene(plannerPageScene);
		thirdStage.setTitle("Delete Account");
		thirdStage.show();
		
    }
}
