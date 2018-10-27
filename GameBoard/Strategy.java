/**
  * @author: Francine Dennehy
  * @author: Alexandra Mullan
  * @version: 1.5
  *
  * Algorithm from book:
  *  funtion Alpha-Beta-Search(state) return an action
  *    v <- Max-Value(state, -infin, + infin)
  *    return the action in Actions(state) with value v
  *
  * function Max-Value(state, alpha, beta) returns a utility Value
  *    if Terminal-Test(state) then return Utility(state)
  *    v <- -infin
  *    for each a in Actions(state) do
  *      v <- Max(v, Min-Value(Result(s,a), alpha, beta))
  *      if v >= Beta then return v
  *      alpha <- MAX(alpha, v)
  *    return v
  *
  * function Min-Value(state, alpha, beta) returns a utility Value
  *    if Terminal-Test(state) then return Utility(state)
  *    v <- +infin
  *    for each a in Actions(state) do
  *      v <- Min(v, Max-Value(Result(s,a), alpha, beta))
  *      if v <= alpha then return v
  *      Beta <- MIN(Beta, v)
  *    return v
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


  public Move alpha_beta_search(GameBoard gb, char myColor, ArrayList<Move> c, boolean firstW){ //Move currentMove
      Move m = new Move();
      Move v;
      if(firstW){
          v = max(gb.gameState(), m, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, myColor, c);
      }else{
          v = max(gb.gameState(), m, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, myColor, null);
      }
      return v;
  }

  public Move min(char[][] gb, Move m, int alpha, int beta, int currentDepth, char myColor){ //"returns a utility value" in this case it will return the whole move which contains a utlity value
      m.setV(Integer.MAX_VALUE); //v = Integer.MAX_VALUE;
       ArrayList<Move> availableMoves = mG.getMoves(gb, myColor);

      if(terminal_test(m, gb, currentDepth, myColor, availableMoves))
          return m;

      for(int i = 0; i<availableMoves.size(); i++){//for each move in the set of available moves
          char[][] tempBoard = mG.tempBoard(gb, availableMoves.get(i).currentLocation(), availableMoves.get(i).futureLocation(),myColor);
          m.setV(fourMin(m.getV(), max(tempBoard, availableMoves.get(i), alpha, beta, currentDepth+1, myColor, null).getV(), alpha, beta));
          if(m.getV() <= alpha){
              return m;
          }
          beta = Math.min(beta, m.getV());
      }
      return m;
  }

  public Move max(char[][] gb, Move m, int alpha, int beta, int currentDepth, char myColor, ArrayList<Move> c){
      m.setV(Integer.MIN_VALUE);
      ArrayList<Move> availableMoves = mG.getMoves(gb, myColor);

      if(terminal_test(m, gb, currentDepth, myColor, availableMoves))
          return m;

      for(int i = 0; i<availableMoves.size(); i++){//for each move in the set of available moves
          char[][] tempBoard = mG.tempBoard(gb, availableMoves.get(i).currentLocation(), availableMoves.get(i).futureLocation(), myColor);
          m.setV(fourMax(m.getV(), min(tempBoard, availableMoves.get(i), alpha, beta, currentDepth+1, myColor).getV(), alpha, beta));
          if(m.getV() >= beta){
              return m;
          }
          alpha = Math.max(alpha, m.getV());
      }
      return m;
  }

  public boolean terminal_test(Move m, char[][] gb, int currentDepth, char myColor, ArrayList<Move> moves){
      if(moves.size() == 0)
         return true;
      if(currentDepth == maxDepth){
          m.calculateUtility(gb, mG, myColor);
          return true;
      }
      return false;
  }

/**
 * @version 1.5
 * @return int result
 * This is a helper function that is used when it needs to return
 * the max value of four different numbers.
**/
  public int fourMin(int a, int b, int c, int d){
      int t1 = Math.min(a,b);
      int t2 = Math.min(t1,c);
      int t3 = Math.min(t2,d);
      return t3;
  }

/**
 * @version 1.0
 * @return int result
 * This is a helper function that is used when it needs to return
 * the max value of four different numbers.
**/
  public int fourMax(int a, int b, int c, int d){
      int t1 = Math.max(a,b);
      int t2 = Math.max(t1,c);
      int t3 = Math.max(t2,d);
      return t3;
  }
}
