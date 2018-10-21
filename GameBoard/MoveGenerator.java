/**
  * @author: Francine Dennehy
  * @author: Alexandra Mullan
  * @version: 1.0
  * This class contains the methods to generate the legal moves on Kunane.
  *
 **/

 import java.util.*;

public class MoveGenerator{

  public MoveGenerator(){

  }//end of Constructor

  public ArrayList<Tuple> first_turn(char c, GameBoard currentBoardState){
     ArrayList<Tuple> legal_moves = new ArrayList<Tuple>();

    if(c == 'b'){
      legal_moves.add(new Tuple(7,7)); /* the numbers are changed because the   */
      legal_moves.add(new Tuple(0,0)); /* game board is from 0 - 7 not 1 - 8    */
      legal_moves.add(new Tuple(4,4)); /* also the numebers are stored as (y,x) */
      legal_moves.add(new Tuple(3,3));

    }
    if(c == 'w'){
      System.out.println("in white");
      
      if(currentBoardState.get_game_state(7,7) == 'e'){
          legal_moves.add(new Tuple(6,7));
          legal_moves.add(new Tuple(7,6));
      }
      else if(currentBoardState.get_game_state(0,0) == 'e'){
          legal_moves.add(new Tuple(1,2));
          legal_moves.add(new Tuple(2,1));
      }
      else if(currentBoardState.get_game_state(4,4) == 'e'){
          legal_moves.add(new Tuple(3,4));
          legal_moves.add(new Tuple(4,3));
          legal_moves.add(new Tuple(5,4));
          legal_moves.add(new Tuple(4,5));
      }
      else if(currentBoardState.get_game_state(3,3) == 'e'){
          legal_moves.add(new Tuple(2,3));
          legal_moves.add(new Tuple(3,2));
          legal_moves.add(new Tuple(4,3));
          legal_moves.add(new Tuple(3,4));
      }

    }//end of if c == 'w'

    return legal_moves;
  }//end of first_turn

  public Move[] getMoves(GameBoard currentBoardState){
    //based on the current board state return a move with active piece location,
    Move[] optionalMoves = {};
    return optionalMoves;
  }

    //based on the current board state return a move with active piece location,

public boolean legal(Tuple t){

  return true;
}

}//end of MoveGenerator class
