package application.controller;


import application.model.GetOutModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GetOutController implements EventHandler<ActionEvent> {

	private GetOutModel model;
	
	public GetOutController() {
		super();
		this.model = new GetOutModel();
	}
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("It worked!");
	}
	
	public void loginHandle(ActionEvent event) {
		System.out.println("Login pressed.");
	}
	
	public void signUpHandle(ActionEvent event) {
		System.out.println("Signup pressed.");
	}
	
    public void forgotPasswordHandle(ActionEvent event) {
    	System.out.println("Hyperlink pressed.");
    }
	
}
