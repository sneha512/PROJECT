import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      String play="YES";
      
      while(play.equals("YES")){
        Random rand=new Random();
        int randNum=rand.nextInt(100);
        int guess=-1;
        int tries=0;
        
        while(guess!=randNum){
          System.out.print("Guess a number between 1 and 100: ");
          guess=sc.nextInt();
          tries++;
          
          if(guess==randNum){
            System.out.println("Awesome! You guessed the number!");
            System.out.println("It only took you "+ tries +" guesses!");
            System.out.print("would you like to play again? YES or NO: ");
            play=sc.next().toLowerCase();
          }
          else if(guess>randNum){
            System.out.println("Your guess is too high, try again.");
          }
          else{
            System.out.println("Your guess is too low, try again.");
          }
        }
      }
      
      sc.close();
  }
}
