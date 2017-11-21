package profile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*Changelog
*   11/15/2017
*       - Created class
*       - Added potential methods 
*
*   TODO:
*       Create an events object
*/


import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Julian Chan / xmp183
 * Planner.java will store events and associate the list to a username.
 * The list of events and username will then be stored to a text file.
 *
 */
public class Planner {
	private String username;
	private Map<String, ArrayList<String>> userPlan;
	private ArrayList<String> eventList; // arrayList of events (sorted by descending order by date)

	// Declare variables for File I/O
	private static final String PLANNERFILE = "planner.txt";
	private static BufferedReader in;
	private static BufferedWriter out;
	private static FileReader filein;
	private static FileWriter fileout;
	private static String line;
  
	// constructor
	public Planner(String username) {
		this.username = username;
		this.eventList = new ArrayList<String>();
		this.userPlan = new HashMap();
	}
  
	// add an event to arrayList
	public void scheduleEvent(String event) {
		this.eventList.add(event);
	}
  
	// remove event from arrayList
	public void removeEvent(int index) {
		this.eventList.remove(index);
	}
	
	// return ArrayList of eventList
	public ArrayList<String> getEventList() {
		return this.eventList;
	}
	
	/**
	 * writeEventList() will write the username and event list to the data file
	 */
	public void writeEventList() {
		try {
			// Initialize variables for FILE IO
			Planner.fileout = new FileWriter(PLANNERFILE);
			Planner.out = new BufferedWriter(Planner.fileout);
			Planner.out.write(this.username + "\n");   // write username to file
			// write list of events to file
			for (String str : this.eventList) {
				Planner.out.write(str + "\n");
			}
			// close FILE IO
			Planner.out.close();
			Planner.fileout.close();
		} catch (FileNotFoundException e) {              // catch if file not found
			System.err.println("File not found");
			System.exit(-1);
		} catch (IOException e) {
			System.err.println("File cannot be read");   // catch if file cannot be read
			System.exit(-1);
		}
	}
}