package profile;

/**
 * Event class to hold Event object. This will be used by Planner.java.
 * 
 * @author Manuel Ben Bravo, pfa698
 *
 */
public class Event {
	// values to store date and event name
	private String date;
	private String eventName;
	
	/**
	 * Constructor for Event object
	 * @param String: date
	 * @param String: event
	 */
	public Event(String date, String event) {
		this.setEventName(event);
		this.setDate(date);
	}
	
	/**
	 * return the date from Event object
	 * @return String: date
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * Sets date in Event object
	 * @param String: date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * return the event name from Event object
	 * @return Sring:eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * Set event name in Event object
	 * @param String Event
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	/**
	 * toString Function for printing
	 * @param Event e
	 * @return String 
	 */
	public String toString() {
		return this.date + ":" + this.eventName;
	}
}