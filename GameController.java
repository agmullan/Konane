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
import java.util.*;

public class GameController{

  //instance variables
  private GameBoard gameBoard;
  private boolean gameWon;
  private Player white, black;
  private int round = 2;
  static Scanner scan;

  //constructor
  public GameController(){
    gameBoard = new GameBoard();
    gameWon = false;
    chooseYourColor();
    runGame();
  }


  public void firstTurn(Player p){
    ArrayList<Move> moves;
    Move m;
    if(!p.isCPU()){ //if this player is human
      moves = p.takeFirstTurn(gameBoard);
      m = p.playerChooseMove(moves, selectMove(moves, p.myColor()));
    }else{
      moves = p.takeFirstTurn(gameBoard);
      m = p.chooseMove(moves);
    }
    gameBoard.update(m, p.myColor());
    gameBoard.printGameBoard();
  }

  public void turn(Player p){
    ArrayList<Move> moves;
    Move m;
    if(!p.isCPU()){ //if this player is human
      moves = p.takeTurn(gameBoard);
      m = p.playerChooseMove(moves, selectMove(moves, p.myColor()));
    }else{
      moves = p.takeTurn(gameBoard);
      m = p.chooseMove(moves);
    }
    
    String loser;
    String winner;
    if(p.myColor() == 'b'){
        loser = "Black";
        winner = "White";
    }else{
        loser = "White";
        winner = "Black";
    }
    
    gameWon = checkForWin(m, loser, winner);

    gameBoard.update(m, p.myColor());
    gameBoard.printGameBoard();
  }

  public void runGame(){

    ArrayList<Move> moves;
    Move m;

    gameBoard.printGameBoard();

    //BLACK FIRST MOVE
    System.out.println("round 1: Black");
    firstTurn(black);

    //WHITE FIRST MOVE
    System.out.println("round 1: White");
    firstTurn(white);

    //BEGIN REST OF GAME
    while(!gameWon){
      System.out.println("round " + round + ": Black");
      turn(black);

      System.out.println("round " + round + ": White");
      turn(white);

      round++;
    }
  }

  public int selectMove(ArrayList<Move> alm, char myColor){
    if(alm.size() == 0){
        System.out.println("No moves");
        return 0;
    }   
    System.out.println(myColor + "'s moves:");
    for(int i = 0; i < alm.size(); i++){
        System.out.println(alm.get(i));
    }
    scan = new Scanner(System.in);
    System.out.println("Enter the number of the move you choose.");
    int i = scan.nextInt()-1;
    
    return i;
  }

  public boolean checkForWin(Move m, String loser, String winner){
    if(m.noMove() == true){
      scan.close();
      System.out.println(loser + "! you are out of moves! " + winner + "! You win!");
      System.exit(0);
    }
    return false;
  }

  public void chooseYourColor(){
    String ans = "";
    boolean validInput = false;

    scan = new Scanner(System.in);

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
    //scan.close();

    if(ans.equals("b")){
      black = new Human('b', false);
      white = new Agent('w', true);
    }
    else if(ans.equals("w")){
      System.out.println("HERE");
      white = new Human('w', false);
      black = new Agent('b', true);
      System.out.println(black.isCPU());
    }
  }

}//end of GameBoard class
