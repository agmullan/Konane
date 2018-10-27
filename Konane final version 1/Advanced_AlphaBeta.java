/**
 * @author: Francine Dennehy
 * @author: Alexandra Mullan
 * @version: 1.0
 * */

import java.util.*;
import java.math.*;

public class Advanced_AlphaBeta{

    /*
     * We should have a list of Moves that will be judged based on how many steps the
     * opponent will have if that move is made.
     * class strategy should be used to call this class. this will be useful for if we implement
     * e - 2 < v < e + 2 Pruning
     */



    /**
     * @version: 1.0
     * This function is called to perform Alphaq Beta Pruning
     **/
    public /*Move*/ void  Advanced_Alpha_Beta_Search(GameBoard gb, MoveGenerator mG, ArrayList<Move> possibleMoves){
        //this method is most likely going to change

        int neg_infinity = Integer.MIN_VALUE;
        int pos_infinity = Integer.MAX_VALUE;
        int temp = 0;

        int v = Max_Value(gb, neg_infinity, pos_infinity, temp);

        //needs to return a move for the player to perform

    }//end of Alpha_Beta_Search

    /**
     * @version 1
     * This finds the max value for the utility state.
     **/
    public int Max_Value(GameBoard gb, /* Moves ,*/ int alpha, int beta, int util){
        int v = Integer.MIN_VALUE;

        if((util - 2) >= beta){
            return (util - 2 );
        }//end if

        /* for */
        /* this loop would based on the list of states that could be possible */
        int child = 0; //this needs to change
        v = Math.max(v, MIN(child , Math.max(alpha, (util - 2)), Math.min(beta, (util + 2))));

        if(v >= beta){
            return v;
        }
        alpha = Math.max(alpha, v);
        /* end of for */

        return v;
    }//end of Max_Value()

    /**
     * @version 1
     * This is a helper function that is used in Min_Value when it needs to return
     * the max value of three different numbers.
     **/
    public int MAX(int a, int b, int c){
        int temp = Math.max(a,b);
        int result = Math.max(temp, c);
        return result;
    } //end of MAX

    /**
     * @version 1
     * This finds the min value for the utility state.
     **/
    public int Min_Value(GameBoard gb, /* Moves ,*/ int alpha, int beta, int util){
        int v = Integer.MAX_VALUE;

        if((util + 2) <= alpha){
            return (util + 2 );
        }//end if

        /* for */
        /* this loop would based on the list of states that could be possible */
        int child = 0; //this needs to change
        v = Math.min(v, MAX(child , Math.max(alpha, (util - 2)), Math.min(beta, (util + 2)) ));
        if(v <= alpha){
            return v;
        }
        beta = Math.min(beta, v);
        /* end of for */
        return v;
    }//end of Min_Value()

    /**
     * @version 1
     * @return int result
     * This is a helper function that is used in Max_Value when it needs to return
     * the min value of three different numbers.
     **/
    public int MIN(int a, int b, int c){
        int temp = Math.min(a,b);
        int result = Math.min(temp, c);
        return result;
    }//end of MIN
}//end of AlphaBeta class
