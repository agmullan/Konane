/**
* @author: Francine Dennehy
* @author: Alexandra Mullan
* @version: 1.5
* This class contains the methods to set up the artifical interegents.
*
**/
import java.util.*;

public class Agent extends Player{

//Declarations
 private MoveGenerator moveGenerator;
 private Strategy strategy;
 private char myColor;
 private boolean isCPU;

/**
  * @version: 2.0
  * This is the constructor for the agent class. It takes in a char denoting its color and a
  * boolean saying if it is the CPU or not.
 **/
 public Agent(char myColor, boolean isCPU){
     this.myColor = myColor;
     this.isCPU = isCPU;
     moveGenerator = new MoveGenerator();
     strategy = new Strategy(moveGenerator, 6); //max depth hard coded
  }//end of Agent(char myColor, boolean isCPU)

/**
  * @version 1.0
  * @return boolean isCPU
  * This is a getter method that returns the value of isCPU
 **/
  public boolean isCPU(){
    return isCPU;
  }//end of isCPU

/**
  * @version 1.0
  * @return char myColor
  * This is a getter method that returns the char denoting the agent's color
 **/
  public char myColor(){
    return myColor;
  }//end of myColor

/**
  * @version 1.0
  * @return ArrayList<Move> availableMoves
  * This method is called to have the agent take the first turn.
  * It returns an ArrayList<Move> of all the available moves at the start of the game.
  * It calls a method found within the MoveGenerator class to find the available moves
  * of the first turn.
 **/
 public ArrayList<Move> takeFirstTurn(GameBoard currentBoardState){
     ArrayList<Move> availableMoves = moveGenerator.first_turn(myColor,currentBoardState);
     return availableMoves;
  }//end of takeFirstTurn(GameBoard currentBoardState)

/**
  * @version 1.0
  * @return ArrayList<Move> availableMoves
  * This method is called to have the agent take its turn. This is similar to the takeTurn1()
  * medthod above. However, this is used in the subsequent turns of the game until the game
  * concludes.
  *
 **/
 public ArrayList<Move> takeTurn(GameBoard currentBoardState){
     ArrayList<Move> availableMoves = moveGenerator.getMoves(currentBoardState.gameState(), myColor);
     return availableMoves;
  }//end of takeTurn(GameBoard currentBoardState)

/**
  * @version 2.0
  * @return Move m
  * This method is used to select a move from the generated list of moves available to the
  * agent. The method first checks to see if the availableMoves ArrayList is less
  * then zero. In this case it just returns the first move generated. If the ArrayList
  * is not empty then a new move is created and returned.
 **/
 public Move chooseMove(ArrayList<Move> availableMoves, GameBoard currentBoardState, char myColor, boolean firstW){
     if(availableMoves.size() > 0){
         return strategy.alpha_beta_search(currentBoardState, myColor, availableMoves, firstW);
     }else{
         Move m = new Move(true);
         return m;
     }
  }//end chooseMove(ArrayList<Move> availableMoves)

}//end of Agent class
