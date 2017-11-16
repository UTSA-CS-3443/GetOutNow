package applicationController;

import applicationModel.LoginModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * 
 * @author Julian Chan / xmp183
 *
 */
public class ProfileController implements EventHandler<ActionEvent> {
	
	private LoginModel model;
	
	public ProfileController() {
		super();
		this.model = new LoginModel();
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

}
