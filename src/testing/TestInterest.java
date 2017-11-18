package testing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import profile.Interest;

/**
 * 
 * @author Julian Chan / xmp183
 * TestInterest class is used to test the Interest class
 * logic and initialization of Interest object
 *
 */
public class TestInterest {

	public static void main(String[] args) {
		/**
		 * Initialize Scanner, HashMap, and Interest Objects
		 */
		Scanner input = new Scanner(System.in);
		Map<String, String> interestToValue = new HashMap();
		Interest testInterest = new Interest(input, (HashMap<String, String>) interestToValue);
		
		/**
		 * If check for user input on testInterest object and prompt:
		 * 		"Do you like basketball?"
		 * 		if yes -> return true and add [key,value] pair to HashMap
		 */
		//  Test case 1: Basketball
		if (testInterest.checkInput(testInterest.getInput(), "Do you like basketball?") == true) {
			System.out.println("Basketball returned true");
			testInterest.setKeyPair("basketball", "true");
		} else {
			System.out.println("Basketball returned false");
			testInterest.setKeyPair("basketball", "false");
		}
		//  Test case 2: Coffee
		if (testInterest.checkInput(testInterest.getInput(), "Do you like coffee?") == true) {
			System.out.println("coffee returned true");
			testInterest.setKeyPair("coffee", "true");
		} else {
			System.out.println("coffee returned false");
			testInterest.setKeyPair("coffee", "false");
		}
		// Print boolean value from key: "basketball"
		System.out.println("Value from key is " + testInterest.getBoolFromKey("basketball"));
		
		// Write all entries from HashMap to file
		testInterest.writeToFile();
	}

}
