package testing;
import profile.Account;
//import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.Assert.*;

import org.junit.Test;
/**
 * TestSettings tests to see if there are any errors with reading 
 * the file, user input via console, exception handling, etc.
 * 
 * @author Clarence Bumanglag
 */
public class TestAccount {

	private Account set = null;
//	private ArrayList<String> testAL = null;
	private Scanner in = new Scanner(System.in);
	private String command;
	private String infoBuff;
	
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
			set = new Account(username, password);
			//if testAL is empty
		} catch (NullPointerException e) {
			System.err.println("Unable to find information");
			test();
		} finally {
			settingModule();
		}
	}
	
	public void settingModule() {

		System.out.println("Would you like to make any changes to your account?");
		System.out.println("Type one of the following commands:");
		System.out.println("a - change name");
		System.out.println("b - change username");
		System.out.println("c - change password");
		System.out.println("d - change email");
		System.out.println("exit - exit program");

		while(true) {
			command = in.nextLine();
			if (!(command.equalsIgnoreCase("a") || command.equalsIgnoreCase("b") || 
					command.equalsIgnoreCase("c") || command.equalsIgnoreCase("d") || 
					command.equalsIgnoreCase("exit"))) {
				System.out.println("Incorrect value has been entered: " + command);
			} else {
				break;
			}
		}
		if (command.equals("a")) {
			System.out.println("Please enter the new name you would like to use.");
			infoBuff = in.nextLine();
			System.out.println("Are you sure you want to change '" 
					+ set.getProfile().getName() + "' to '" + infoBuff +"'?" );
			System.out.println("Please enter yes or no");
			while(true) {
				command = in.nextLine();
				if (command.equals("yes")) {
					set.changeName(infoBuff);
					break;
				} else if (command.equals("no")) {
					System.out.println("Going back to main menu...");
					settingModule();
				} else {
					System.out.println("Invalid command");
				}
			}
		} else if (command.equals("b")) {
				System.out.println("Please enter the new username you would like to use.");
				infoBuff = in.nextLine();
				System.out.println("Are you sure you want to change '" 
						+ set.getProfile().getUsername() + "' to '" + infoBuff +"'?" );
				System.out.println("Please enter yes or no");
				while(true) {
					command = in.nextLine();
					if (command.equals("yes")) {
						set.changeUsername(infoBuff);
						break;
					} else if (command.equals("no")) {
						System.out.println("Going back to main menu...");
						settingModule();
					} else {
						System.out.println("Invalid command");
					}
				}
			} else if (command.equals("c")) {
				System.out.println("Please enter the new name you would like to use.");
				infoBuff = in.nextLine();
				System.out.println("Are you sure you want to change '" 
						+ set.getProfile().getPassword() + "' to '" + infoBuff +"'?" );
				System.out.println("Please enter yes or no");
				while(true) {
					command = in.nextLine();
					if (command.equals("yes")) {
						set.changePassword(infoBuff);
						break;
					} else if (command.equals("no")) {
						System.out.println("Going back to main menu...");
						settingModule();
					} else {
						System.out.println("Invalid command");
					}
				}
			} else if (command.equals("d")) {
				System.out.println("Please enter the new email you would like to use.");
				infoBuff = in.nextLine();
				System.out.println("Are you sure you want to change '" 
						+ set.getProfile().getEmail() + "' to '" + infoBuff +"'?" );
				System.out.println("Please enter yes or no");
				while(true) {
					command = in.nextLine();
					if (command.equals("yes")) {
						set.changeEmail(infoBuff);
						break;
					} else if (command.equals("no")) {
						System.out.println("Going back to main menu...");
						settingModule();
					} else {
						System.out.println("Invalid command");
					}
				}
			} else {
				System.out.println("Now exiting program...");
				in.close();
				return;
				/*
				assertEquals(true, true);
				in.close();
				System.exit(0);
				*/
			}
		System.out.println("Done! Your information has been updated");
		in.close();
	}
}
