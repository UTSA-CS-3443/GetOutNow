package profile;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
	private Map<String, String> interestToValue;     //  HashMap to store preferences and boolean
	private final String INTERESTFILE = "interest.txt";    // Text file to store Interest preferences
	
	/**
	 * Interest Constructor initializes Scanner for user input
	 * and HashMap to store <Preference, True/False> as [key,value] pairs
	 */
	public Interest(Scanner input, HashMap<String, String> interestToValue) {
		this.input = input;
		this.interestToValue = interestToValue;
	}
	
	/**
	 * checkInput() takes in a Scanner and String to prompt the user
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
	 * writeToFile() will write the keys and values from the HashMap to interest.txt
	 */
	public void writeToFile() {
		try {
			// attempt to initialize FileWriter and BufferedWriter objects
			FileWriter outFile = new FileWriter(INTERESTFILE);
			BufferedWriter outBuffer = new BufferedWriter(outFile);
			// for loop to write [key,value] pairs from HashMap in the format:
			//       key:value
			//       basketball:true
			//       coffee:false
			for (String str: interestToValue.keySet()) {
				outBuffer.write(str + ":" + this.getBoolFromKey(str) + "\n");
			}
			outBuffer.close();           // close BufferedWriter
			outFile.close();             // close FileWriter
		} catch (FileNotFoundException e) {        // exit when error: file not found
			System.err.println("File not found");
			System.exit(-1);
		} catch (IOException e) {                   // exit when error: file cannot be read
			System.err.println("File cannot be read");
			System.exit(-1);
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
