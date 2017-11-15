package profile;
import java.io.File;
import java.util.Scanner;


/**
 * Settings.java will be take the user's profile information to 
 * access their settings preferences. Settings should overwrite 
 * data within the text file that has all the user's data. 
 * 
 * @author Clarence Bumanglag
 */
public class Settings {

	private Scanner fileRead;
	private String email;
	private String username;
	private Profile profileHandler;
	
	/*
	 * Constructor for if they are returning users and are accessing
	 * GetOutNow via the Login page
	 * 
	 */
	public Settings (String email, String username) {
		this.email = email;
		this.username = username;
	}
	
	/*
	 * Constructor for if they are creating/deleting a profile
	 */
	public Settings (Profile profileHandler) {
		this.profileHandler = profileHandler;
	}
	
}
