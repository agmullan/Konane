/**
 * @author: Francine Dennehy
 * @author: Alexandra Mullan
 * @version: 1.0
 * This class contains the methods to set up the Human Agent. This class is similar to
 * that of Agent expect the inputs from this class should be provided for by the human player.
 **/

import java.io.*;
import java.util.Scanner;
import java.util.*;

public class Human extends Player{
  //Declarations
    private char myColor;
    private MoveGenerator moveGenerator;
    private boolean isCPU;

/**
  * @version: 1.5
  * This is the constructor for the Human class. It takes in a char denoting its color and a
  * boolean saying if it is the CPU or not.
 **/
  public Human(char myColor, boolean isCPU){
      this.myColor = myColor;
      this.isCPU = isCPU;
      moveGenerator = new MoveGenerator(myColor);
  }// end of  Human(char myColor, boolean isCPU)

/**
  * @version: 1.0
  * This is a getter method that returns the value of isCPU
 **/
  public boolean isCPU(){
      return isCPU;
  }//end of isCPU()

/**
  * @version: 1.0
  * This is a getter method that returns the char denoting the agent's color
 **/
  public char myColor(){
      return myColor;
  }//end myColor()

/**
  * @version: 1.0
  * This method is called to have the Human take the first turn.
  * It returns an ArrayList<Move> of all the available moves at the start of the game.
  * It calls a method found within the MoveGenerator class to find the available moves
  * of the first turn.
 **/
  public ArrayList<Move> takeFirstTurn(GameBoard currentBoardState){
      ArrayList<Move> availableMoves = moveGenerator.first_turn(myColor,currentBoardState);
      return availableMoves; //chooseMove(availableMoves);
  }// end if takeFirstTurn(GameBoard currentBoardState)

/**
  * @version: 1.0
  * This method is called to have the human take its first turn which relays on
  * a different method found within the MoveGenerator class. This like the above method
  * returns an ArrayList<Move> of all the available moves the agent has at that time.
  *
 **/
  public ArrayList<Move> takeTurn(GameBoard currentBoardState){
      ArrayList<Move> availableMoves = moveGenerator.getMoves(currentBoardState.gameState());
      return availableMoves;
  }//end of takeTurn(GameBoard currentBoardState)

/**
  * @version: 1.0
  * This method is used to select a move from the generated list of moves available to the
  * agent. The method first checks to see if the availableMoves ArrayList is less
  * then zero. In this case it just returns the first move generated. If the ArrayList
  * is not empty then a new move is created and returned.
 **/
  public Move chooseMove(ArrayList<Move> availableMoves){
      if(availableMoves.size() > 0){
          return availableMoves.get(0);
      }else{
          Move m = new Move(true);
          return m;
      }
  }//end of chooseMove(ArrayList<Move> availableMoves)

/**
  * @version: 1.0
  *
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

}//end of Human class
