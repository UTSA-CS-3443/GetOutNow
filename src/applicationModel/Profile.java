package applicationModel;

import java.util.ArrayList;

/**
 * 
 * Profile.java stores the user's information and will be manipulated 
 * for any changes via the Settings.java file.
 * 
 *@author Clarence Bumanglag
 */

public class Profile {

	// Profile's variables
	private String firstName;		//first name
    private String lastName;		//last name
    private String email;			//email
    private String username;		//username
    private String name;			//first name and last name combined
    private String password;		//password

    /**
     * <<<<<PRIMARY CONSTRUCTOR>>>>>
     * 
     * Constructs a Profile object using the information
     * provided by an ArrayList. The ArrayList gets its information
     * from the data file "profiledata.txt"
     * 
     * @param An ArrayList holding user information
     */
    public Profile (ArrayList<String> userInfo) {
    	this.username = userInfo.get(0);
    	this.email = userInfo.get(1);
    	this.password = userInfo.get(2);
    	this.name = userInfo.get(3);
    }
    
    /**
     *      * <<<<<SECONDARY CONSTRUCTOR>>>>>
     * Creates Profile object. This constructor is only accessed
     * when a the method createProfile() is called from Account.java
     * (Account.createProfile()). Should lead to creating a new profile
     * and saving the new Profile contents into the data file "profiledata.txt"
     * 
     * @param firstName
     * @param lastName
     * @param email
     * @param username
     * @param password
     */
    public Profile(String firstName, String lastName, String email, String username, String password) {
    	
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.email = email;
    	this.username = username;
        this.name = this.firstName + " " + this.lastName;
        this.password = password;
    }

    /**
     * Getter for this Profile's last name
     * @return last name
     */
    public String getLastName() {
		return lastName;
	}

    /**
     * Setter for this Profile's last name
     * @param lastName
     */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter for this Profile's email
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter for this Profile's email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter for this Profile's username
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Setter for this Profile's username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Getter for this Profile's Name
	 * 
	 * @return full name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for this Profile's name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
    
	/**
	 * Getter for this Profile's password
	 * 
	 * @return password
	 */
    public String getPassword() {
    	return this.password;
    }
    
    /**
     * Setter for this Profile's password
     * 
     * @param password
     */
    public void setPassword(String password) {
    	this.password = password;
    }
    
    /**
     * Getter for this Profile's first name
     * @return first name
     */
    public String getFirstName() {
		return firstName;
	}

    /**
     * Setter for this Profile's first name
     * @param firstName
     */
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
