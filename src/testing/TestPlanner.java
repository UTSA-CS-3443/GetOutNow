package testing;

import org.junit.Test;

import profile.Planner;
import profile.Event;

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
		// Create Event objects to store Strings 'Date' and 'Event'
		// Add events to event list
		Event event1 = new Event("September 1", "Getting coffee");
		Event event2 = new Event("September 3", "Going to a baseball game");
		testPlan.scheduleEvent(event1);
		testPlan.scheduleEvent(event2);
		// Loop through and print events from event list
		for (Event event : testPlan.getEventList()) {
			System.out.println(event);
		}
		// Write event list to data file
		testPlan.writeEventList();
		// Remove an event from event list via index
		System.out.println("Testing removal");
		testPlan.removeEvent(event1);
		// Loop through and print events from event list AGAIN
		for (Event event : testPlan.getEventList()) {
			System.out.println(event);
		}
	}
}
