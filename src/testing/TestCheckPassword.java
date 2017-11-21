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
public class TestCheckPassword {

	@Test
	public void test() {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a password to test");
		assertEquals(Account.checkPassword(in.nextLine()), true);
		in.close();
	}

}
