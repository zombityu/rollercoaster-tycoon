import exceptions.GameOver;
import game.GameController;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String answer;
   while(true){
     try {
       GameController game = new GameController();
       game.play();
     } catch (GameOver gameOver) {
       gameOver.printStackTrace();
       System.out.println("Want a New Game? yes or no");
       answer = sc.nextLine();
       if (answer.equals("no")){
         System.out.println("Thank you! Byee...");
         break;
       } else if(!answer.equals("yes")) {
         System.out.println("Wrong answer! Byee...");
         break;       }
     }
   }
  }


}
