/**
 * 
 */
package testing;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

import profile.Account;

/**
 * @author Clarence Bumanglag
 *
 */
public class create_deleteProfile {

	private Scanner in = new Scanner(System.in);
	private String s1;
	private String s2;
	private String s3;
	private String s4;
	private String s5;
	private String s6;
	
	/**
	 * Test method for {@link profile.Account#deleteProfile()}.
	 */
	@Test
	public void testDeleteProfile() {
		System.out.println("Enter a username, password, and the same password for deletion");
		s1 = in.nextLine();
		s2 = in.nextLine();
		s3 = in.nextLine();

		// For successful deletion
		assertEquals(0, Account.deleteProfile(s1, s2, s3));
		
		
		//assertEquals(1, Account.deleteProfile(s1, s2, s3));
		//assertEquals(-2, Account.deleteProfile(s1, s2, s3));
	}

	/**
	 * Test method for {@link profile.Account#createProfile(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCreateProfile() {
		System.out.println("Enter a first name, last name, "
				+ "email, username, and password twice for creating");
		s1 = in.nextLine();
		s2 = in.nextLine();
		s3 = in.nextLine();
		s4 = in.nextLine();
		s5 = in.nextLine();
		s6 = in.nextLine();
		
		//For successful addition
		assertEquals(0, Account.createProfile(s1, s2, s3, s4, s5, s6));
		//assertEquals(1, Account.createProfile(s1, s2, s3, s4, s5));
	}

}
