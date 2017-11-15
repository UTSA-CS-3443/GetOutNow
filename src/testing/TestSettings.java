package testing;
import profile.Settings;
import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestSettings {

	@Test
	public void test() {
		Settings test = new Settings("fish", "goldfish");
		ArrayList<String> testAL = test.getUserInfo();
		for (String s: testAL) {
			System.out.println(s);
		}
	}

}
