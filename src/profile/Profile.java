package profile;

import java.util.ArrayList;
/*
 * TODO:
 * 
 * Need Javadocs
 * Profile GUI 
 * 
 */

/*
 * Patch Notes:
 * 	 11/14/17 - Changes to Profile class:
 * 	- removed int "age"
 * 	- removed "friendsList", "interestList"
 *  - fixed variable formatting
 *  - removed friends list methods 
 *  - removed "compareTo" method
 *  - Removed "Comparable" implementation
*/

/**
 * 
 * Profile.java stores the user's information and will be manipulated 
 * for any changes via the Settings.java file.
 * 
 * @author Clarence Bumanglag
 * @author Christian San Juan
 *
 */

public class Profile {

	private String firstName;		//first name
    private String lastName;		//last name
    private String email;			//email
    private String username;		//username
    private String name;			//first name and last name combined
    private String password;		//password

    /*
     * Constructor
     * Creates Profile object
     */
    public Profile(String firstName, String lastName, String email, String username, String password) {
    	
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.email = email;
    	this.username = username;
        this.name = this.firstName + " " + this.lastName;
        this.password = password;
    }
    
    /*
     * Secondary Constructor
     */
    public Profile (ArrayList<String> userInfo) {
    	//String[] buffer = new String[2];
    	this.username = userInfo.get(0);
    	this.email = userInfo.get(1);
    	this.password = userInfo.get(2);
    	this.name = userInfo.get(3);
    }
    

    public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    public String getPassword() {
    	return this.password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

     /**
	 * toString for a specific "Profile" object.
	 * @return profile details in String form
	 * 
	 */
	public String toString() {
		
		String retString = "Username:" + username + ":Email:" 
				+ email + ":Password:" + password + ":Name:" + name + "\n";

		return retString;
	}
}