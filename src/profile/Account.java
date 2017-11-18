package profile;
import java.io.*;
import java.util.ArrayList;


/**
 * Settings.java will be take the user's profile information to 
 * access their settings preferences. Settings should overwrite 
 * data within the text file that has all the user's data. 
 * 
 * @author Clarence Bumanglag
 */
public class Account {

	private String email_username;
	private String password;
	private Profile profile;
	private ArrayList<String> userInfo;
	private ArrayList<String> tempList;
	private BufferedReader in;
	private BufferedWriter out;
	private FileReader filein;
	private FileWriter fileout;
	private String oldProBuff;
	private String line;
	
	private final String FILENAME = "profiledata.txt";
	
	//<<<< CONSTRUCTOR >>>>
	public Account (String email_username, String password) {
		this.email_username = email_username;
		this.password = password;
		this.userInfo = getInfo();
		this.profile = new Profile(userInfo);
	}
	
	public Profile getProfile() {
		return this.profile;
	}
	/**
	 * sets userInfo to the specified parameter
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
		try {
			filein = new FileReader(FILENAME);
			in = new BufferedReader(filein);
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
						filein.close();
						return tempList;
					}
				}
			}
		/*
		 * Catches exception in the event that the file was not found
		 */
		} catch (FileNotFoundException e) {
			System.err.println("File \""+FILENAME+"\" not found");
			System.exit(-1);
		/*
		 * Catches exception in the event that the file was not readable
		 */
		} catch (IOException e) {
			System.err.println("Cannot read \""+FILENAME+"\"");
			System.exit(-1);
		}
		//return statement
		return null;
	}
	
	/**
	 * Pseudo-setter for newProBuff. newProBuff will contain the new name
	 * for user info testing.
	 * 
	 * @param newInfo
	 */
	public void changeName(String newInfo) {
		oldProBuff = profile.toString();
		profile.setName(newInfo);
		editFile();
	}
	/**
	 * 
	 * @param newInfo
	 */
	public void changeEmail(String newInfo) {
		oldProBuff = profile.toString();
		profile.setEmail(newInfo);
		editFile();
	}
	
	/**
	 * 
	 * @param newInfo
	 */
	public void changePassword(String newInfo) {
		oldProBuff = profile.toString();
		profile.setPassword(newInfo);
		editFile();
	}
	
	/**
	 * 
	 * @param newInfo
	 */
	public void changeUsername(String newInfo) {
		oldProBuff = profile.toString();
		profile.setUsername(newInfo);
		editFile();
	}
	//public void change
	
	
	/**
	 * Notes: 
	 * 		- editFile() will ALWAYS be called after a changeUsername(), changeName(),
	 * 		changePassword(), or changeEmail() is called.
	 *  
	 *  Class variables used: 
	 *  	- tempList (ArrayList<String>)
	 *  	- filein (FileReader)
	 *  	- in (BufferedReader)
	 *  	- profile (Profile)
	 *  	- fileout (FileWriter)
	 *  	- out (BufferedWriter)
	 *  	- oldProBuff (String)
	 *  	
	 * 	About:
	 * 	This method reads and overwrites data in "profiledata.txt". While
	 * 	reading the file, it will test if a line equals the old data prior to
	 * 	the changes. If the line does happen to equal the old information, 
	 * 	the new Profile information will be saved into the ArrayList tempList. If
	 * 	the line does not match with the old data, that current line read will
	 * 	be saved into tempList. After the read process, "profiledata.txt" will 
	 * 	be overwritten with new information stored in tempList. For every
	 * 	string stored in tempList, "profiledata.txt" will be overwritten
	 *  by the strings stored in tempList. After the write process, the file is 
	 *  closed. 
	 * 
	 */
	public void editFile() {
		
		//flushes tempList just in case there is stuff in it
		tempList = null;
		tempList = new ArrayList<String>();
		
		try {
			// file read buffer
			filein = new FileReader(FILENAME);
			in = new BufferedReader(filein);
			
			// while file is not empty
			while((line = in.readLine()) != null) {
				
				//compares the two
				if(line.trim().equals(oldProBuff.trim())) {
					System.out.println("Found old data");
					tempList.add(profile.toString().trim());
				} else {
					System.out.println("Data does not match");
					tempList.add(line.trim());
				}
			}
			in.close();
			filein.close();
			fileout = new FileWriter(FILENAME);
			out = new BufferedWriter(fileout);
			for (String str: tempList) {
				out.write(str);
			}
			fileout.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProfile() {
		
	}
	public void createProfile(String username, String password, String confirmPassword) {
		
	}
}
