/**
* @author: Francine Dennehy
* @author: Alexandra Mullan
* @version: 1.0
* This class contains the methods to make the game functioning.
* These methods inclube making the GameBoard, keeping the game loop up to date,
* and much more
*
**/
import java.util.Scanner;

public class GameController{

  //instance variables
  //char[][] gameBoard = new char[8][8];
  GameBoard gameBoard;
  boolean gameWon;
  Player white, black;

  //constructor
  public GameController(){

    chooseYourColor();
    runGame();

  }

  public void runGame(){
    while(!gameWon){

      gameBoard = black.takeTurn();

      gameBoard.printGameBoard();

      gameBoard = white.takeTurn();

      gameBoard.printGameBoard();

      gameWon = checkForWin();
    }
  }

  public boolean checkForWin(){
    return true;
  }





  public void chooseYourColor(){
    String ans = "";
    boolean validInput = false;

    Scanner scan = new Scanner(System.in);

    while(!validInput){

      System.out.println("Choose your color. Type b for black or w for white: ");

      ans = scan.next();

      if(ans.equals("b") || ans.equals("w")){
        validInput = true;
      }

      if(!validInput){
        System.out.println("invalid input, try again.");
      }
    }
    scan.close();

    if(ans.equals("b")){
      black = new Human('b');
      white = new Agent('w');
    }
    else if(ans.equals("w")){
      white = new Human('w');
      black = new Agent('b');
    }
  }

}//end of GameBoard class
