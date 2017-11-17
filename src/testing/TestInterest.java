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
		if (testInterest.checkInput(testInterest.getInput(), "Do you like basketball?") == true) {
			System.out.println("Returned true");
			testInterest.setKeyPair("basketball", "true");
		} else {
			System.out.println("Returned false");
		}
		// Print boolean value from key: "basketball"
		System.out.println("Value from key is " + testInterest.getBoolFromKey("basketball"));
	}

}
