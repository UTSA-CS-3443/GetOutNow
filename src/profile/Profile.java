package profile;

/*
 * TODO:
 * 
 * Need Javadocs
 * Profile GUI 
 * 
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

    private String _firstName;		//first name
    private String _lastName;		//last name
    private String _email;		//email
    private String _username;		//username
    private String _password;		//password
    private String _fullName;		//first name and last name combined
   //location variable here
   //Interest list

    

    /*
     * Constructor
     * Creates Profile object
     */
    public Profile(String firstName, String lastName, String email, String username) {
    	
    	this._firstName = firstName;
    	this._lastName = lastName;
    	this._email = email;
    	this._username = username;
        this._fullName = this._firstName + " " + this._lastName;
        
    }
	
     /**
	 * toString for a specific "Profile" object.
	 * @return profile details in String form
	 * 
	 */
	public String toString() {
		String retString = "username:" + _username + "\nName:" 
				+ _fullName + "\nEmail:" + _email + "\n\n";
		
		return retString;
	}

	/**
	* Returns the profile's _firstName
     	* 
     	* @return _email
    	*/
    	public String getfirstName() {
		return _firstName;
	}
         /**
	 * Returns the profile's _firstName
	 * 
	 * @param _firstName
	 */
	public void setfirstName(String firstName) {
		this._firstName = _firstName;
	}
	/**
	 * Returns the profile's last name
	 * 
	 * @return _lastName
	 */
	public String getLastName() {
		return _lastName;
	}

	/**
	 * Sets the profile's last _name
	 * 
	 * @param _lastName
	 */
	public void setLastName(String lastName) {
		this._lastName = _lastName;
	}

	/**
	 * Returns the profile's _email
	 * 
	 * @return _email
	 */
	public String getEmail() {
		return _email;
	}
	
	/**
	 * Sets the _email of the profile
	 * @param _email
	 */
	public void setEmail(String email) {
		this._email = _email;
	}

	/**
	 * Returns the _username of the profile
	 * @return
	 */
	public String getUsername() {
		return _username;
	}

	/**
	 *  Sets the _username of the profile
	 * @param _username
	 */
	public void setUsername(String _username) {
		this._username = _username;
	}
	
	/**
	 * Returns the _name (first and last) of the user profile
	 * 
	 * @return _name of current profile
	 */
	public String getFullName() {
		return _fullName;
        }
	
	/**
	 * Sets the full name of the user profile
	 * 
	 * @return _name of current profile
	 */
	public void setFullName(String firstName, String lastName){
		this._fullName = this._firstName + " " + this._lastName; 	
	}
	
}
