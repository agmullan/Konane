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
  char myColor;

  public Agent(char myColor){
    moveGenerator = new MoveGenerator();
    this.myColor= myColor;
  }

  public GameBoard takeTurn(GameBoard currentBoardState){
    Move[] availableMoves = moveGenerator.getMoves(currentBoardState);
    Move nextMove = chooseMove(availableMoves);
    return generateBoard(nextMove, currentBoardState);
  }

  public Move chooseMove(Move[] availableMoves){
    //this is where you call the strategy
    return availableMoves[0];
  }

  public GameBoard generateBoard(Move currentMove, GameBoard currentBoardState){
    GameBoard board = currentBoardState;

    if(currentMove.removeList.size() > 0){
      for(int i = 0; i<currentMove.removeList.size(); i++){
        Tuple t = currentMove.removeList.get(i);
        board.replace(t.x,t.y,'e');
      }
      if(currentMove.currentLocation.x != -1)
        board.replace(currentMove.currentLocation.x,currentMove.currentLocation.y, 'e');
      if(currentMove.futureLocation.x != -1)
        board.replace(currentMove.futureLocation.x,currentMove.futureLocation.y, myColor);
    }
    return board;
  }
}//end of Agent class
