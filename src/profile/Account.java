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

	// Private variables
	private String email_username;
	private String password;
	private Profile profile;
	private ArrayList<String> userInfo;
	private String oldProBuff;
	private ArrayList<String> tempList;
	
	// Private static variables
	private static BufferedReader in;
	private static BufferedWriter out;
	private static FileReader filein;
	private static FileWriter fileout;
	private static String line;
	
	// saves "profiledata.txt" into a FINAL variable
	private static final String FILENAME = "profiledata.txt";
	
	//<<<< CONSTRUCTOR >>>>
	public Account (String email_username, String password) {
		this.email_username = email_username;
		this.password = password;
		this.userInfo = getInfo();
		this.profile = new Profile(userInfo);
	}
	
	/**
	 * Returns this Account's profile object
	 * @return
	 */
	public Profile getProfile() {
		return this.profile;
	}
	/**
	 * sets userInfo to the ArrayList parameter
	 * 
	 * @param arraylist
	 */
	public void setUserInfo(ArrayList<String> arraylist) {
		this.userInfo = arraylist;
	}
	
	/**
	 * Returns an arraylist that hold the user's information
	 * @return this.userInfo
	 */
	public ArrayList<String> getUserInfo() {
		return userInfo;
	}
	
	
	/**
	 * About:
	 * 
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
	 * This method is in charge of changing the current Profile's email
	 * @param newInfo
	 */
	public void changeEmail(String newInfo) {
		oldProBuff = profile.toString();
		profile.setEmail(newInfo);
		editFile();
	}
	
	/**
	 * This method is in charge of changing the current Profile's password
	 * @param newInfo
	 */
	public void changePassword(String newInfo) {
		oldProBuff = profile.toString();
		profile.setPassword(newInfo);
		editFile();
	}
	
	/**
	 * This method is in charge of changing the current Profile's username
	 * @param newInfo
	 */
	public void changeUsername(String newInfo) {
		oldProBuff = profile.toString();
		profile.setUsername(newInfo);
		editFile();
	}

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
					tempList.add(profile.toString());
				} else {
					tempList.add(line + "\n");
				}
			}
			
			//closes read tools
			in.close();
			filein.close();
			
			//opens write tools
			fileout = new FileWriter(FILENAME);
			out = new BufferedWriter(fileout);
			
			//prints original data with the new profile data
			for (String str: tempList) {
				out.write(str);
			}
			
			// close write tools
			out.close();
			fileout.close();
			
		// catches exception if file cannot be accessed
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		// catches exception if file cannot be edited
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Notes: 
	 * See create_deleteProfile.java in the "testing" package to tests this method
	 * and createProfile(). 
	 * 
	 * About:
	 * This method takes in three parameters and deletes a profile if the the profile exists
	 * in the data file. The password must be confirmed, so the user needs to enter in the 
	 * same password twice in order to delete the account. deleteProfile() will read the contents
	 * of the data file. If the line matches the Account's Profile's toString(), it will not add
	 * that line into the ArrayList buffer, if it does not match, the current line is added into 
	 * the buffer. After all the lines have been read, the ArrayList buffer will write the unmatched
	 * data into the file, and will not write the matched line into the file.
	 * 
	 * Summary:
	 * - If "password" and "confirmPassword" don't match, returns 1.
	 * - If profile data was successfully deleted, returns 0
	 * - Any exceptions (except NullPointerException) will return -1
	 * - "NullPointerException" will be caught if the profile does not exist,
	 * 	and will return -2.
	 * 
	 * 
	 * @param username
	 * @param password
	 * @param confirmPassword
	 * @return
	 */
	public static int deleteProfile(String username, String password, String confirmPassword) {
		
		/*
		 *  confirms that password and confirmPassword are the same. 
		 *  If not, return 1 indicating that they are not indeed the same
		 */
		if (!password.equals(confirmPassword)) {
			System.out.println("Passwords do not match: " + password + " " + confirmPassword);
			return 1;
		}
		
		/*
		 * Deletion sequences
		 */
		try {
			
			// opens reading tools
			FileReader fileread = new FileReader(FILENAME);
			BufferedReader newRead = new BufferedReader(fileread);
			
			// creates a new Account object for testing purposes
			Account accBuff = new Account(username, password);
			
			// buffers for testing 
			ArrayList<String> list = new ArrayList<String>();
			String currentLine;
			
			/*
			 *  saves the current line into the list ArrayList if the
			 *  current line does not match with the to-be deleted Profile 
			 *  toString(). If the to-be deleted toString() matches the current line,
			 *  that line is skipped and will not be added to the ArrayList. 
			 */
			while ((currentLine = newRead.readLine()) != null) {
				if (!(accBuff.getProfile().toString().trim().equals(currentLine.trim()))) {
					list.add(currentLine + "\n");
				}
			}
			
			// close reading tools
			newRead.close();
			fileread.close();
			
			// open writing tools
			FileWriter filewrite = new FileWriter(FILENAME);
			BufferedWriter newWrite = new BufferedWriter(filewrite);
			
			// writes into the data file the data that was not excluded
			for (String s : list) {
				newWrite.write(s);
			}
			
			// closes writing tools
			newWrite.close();
			filewrite.close();
			
		// If the file is unable to be located, returns -1 for exception catch
		} catch (FileNotFoundException e) {
			System.err.println("Unable to read file");
			e.printStackTrace();
			return -1;
		// If there was an error with writing into the file, return -1 for exception catch
		} catch (IOException e) {
			System.err.println("Unable to edit file");
			e.printStackTrace();
			return -1;
		} catch (NullPointerException e) {
			System.err.println("Profile does not exist");
			return -2;
		}
		
		// Returns 0 for successful deletion
		System.out.println("Profile has been deleted");
		return 0;
	}
	
	/**
	 * Notes: 
	 * Please refer to create_deleteProfile.java if you would like to 
	 * test this method and deleteProfile().
	 * 
	 * 	Class Variables:
	 * 
	 * 		- filein (FileReader)
	 * 		- in (BufferedReader)
	 * 		- line (String)
	 * 		- fileOut (FileWriter)
	 * 		- out (BufferedWriter)
	 * 
	 * About:
	 * 
	 * createProfile()'s main function is to create a new Profile object and store
	 * the objects data into the profiledata.txt file. It will first check to see 
	 * if the profile already exists, and if so, returns 1 was its return value. After 
	 * the testing (if the profile indeed does not exist), it will append the new Profile's
	 * toString() into the data file. 
	 * 
	 * Summary:
	 * 
	 * If profile already exists, do not append data and return 1
	 * If profile does not already, append new data into data file and return 0
	 * If there was an error in appending the file, return -1
	 * 		
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param username
	 * @param password
	 * 
	 * @return 0 if successful in making the new profile, 1 if the profile already exists,
	 * 		2 if passwords don't match, and -1 if there was an issue with writing into the data file.
	 */
	public static int createProfile(String firstName, String lastName, 
			String email, String username, String password, String confirmPassword) {
		
		//tests to see if the passwords match
		if (!password.equals(confirmPassword)) {
			System.out.println("Passwords do not match: " + password + " " + confirmPassword);
			return 2;
		}
		
		try {
			
			//open reading tools
			filein = new FileReader(FILENAME);
			in = new BufferedReader(filein);
			Profile proBuff = new Profile(firstName, lastName, email, username, password);
			
			// while the current line is not empty
			while ((line = in.readLine()) != null) {
				
				// Tests to see if the information entered isn't already recorded in the data file
				if (proBuff.toString().trim().equals(line.trim())) {
					in.close();
					filein.close();
					System.out.println("Profile already exists");
					return 1;
				}
			}
			
			// Closes reading tools
			in.close();
			filein.close();
			
			// Opens reading tools
			fileout = new FileWriter(FILENAME, true);
			out = new BufferedWriter(fileout);
			
			//appends to the profiledata file
			out.write(proBuff.toString());
			
			// closes writing tools
			out.close();
			fileout.close();
		
		// if there is an issue with writing in the file, throw IOException
		} catch (IOException e) {
			System.err.println("Unable to append file");
			e.printStackTrace();
			return -1;
		}
		
		// successful creation of profile
		System.out.println("Profile has been successfully created");
		return 0;
	}
}
