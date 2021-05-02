package exceptions;

public class GameOver extends Exception{

  public GameOver() {
    super("Game over! You lost all your money!");
  }
}
