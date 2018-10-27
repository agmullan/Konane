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

//Declarations
  private GameBoard gameBoard;
  private boolean gameWon;
  private Player white, black;
  private int round = 2;
  static Scanner scan;

/**
  * @version 1.0
  * This is the Constructor of the GameController class. It is solely
  * responsible for calling all the methods need to start and run a game to finish.
 **/
  public GameController(){
    gameBoard = new GameBoard();
    gameWon = false;
    chooseYourColor();
    runGame();
  }//end of constructor

/**
  * @version 1.0
  * @return void
  * This is the method that controls the first turn of the game. It generates a list of moves
  * based on whether the player is an agent or human and what color is assigned to each player.
  *
 **/
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
  }//end of firstTurn(Player p)

/**
  * @version 1.0
  * @return void
  * This method is responsible for handling turns in the game.
  * It determines if the player is an agent or human and then imploys the corresponding
  * methods found within Agent and Human for the player to move. This method then checks to see
  * if the game is won or not and updats the gameboard to represent the new state.
  *
 **/
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

    gameWon = checkForWin(m, "Black", "White");

    gameBoard.update(m, p.myColor());
    gameBoard.printGameBoard();
  }//end turn(Player p)

/**
  * @version 1.0
  * @return void
  * This is the runGame method which is responsible for the game loop.
  * The loop is dependent on the gameWon boolean that is initially set to
  * false but updates to true when there is a winner.
 **/
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
  }//end of runGame()

/**
  * @version 1.0
  * @return int i
  * This is used to get the move from the human player.
  *
 **/
  public int selectMove(ArrayList<Move> alm, char myColor){
    System.out.println(myColor + "'s moves:");
    for(int i = 0; i < alm.size(); i++){
        System.out.println(alm.get(i));
    }
    scan = new Scanner(System.in);
    System.out.println("Enter the number of the move you choose.");
    int i = scan.nextInt()-1;
    //scan.close();
    return i;
  }//end  selectMove(ArrayList<Move> alm, char myColor)

/**
  * @version 1.0
  * @return boolean
  * This method checks for the winner of the game and prints out the results.
  *
 **/
  public boolean checkForWin(Move m, String loser, String winner){
    if(m.noMove() == true){
      scan.close();
      System.out.println(loser + "! you are out of moves! " + winner + "! You win!");
      System.exit(0);
    }
    return false;
  }// end of checkForWin(Move m, String loser, String winner)

/**
  * @version 1.0
  * @return void
  * This method is used to assign color to the human and agent. The human player
  * subsequently chooses what color they want to be and then the agent is assigned the
  * opposite color but default
 **/
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
      white = new Human('w', false);
      black = new Agent('b', true);
      System.out.println(black.isCPU());
    }
  }//end of chooseYourColor()

/**
  * @version 1.0
  * @return void
 **/
  public void chooseDifficulty(){
     String ans = "";
     boolean validInput = false;

     scan = new Scanner(System.in);

     //while(!validInput){
        // System.out.println();
     //}
  }

}//end of GameController class
