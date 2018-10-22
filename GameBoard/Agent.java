/**
* @author: Francine Dennehy
* @author: Alexandra Mullan
* @version: 1.0
* This class contains the methods to set up the artifical interegents.
*
**/
import java.util.*;

public class Agent extends Player{

  private MoveGenerator moveGenerator;
  private Strategy strategy;
  private char myColor;
  private boolean isCPU;

  public Agent(char myColor, boolean isCPU){
    this.myColor = myColor;
    this.isCPU = isCPU;
    moveGenerator = new MoveGenerator(myColor);
  }

  public boolean isCPU(){
    return isCPU;
  }
  
    public char myColor(){
      return myColor;
    }

  public ArrayList<Move> takeFirstTurn(GameBoard currentBoardState){
    ArrayList<Move> availableMoves = moveGenerator.first_turn(myColor,currentBoardState);
    return availableMoves; //chooseMove(availableMoves);
  }

  public Move takeTurn1(GameBoard currentBoardState){

    ArrayList<Move> availableMoves = moveGenerator.getMoves(currentBoardState.gameState());

    if(availableMoves.size() == 0){
        return new Move(true);
    }
    //Move nextMove = ;
    return chooseMove(availableMoves);
  }

  public ArrayList<Move> takeTurn(GameBoard currentBoardState){

    ArrayList<Move> availableMoves = moveGenerator.getMoves(currentBoardState.gameState());
    //Move nextMove = ;
    return availableMoves;
  }

  public Move chooseMove(ArrayList<Move> availableMoves){
    //this is where you call the strategy
    if(availableMoves.size() > 0){
      return availableMoves.get(0);
    }else{
        Move m = new Move(true);
        return m;
    }
  }

  public Move playerChooseMove(ArrayList<Move> availableMoves, int i){
    if(availableMoves.size() > 0){
      return availableMoves.get(i);
    }else{
        Move m = new Move(true);
        return m;
    }
  }

  // public GameBoard generateBoard(Move curMov, GameBoard currentBoardState){
  //
  //   System.out.println(curMov.removeList.get(0).toString());
  //
  //   GameBoard board = currentBoardState;
  //
  //   if(curMov.removeList.size() > 0){
  //     for(int i = 0; i<curMov.removeList.size(); i++){
  //       Tuple t = curMov.removeList.get(i);
  //       board.replace(t,'e');
  //     }
  //   }
  //
  //     if(curMov.currentLocation.x != -1)
  //       board.replace(curMov.currentLocation, 'e');
  //
  //     if(curMov.futureLocation.x != -1)
  //       board.replace(curMov.futureLocation, myColor);
  //
  //   return board;
  // }
}//end of Agent class
