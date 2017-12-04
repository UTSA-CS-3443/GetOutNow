package applicationModel;
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
		System.out.println("D. Basketball and Football");
			
		input = scan.next().charAt(0);
		input = Character.toUpperCase(input);
			
		while(input != 'A' && input != 'B' && input != 'D') 
		{
			if(input != 'C')
				System.out.println("Incorrect submission, please enter A, B, C, or D.");
			if(input == 'C')
				System.out.println("Baseball season is actually over right now, so you won't be able to choose it! Please choose A, B, or D.");
			input = scan.next().charAt(0);	
			input = Character.toUpperCase(input);
		}
		
		this.answer = input;
		
	}
	
	public char getAnswer() {
		return this.answer;
	}

}
