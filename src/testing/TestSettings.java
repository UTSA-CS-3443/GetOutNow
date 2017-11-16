package testing;
import profile.Settings;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * TestSettings tests to see if there are any errors with reading 
 * the file, user input via console, exception handling, etc.
 * 
 * @author Clarence Bumanglag
 */
public class TestSettings {

	private Settings test = null;
	private ArrayList<String> testAL = null;
	private Scanner in = new Scanner(System.in);
	
	/**
	 * main objective is to test if a username and password (entered through console)
	 * is found within the data file. Tests for different cases such as 
	 * error testing for not finding information inputted.
	 * 
	 */
	@Test
	public void test() {
		
		//prompts user to enter username and password via console
		System.out.println("Please enter a username and password. Type 'exit' if you would"
				+ " like to exit the program\n");
		
		//prompts the user for a username
		System.out.print("Username: ");
		String username = in.nextLine();
		//exits if user types "exit"
		if (username.equalsIgnoreCase("exit")) {
			System.out.println("Exiting program...");
			System.exit(0);
		}
		
		//prompts the user for the username's password
		System.out.print("Password: ");
		String password = in.nextLine();
		//exits if the user types "exit"
		if (password.equalsIgnoreCase("exit")) {
			System.out.println("Exiting program...");
			System.exit(0);
		}

		//tests to see if the username and password is in the data file.
		try {
			test = new Settings(username, password);
			testAL = test.getUserInfo();
			for (String s: testAL) {
				System.out.println(s);
			}
			//if testAL is empty
		} catch (NullPointerException e) {
			System.err.println("Unable to find information");
			test();
		} finally {
			in.close();
		}
	}

}
