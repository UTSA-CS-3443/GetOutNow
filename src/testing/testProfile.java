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
public class testProfile {

	@Test
	public void test() {
		Scanner buffer = new Scanner(System.in);
		Profile testProf = new Profile("Clarence", "Bumanglag",
				"c.bumanglag.15@gmail.com", "exclusivefish" );
		
		Profile newProf = new Profile(buffer.nextLine(), buffer.nextLine(),
				buffer.nextLine(), buffer.nextLine());
		
		String test1 = newProf.toString();
		String test2 = testProf.toString();
		
		System.out.println("newProf: \n" + newProf);
		System.out.println("testProf: \n" + testProf);
		
		buffer.close();
		assertEquals(test2, test1);
	}
	
}
