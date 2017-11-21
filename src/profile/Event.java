package profile;

/**
 * Event class to hold Event object
 * 
 * @author Manuel Ben Bravo, pfa698
 *
 */
public class Event {
	
	private String date;
	private String eventName;
	
	/**
	 * Constructor for Event 
	 * @param String: date
	 * @param String: event
	 */
	public Event(String date, String event) {
		this.setEventName(event);
		this.setDate(date);
	}
	
	/**
	 * 
	 * @return String: date
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * Sets date
	 * @param String: date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * getter for eventName
	 * @return Sring:eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * Sets eventName
	 * @param String Event
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	/**
	 * To String Function
	 * @param Event e
	 * @return String 
	 */
	public String toString(Event e) {
		return this.date + " " + this.eventName;
	}
}




