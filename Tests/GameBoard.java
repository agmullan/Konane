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

public class GameBoard{

  //instance variables
  char[][] gameBoard = new char[8][8];
  boolean gameWon;
  Player white, black;

  //constructor
  public GameBoard(){
    newGameBoard();
    chooseYourColor();
    runGame();

  }

  public void runGame(){
    while(!gameWon){

      gameBoard = black.takeTurn();

      printGameBoard();

      gameBoard = white.takeTurn();

      printGameBoard();

      gameWon = checkForWin();
    }
  }

  public boolean checkForWin(){
    return true;
  }

  public void newGameBoard(){
    for(int i = 0; i < 8; i ++){
      for(int j = 0; j < 8; j ++){
        if((i+j) % 2 == 0){
          gameBoard[i][j] = 'b';
        }else{
          gameBoard[i][j] = 'w';
        }
      }
    }
  }

  public void printGameBoard(){
    for(int i = 0; i < 8; i ++){
      for(int j = 0; j < 8; j ++){
        System.out.print(gameBoard[i][j]);
        System.out.print(" ");
      }
      System.out.print("\n");
    }
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
      black = new Human();
      white = new Agent();
    }
    else if(ans.equals("w")){
      white = new Human();
      black = new Agent();
    }
  }

}//end of GameBoard class
