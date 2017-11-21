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
	
	
	public Event(String event, String date) {
		this.setEventName(event);
		this.setDate(date);
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getEventName() {
		return eventName;
	}


	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
}
