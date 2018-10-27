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
        moveGenerator = new MoveGenerator();
        strategy = new Strategy(moveGenerator, 6); //max depth hard coded
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

        ArrayList<Move> availableMoves = moveGenerator.getMoves(currentBoardState.gameState(),myColor);

        if(availableMoves.size() == 0){
            return new Move(true);
        }
        //Move nextMove = ;
        return chooseMove(availableMoves, currentBoardState, myColor);
    }

    public ArrayList<Move> takeTurn(GameBoard currentBoardState){

        ArrayList<Move> availableMoves = moveGenerator.getMoves(currentBoardState.gameState(), myColor);
        return availableMoves;
    }

    public Move chooseMove(ArrayList<Move> availableMoves, GameBoard currentBoardState, char myColor){
        //this is where you call the strategy
        if(availableMoves.size() > 0){
            return strategy.alpha_beta_search(currentBoardState, myColor);

        }else{
            Move m = new Move(true);
            return m;
        }
    }

    //     public Move playerChooseMove(){
    //         if(availableMoves.size() > 0){
    //            
    //         }else{
    //             Move m = new Move(true);
    //             return m;
    //         }
    //     }
}//end of Agent class
