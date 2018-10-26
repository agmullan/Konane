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
  * @version: 1.5
  * This is the constructor for the agent class. It takes in a char denoting its color and a
  * boolean saying if it is the CPU or not.
 **/
  public Agent(char myColor, boolean isCPU){
    this.myColor = myColor;
    this.isCPU = isCPU;
    moveGenerator = new MoveGenerator(myColor);
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
    return availableMoves; //chooseMove(availableMoves);
  }//end of takeFirstTurn(GameBoard currentBoardState)

/**
  * @version 1.0
  * @return Move chooseMove(availableMoves)
  * This method is called to have the agent take its first turn which relays on
  * a different method found within the MoveGenerator class. This like the above method
  * returns an ArrayList<Move> of all the available moves the agent has at that time.
  *
 **/
  public Move takeTurn1(GameBoard currentBoardState){

    ArrayList<Move> availableMoves = moveGenerator.getMoves(currentBoardState.gameState());

    if(availableMoves.size() == 0){
        return new Move(true);
    }
    //Move nextMove = ;
    return chooseMove(availableMoves);
  }//end of takeTurn1(GameBoard currentBoardState)

/**
  * @version 1.0
  * @return ArrayList<Move> availableMoves
  * This method is called to have the agent take its turn. This is similar to the takeTurn1()
  * medthod above. However, this is used in the subsequent turns of the game until the game
  * concludes.
  *
 **/
  public ArrayList<Move> takeTurn(GameBoard currentBoardState){
    ArrayList<Move> availableMoves = moveGenerator.getMoves(currentBoardState.gameState());
    return availableMoves;
  }//end of takeTurn(GameBoard currentBoardState)

/**
  * @version 1.0
  * @return Move m
  * This method is used to select a move from the generated list of moves available to the
  * agent. The method first checks to see if the availableMoves ArrayList is less
  * then zero. In this case it just returns the first move generated. If the ArrayList
  * is not empty then a new move is created and returned.
  * !MODIFY!
 **/
  public Move chooseMove(ArrayList<Move> availableMoves){
    //this is where you call the strategy
    if(availableMoves.size() > 0){
      return availableMoves.get(0);
    }else{
        Move m = new Move(true);
        return m;
    }
  }//end chooseMove(ArrayList<Move> availableMoves)

/**
  * @version 1.0
  * @return Move m
  *
  *
  *
 **/
  public Move playerChooseMove(ArrayList<Move> availableMoves, int i){
    if(availableMoves.size() > 0){
      return availableMoves.get(i);
    }else{
        Move m = new Move(true);
        return m;
    }
  }//end of playerChooseMove(ArrayList<Move> availableMoves, int i)

}//end of Agent class
