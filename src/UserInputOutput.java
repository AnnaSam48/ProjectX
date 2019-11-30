import java.util.Scanner;
public class UserInputOutput {
	public static void main(String[] args) {
		//UserInputOutput userInputOutput = new UserInputOutput ();
		
		Scanner move = new Scanner(System.in);
		System.out.println("Please move with letters: 'a' 's' 'd' or 'w'");
		char userInput = move.nextLine().charAt(0);
		int score = 0;
		System.out.println(userInput); 
		
		//public void endGame () {
			//System.out.println("Congratulations");
		//}

	
			
	}
}