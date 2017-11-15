package profile;

/*
 * TODO:
 * 
 * Need Javadocs
 * 
 * 11/14/17
 * Patched to standards.
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
 *	11/15/17
 *	- 
 * 
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
    private String email;		//email
    private String username;		//username
    private String name;		//first name and last name combined
    //City (String)
    //zip code (int)

    

    /*
     * Constructor
     * Creates Profile object
     */
    public Profile(String firstName, String lastName, String email, String username) {
    	
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.email = email;
    	this.username = username;
        this.name = this.firstName + " " + this.lastName;
        
    }
	
         /**
	 * toString for a specific "Profile" object.
	 * @return profile details in String form
	 * 
	 */
	public String toString() {
		String retString = "Username:" + username + "\nName:" 
				+ name + "\nEmail:" + email + "\n\n";
		
		return retString;
	}

	/**
	* Returns the profile's firstName
     	* 
     	* @return email
    	*/
    	public String getFirstName() {
		return firstName;
	}
         /**
	 * Returns the profile's firstName
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * Returns the profile's last name
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the profile's last name
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns the profile's email
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email of the profile
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns the username of the profile
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 *  Sets the username of the profile
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Returns the name (first and last) of the user profile
	 * 
	 * @param name
	 * @return Name of current profile
	 */
	public String getName() {
		return name;
    }
	
	
}
