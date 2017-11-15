package application.controller;


import application.model.GetOutModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class GetOutController implements EventHandler<ActionEvent> {

	private GetOutModel model;
	
    @FXML
    private AnchorPane signInPage;

    @FXML
    private Button signUpButton;

    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink forgotPasswordHyperLink;

    @FXML
    private AnchorPane signUpPage;

    @FXML
    private Button SignInButton;

    @FXML
    private Button registerButton;
    
	
	public GetOutController() {
		super();
		this.model = new GetOutModel();
	}
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("It worked!");
	}
	
    @FXML
    public void forgotPasswordHandle(ActionEvent event) {
    	System.out.println("Forgot password pressed");
    }

    @FXML
    public void handleButtonAction(ActionEvent event) {
    	if(event.getSource () == SignInButton)
    	{
    		signInPage.toFront();
    		
    	} else if (event.getSource() == signUpButton) {
    		signUpPage.toFront();
    		
    	} else if (event.getSource() == loginButton) {
    		System.out.println("Login pressed");
    
    	} else if (event.getSource() == registerButton) {
    		System.out.println("Register pressed");
    
    	}
    	
    }
	
}
