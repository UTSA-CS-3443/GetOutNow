package applicationModel;
import java.util.Scanner;

/**
 * Class for maintaining movie recommendations.
 * @author Daniel Ghazvini, dib952
 */
public class Movies {
	
	private char answer;
	
	/**
	 * Movies constructor to initialize movie preferences.
	 */
	public Movies() {
		
		Scanner scan = new Scanner(System.in);
		char input;
			
		System.out.println("Enter the letter for the type of movies you like: ");
		System.out.println("A. Action");
		System.out.println("B. Science Fiction");
		System.out.println("C. Comedy");
			
		input = scan.next().charAt(0);
		input = Character.toUpperCase(input);
			
		while(input != 'A' && input != 'B' && input != 'C') 
		{
			System.out.println("Incorrect submission, please enter A, B, or C.");
			input = scan.next().charAt(0);	
			input = Character.toUpperCase(input);
		}
		
		this.answer = input;
	}
	
	/**
	 * Returns the input answer.
	 * @return char value answer.
	 */
	public char getAnswer() {
		return this.answer;
	}
}

