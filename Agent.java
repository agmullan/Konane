/**
* @author: Francine Dennehy
* @author: Alexandra Mullan
* @version: 1.0
* This class contains the methods to set up the artifical interegents.
*
**/
public class Agent extends Player{

  MoveGenerator moveGenerator;
  Strategy strategy;

  public Agent(){
    moveGenerator = new MoveGenerator();
  }

  public char[][] takeTurn(char[][] currentBoardState){
    Move[] availableMoves = moveGenerator.getMoves(currentBoardState);
    Move nextMove = chooseMove(availableMoves);
    return generateBoard(nextMove);
  }

  public Move chooseMove(Move[] availableMoves){
    //this is where you call the strategy
    return availableMoves[0];
  }

  public char[][] generateBoard(Move currentMove){
    char[][] gameState = new char[8][8];

    //if(currentMove.removeList.size() == 0);
    return gameState;
  }
}//end of Agent class
