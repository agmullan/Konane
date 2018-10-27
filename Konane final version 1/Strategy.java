/**
 * @author: Francine Dennehy
 * @author: Alexandra Mullan
 * @version: 1.0
 * This class contains the methods to set up the artificial intelligence.
 *
 **/

import java.util.*;
import java.math.*;

public class Strategy{

    int maxDepth;
    MoveGenerator mG;

    public Strategy(MoveGenerator mG, int maxDepth){
        this.mG = mG;
        this.maxDepth = maxDepth;
    }

    //STATE = GameBoard
    //ACTIONS = ARRAYLIST<MOVE>

    public Move alpha_beta_search(GameBoard gb, char myColor){ //Move currentMove
        Move m = new Move();
        Move v = max(gb.gameState(), m, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, myColor);
        return v;
    }

    public Move min(char[][] gb, Move m, int alpha, int beta, int currentDepth, char myColor){ //"returns a utility value" in this case it will return the whole move which contains a utlity value
        m.setV(Integer.MAX_VALUE); //v = Integer.MAX_VALUE;
        if(terminal_test(m, gb, currentDepth, myColor)){
            return m;
        }
        ArrayList<Move> availableMoves = mG.getMoves(gb, myColor);
        for(int i = 0; i< availableMoves.size(); i++){//for each move in the set of available moves
            char[][] tempBoard = mG.tempBoard(gb, availableMoves.get(i).currentLocation(), availableMoves.get(i).futureLocation(),myColor);
            m.setV(fourMin(m.getV(), max(tempBoard, availableMoves.get(i), alpha, beta, currentDepth+1, myColor).getV(), alpha, beta));
            if(m.getV() <= alpha){
                return m;
            }
            beta = Math.min(beta, m.getV());
        }
        return m;
    }

    public Move max(char[][] gb, Move m, int alpha, int beta, int currentDepth, char myColor){
        m.setV(Integer.MIN_VALUE);
        if(terminal_test(m, gb, currentDepth, myColor))
            return m;
        ArrayList<Move> availableMoves = mG.getMoves(gb, myColor);
        for(int i = 0; i< availableMoves.size(); i++){//for each move in the set of available moves
            char[][] tempBoard = mG.tempBoard(gb, availableMoves.get(i).currentLocation(), availableMoves.get(i).futureLocation(), myColor);
            m.setV(fourMax(m.getV(), min(tempBoard, availableMoves.get(i), alpha, beta, currentDepth+1, myColor).getV(), alpha, beta));
            if(m.getV() >= beta){
                return m;
            }
            alpha = Math.max(alpha, m.getV());
        }
        return m;
    }

    public boolean terminal_test(Move m, char[][] gb, int currentDepth, char myColor){
        if(m.noMove()) //change
            return false;
        if(currentDepth == maxDepth){
            m.calculateUtility(gb, mG, myColor);
            return false;
        }
        return true;
    }

    public int fourMin(int a, int b, int c, int d){
        int t1 = Math.min(a,b);
        int t2 = Math.min(t1,c);
        int t3 = Math.min(t2,d);
        return t3;
    }

    public int fourMax(int a, int b, int c, int d){
        int t1 = Math.max(a,b);
        int t2 = Math.max(t1,c);
        int t3 = Math.max(t2,d);
        return t3;
    }

    public void random(){

    }
}

