/**
  * @author: Francine Dennehy
  * @author: Alexandra Mullan
  * @version: 1.0
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
package GameElements;

import java.util.*;
import java.math.*;


// public class AlphaBeta{
//
// /*
//  * We should have a list of Moves that will be judged based on how many steps the
//  * opponent will have if that move is made.
//  * class strategy should be used to call this class. this will be useful for if we implement
//  * e - 2 < v < e + 2 Pruning
//  */
//
//  //Declarations
//  protected boolean advanced = false;
//
// /**
//   * This is the Constructor for AlphaBeta. This is where you declare which search the
//   * the agent is imploying. The string passed in should reg or adv to denote which
//   *
//  **/
//  public AlphaBeta(String type){
//    set_advanced(type);
//  }//end of Constructor
//
// /**
//   * @version 1.0
//   * @return void
//   * This method sets the value of the boolean advanced.
//  **/
// public void set_advanced(String type){
//   if(type.equalsIgnoreCase("adv")){
//     advanced = true;
//   }
//   else{
//     advanced = false;
//   }
// }// end of set_advanced(String type)
//
// /**
//  * @version: 1.0
//  * @return Move
//  * This function is called to perform Alphaq Beta Pruning
// **/
// public /*Move*/ void  Alpha_Beta_Search(GameBoard gb/* add */){
//   //this method is most likely going to change
//
//   int neg_infinity = Integer.MIN_VALUE;
//   int pos_infinity = Integer.MAX_VALUE;
//
//   int v = Max_Value(gb, neg_infinity, pos_infinity);
//
//   //needs to return a move for the player to perform
//
// }//end of Alpha_Beta_Search
//
// /**
//  * @version 1.1
//  * @return int v
//  * This finds the max value for the utility state.
// **/
// public int Max_Value(GameBoard gb, /* Moves ,*/ int alpha, int beta, int utility){
//   int v = Integer.MIN_VALUE;
//
//   if(advanced == true){
//
//     if((util - 2) >= beta){
//       return (util - 2 );
//     }//end if
//
//   }
//
//   /* for */
//   /* this loop would based on the list of states that could be possible */
//   int temp = 0; //this needs to change
//
//
//   if(advanced == true){
//     v = Math.max(v, MIN(child , Math.max(alpha, (util - 2)), Math.min(beta, (util + 2))));
//   }
//   else{
//     v = Math.max(v, MIN(temp ,alpha, beta));
//   }
//
//   if(v >= beta){
//     return v;
//   }
//   alpha = Math.max(alpha, v);
//  /* end of for */
//
//   return v;
// }//end of Max_Value()
//
// /**
//  * @version 1.0
//  * @return int result
//  * This is a helper function that is used in Min_Value when it needs to return
//  * the max value of three different numbers.
// **/
// public int MAX(int a, int b, int c){
//   int temp = Math.max(a,b);
//   int result = Math.max(temp, c);
//   return result;
// } //end of MAX
//
// /**
//  * @version 1.1
//  * @return int v
//  * This finds the min value for the utility state.
// **/
// public int Min_Value(GameBoard gb, /* Moves ,*/ int alpha, int beta, int utility){
//   int v = Integer.MAX_VALUE;
//
//   if(advanced == true){
//
//     if((util + 2) <= alpha){
//       return (util + 2 );
//     }//end if
//
//   }
//
//   /* for */
//   /* this loop would based on the list of states that could be possible */
//   int temp = 0; //this needs to change
//
//   if(advanced == true){
//       v = Math.min(v, MAX(child , Math.max(alpha, (util - 2)), Math.min(beta, (util + 2))));
//   }
//   else{
//       v = Math.min(v, MAX(temp ,alpha, beta));
//   }
//
//   if(v <= alpha){
//     return v;
//   }
//   beta = Math.min(beta, v);
//  /* end of for */
//   return v;
// }//end of Min_Value()
//
// /**
//  * @version 1.0
//  * @return int result
//  * This is a helper function that is used in Max_Value when it needs to return
//  * the min value of three different numbers.
// **/
// public int MIN(int a, int b, int c){
//   int temp = Math.min(a,b);
//   int result = Math.min(temp, c);
//   return result;
// }//end of MIN

//}
