package testing;
import profile.Profile;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Scanner;

/**
 * testProfile tests Profile.java to see if input string is the same 
 * as the original profile object
 * @author Clarence Bumanglag
 *
 */
public class TestProfile {

	@Test
	public void test() {
		Scanner buffer = new Scanner(System.in);
		Profile testProf = new Profile("Clarence", "Bumanglag",
				"c.bumanglag.15@gmail.com", "exclusivefish", "thunder" );
		
		System.out.println("Please enter the items in sequence:\nClarence"
				+ "\nBumanglag\nc.bumanglag.15@gmail.com\nexclusivefish\n");
		Profile newProf = new Profile(buffer.nextLine(), buffer.nextLine(),
				buffer.nextLine(), buffer.nextLine(), buffer.nextLine());
		
		String test1 = newProf.toString();
		String test2 = testProf.toString();

		buffer.close();
		assertEquals("Output from both object do not equal", test2, test1);
	}
	
}
