package profile;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author Julian Chan / xmp183
 * Interest Class prompts user and 
 * stores user interests in text file
 * on preferences for:
 * 		Sports
 * 		Location
 * 		Movies
 * 		Weather
 * with a boolean TRUE or FALSE when user answers: [yes, no]
 * 
 */
public class Interest {
	
	// store values here
	private Scanner input;    // Scanner for user input
	private Map<String, String> interestToValue;     // HashMap to store preferences and boolean
	
	/**
	 * Interest Constructor initializes Scanner for user input
	 * and HashMap to store <Preference, True/False> as [key,value] pairs
	 */
	public Interest() {
		this.input = new Scanner(System.in);
		this.interestToValue = new HashMap<String, String>();
	}
	
	/**
	 * checkInput takes in a Scanner and String to prompt the user
	 * 		IE: "Do you like basketball?"
	 * 		If yes -> return true;
	 * 			no -> return false;
	 * TODO: Exception handling of user input
	 * @param input
	 * @param prompt
	 * @return boolean
	 */
	public boolean checkInput(Scanner input, String prompt) {
		System.out.println(prompt);
		String userInput = input.nextLine();
		if (userInput.equals("yes")) {
			return true;
		} else {
			return false;
		}
	}
	
}
