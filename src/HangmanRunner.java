import java.util.Scanner;
public class HangmanRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String play = "yes";
        int playerTurn = (int) (Math.random() * 2 + 1);
        String guess = "";

        while (play.equals("yes")) {
            String lettersGuessed="";

            if (playerTurn % 2 == 1) {
                System.out.println("User 1 enter a word:");
            } else {
                System.out.println("User 2 enter a word:");
            }
            String secretWord = input.nextLine();
            Hangman newGame = new Hangman(secretWord);
            newGame.pageBreak();

            while (newGame.GameInPlay()) {

                if(playerTurn%2==1){
                    System.out.print("Player two guess a letter:");}
                else{
                    System.out.println("Player one guess a letter:");
                }
                guess=input.nextLine();
                newGame.pageBreak();


                if(lettersGuessed.contains(guess)){
                    System.out.println("You already guessed that letter, try another one:");
                    guess=input.nextLine();
                }
                if(guess.length()==1){
                    lettersGuessed+=guess+" ";
                }

                newGame.guessWord(guess);
                System.out.println("Letters already guessed: "+lettersGuessed);



            }
            playerTurn++;
            System.out.println("Do you want to play again(yes/no): ");
            play=input.nextLine();
        }
        System.out.println("Thank you for playing.");

    }

}