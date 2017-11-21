package testing;

import org.junit.Test;

import profile.Planner;

/**
 * 
 * @author Julian Chan / xmp183
 * TestPlanner class for testing Planner.java
 *
 */
public class TestPlanner {

	// Test method
	@Test
	public void Test() {
		// Create new Planner object with username => "testUser"
		Planner testPlan = new Planner("testUser");
		// Add events to event list
		testPlan.scheduleEvent("Getting food");
		testPlan.scheduleEvent("Going to a baseball game");
		// Loop through and print events from event list
		for (String str : testPlan.getEventList()) {
			System.out.println(str);
		}
		// Write event list to data file
		testPlan.writeEventList();
		// Remove an event from event list via index
		System.out.println("Testing removal");
		testPlan.removeEvent(1);
		// Loop through and print events from event list AGAIN
		for (String str : testPlan.getEventList()) {
			System.out.println(str);
		}
	}
}
