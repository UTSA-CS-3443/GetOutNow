package application.controller;

import application.model.GetOutModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * 
 * @author Julian Chan / xmp183
 *
 */
public class ProfileController implements EventHandler<ActionEvent> {
	
	private GetOutModel model;
	
	public ProfileController() {
		super();
		this.model = new GetOutModel();
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

}
