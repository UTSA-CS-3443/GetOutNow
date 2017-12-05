package applicationController;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

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

    @FXML
    void handleModifyButtonAction(ActionEvent event) {

    }

}
