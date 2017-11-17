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
	public Interest(Scanner input, HashMap<String, String> interestToValue) {
		this.input = input;
		this.interestToValue = interestToValue;
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

	/**
	 * 
	 * @return 'input' Scanner from Interest object
	 */
	public Scanner getInput() {
		return input;
	}
	
	public String getBoolFromKey(String key) {
		return this.interestToValue.get(key);
	}
	
	public void setKeyPair(String key, String bool) {
		this.interestToValue.put(key,  bool);
	}
	
}
