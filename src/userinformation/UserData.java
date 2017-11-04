package userinformation;
/**
 * Class to store personal user information
 * 
 * @author Manuel Ben Bravo pfa698
 */
public class UserData {
	
	private String Name;
	private int age;
	
	
	/* Constructor for user information
	 * 
	 */
	public UserData(String name, int age) {
		this.Name = name;
		this.age = age;
	}
	
	public String getName() {
		return this.Name;
	}
	public int getAge() {
		return this.age;
	}
}
