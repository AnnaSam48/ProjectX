import java.util.Scanner;

public class UserInputOutput {

//    public void startUpText(){
//        System.out.println("Hello! This is console game 2048.");
//        System.out.println("Your task is to move tiles with numbers, so that there are two adjacent tiles with same values.");
//        System.out.println("The tiles (according to your direction input) with same values will merge and their value will sum up.");
//        System.out.println("Can you get to 2048? We shall see... We wish you best of luck!");
//    }

    public String getUserInput() {
        Scanner move = new Scanner(System.in);
        System.out.println("Please move with letters: 'a' 's' 'd' or 'w'");
        String userInput = move.next();
        return userInput;
    }

    public void endGame() {
        System.out.println("Congratulations!");
      //  System.out.println("Your score: " +score);
    }
}
