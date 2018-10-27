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
    private Strategy      strategy;
    private char          myColor;
    private boolean       isCPU;
    private int           maxDepth;
    private int           speed;


    public Agent(char myColor, boolean isCPU){
        this.myColor  = myColor;
        this.isCPU    = isCPU;
        moveGenerator = new MoveGenerator();
        strategy      = new Strategy(moveGenerator, maxDepth, speed);
    }

    public void addStrategySettings(int sp, int mD){
      speed    = sp;
      maxDepth = mD;
    }

    public boolean isCPU(){
        return isCPU;
    }

    public char myColor(){
        return myColor;
    }

    public ArrayList<Move> takeFirstTurn(GameBoard currentBoardState){
        ArrayList<Move> availableMoves = moveGenerator.first_turn(myColor,currentBoardState);
        return availableMoves;
    }

    public ArrayList<Move> takeTurn(GameBoard currentBoardState){
        ArrayList<Move> availableMoves = moveGenerator.getMoves(currentBoardState.gameState(), myColor);
        return availableMoves;
    }

    public Move chooseMove(ArrayList<Move> availableMoves, GameBoard currentBoardState, char myColor, boolean firstW){
        if(availableMoves.size() > 0){
            Move m = strategy.strategyGo(currentBoardState, myColor, availableMoves, firstW);
            printMove(m);
            return m;
        }else{
            Move m = new Move(true);
            return m;
        }
      }
    public void printMove(Move m){
      String myName = "";
      String message = "";
      String opponent = "";

      if(myColor == 'b'){
        myName = "Black";
        opponent = "w";
      }

      if(myColor == 'w'){
        myName = "White";
        opponent = "b";
      }

      message = myName + " moves " + opponent + " from " + m.cLX() + " " + m.cLY() + " to " + m.fLX() + " " + m.fLY();
      message+=", removing " + m.removeList().toString();
      System.out.println(message);
    }
}//end of Agent class
