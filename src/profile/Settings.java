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

//	private Scanner fileRead;
	private String email_username;
	private String password;
	private Profile profileHandler = null;
	private ArrayList<String> userInfo = null;
	protected BufferedReader in = null;
	
	/*
	 * Constructor
	 */
	public Settings (String email_username, String password) {
		this.email_username = email_username;
		this.password = password;
		setUserInfo();
		this.profileHandler = new Profile(userInfo);
	}
	
	
	public void setUserInfo() {
		this.userInfo = getInfo();
	}
	
	public ArrayList<String> getUserInfo() {
		return userInfo;
	}
	/**
	 * 
	 * @param email_username
	 * @param password
	 * @param in
	 * 
	 * @return ArrayList<String> that has the user's information.
	 */
	public ArrayList<String> getInfo(){
		String filename = "profiledata.txt";
		try {
			String line;
			in = new BufferedReader(new FileReader(filename));
			while ((line = in.readLine()) != null) {
				System.out.println(line);
				String[] buffer = new String[8];
				if (line.startsWith("U")) {
					
					//splits the line by colons
					buffer = line.split(":");
					for (String s : buffer) {
						System.out.println(s);
					}
					/*
					 * Tests to see if email_username is equal to the current line's
					 * username or email and if password is equal to the current line's
					 * password. If the test is true, saves the information in the 
					 * ArrayList "userInfo". Information is stored in this order
					 * 
					 * 	username , email , password , name
					 */
					if ((email_username.equals(buffer[1]) || email_username.equals(buffer[3])) 
							&& password.equals(buffer[5])) {
						userInfo.set(0, buffer[1]); userInfo.set(1, buffer[3]); 
						userInfo.set(2, buffer[5]); userInfo.set(3, buffer[7]);
						in.close();
						break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File \""+filename+"\" not found");
			System.exit(-1);
		} catch (IOException e) {
			System.err.println("Cannot read \""+filename+"\"");
			System.exit(-1);
		}
		return userInfo;
	}
	
	//public abstract 
	
	
}
