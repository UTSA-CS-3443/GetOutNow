package profile;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Settings.java will be take the user's profile information to 
 * access their settings preferences. Settings should overwrite 
 * data within the text file that has all the user's data. 
 * 
 * @author Clarence Bumanglag
 */
public class Settings {

	private String email_username;
	private String password;
	private Profile profileHandler = null;
	private ArrayList<String> userInfo = null;
	private BufferedReader in = null;
	
	//<<<< CONSTRUCTOR >>>>
	public Settings (String email_username, String password) {
		this.email_username = email_username;
		this.password = password;
		this.userInfo = getInfo();
		//this.profileHandler = new Profile(userInfo);
	}
	
	/**
	 * sets userInfo to the specified paramater
	 * 
	 * @param arraylist
	 */
	public void setUserInfo(ArrayList<String> arraylist) {
		this.userInfo = arraylist;
	}
	
	/**
	 * Returns an arraylist that hold the user's information
	 * @return
	 */
	public ArrayList<String> getUserInfo() {
		return userInfo;
	}
	
	/**
	 * getInfo opens that data file "pofiledata.txt" and tests to see if the
	 * a line contains a user's username/email and password. If a line does contain
	 * the user's username/email and password, the arraylist takes the line and saves the
	 * line's information. From index 0 to 3, the arraylist should contain the following
	 * (0) = username
	 * (1) = email
	 * (2) = password
	 * (3) = Name (First, Last)
	 * 
	 * @return an arraylist with the user's data (tempList)
	 */
	public ArrayList<String> getInfo(){
		
		// filename saves the name of the data file
		String filename = "profiledata.txt";
		
		// a local arraylist is created for testing
		ArrayList<String> tempList = null;
		
		// line buffer for the file
		String line;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			while ((line = in.readLine()) != null) {
				String[] buffer = new String[8];
				if (line.startsWith("U")) {
					
					//splits the line by colons
					buffer = line.split(":");
					/*
					 * Tests to see if email_username is equal to the current line's
					 * username or email and if password is equal to the current line's
					 * password. If the test is true, saves the information in the 
					 * ArrayList "userInfo". Information is stored in this order
					 * 
					 * 	username , email , password , name
					 */
					if ((email_username.equals(buffer[1]) || email_username.equalsIgnoreCase(buffer[3])) 
							&& password.equals(buffer[5])) {
						tempList = new ArrayList<String>();
						tempList.add(buffer[1]); //username
						tempList.add(buffer[3]); //email
						tempList.add(buffer[5]); //password
						tempList.add(buffer[7]); //fullname
						in.close();
						return tempList;
					}
				}
			}
		/*
		 * Catches exception in the event that the file was not found
		 */
		} catch (FileNotFoundException e) {
			System.err.println("File \""+filename+"\" not found");
			System.exit(-1);
		/*
		 * Catches exception in the event that the file was not readable
		 */
		} catch (IOException e) {
			System.err.println("Cannot read \""+filename+"\"");
			System.exit(-1);
		}
		
		//return statement
		return null;
	}
}
