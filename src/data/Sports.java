package data;
import java.util.Scanner;

/**
 * Class for initializing sports preferences.
 * @author Daniel Ghazvini, dib952
 */
public class Sports {
	
	private char answer;
	
	/**
	 * Sports constructor to initialize movie preferences.
	 */
	public Sports() {
		
		Scanner scan = new Scanner(System.in);
		char input;
			
		System.out.println("Enter the letter for the type of sport you like most: ");
		System.out.println("A. Basketball");
		System.out.println("B. Football");
		System.out.println("C. Baseball");
			
		input = scan.next().charAt(0);
		input = Character.toUpperCase(input);
			
		while(input != 'A' && input != 'B' && input != 'C') 
		{
			System.out.println("Incorrect submission, please enter A, B, or C.");
			input = scan.next().charAt(0);	
			input = Character.toUpperCase(input);
		}
		
		this.answer = input;
		
		scan.close();
	}
	
	public char getAnswer() {
		return this.answer;
	}

}
